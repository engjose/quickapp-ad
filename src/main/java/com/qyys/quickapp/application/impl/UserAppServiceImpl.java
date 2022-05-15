package com.qyys.quickapp.application.impl;
import com.qyys.quickapp.application.UserAppService;
import com.qyys.quickapp.common.exception.BusinessException;
import com.qyys.quickapp.common.exception.ExceptionEnum;
import com.qyys.quickapp.intergration.id.IdWorker;
import com.qyys.quickapp.pojo.po.UserLoginPO;
import com.qyys.quickapp.pojo.po.UserPO;
import com.qyys.quickapp.repository.IUserLoginRepository;
import com.qyys.quickapp.repository.IUserRepository;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.Date;

/**
 * @author : Yuan.Pan 2022/4/16 3:51 PM
 */
@Service
public class UserAppServiceImpl implements UserAppService {

    @Autowired
    private IdWorker idWorker;

    @Autowired
    private IUserRepository iUserRepository;

    @Autowired
    private IUserLoginRepository iUserLoginRepository;

    @Transactional
    @Override
    public String register(String userName, String password) {
        UserPO exist = iUserRepository.selectUser(userName);
        if (null != exist) {
            throw new BusinessException(ExceptionEnum.USER_NAME_HAS_REGISTER);
        }

        UserPO record = iUserRepository.save(userName, password);
        return login(record.getUserId());
    }

    @Transactional
    @Override
    public String login(String userName, String password) {
        UserPO exist = iUserRepository.selectUser(userName);
        if (null == exist) {
            throw new BusinessException(ExceptionEnum.USER_IS_NOT_EXIST);
        }

        if (!exist.getPassword().equals(DigestUtils.md5Hex(password.getBytes()))) {
            throw new BusinessException(ExceptionEnum.USER_PASSWORD_ERR);
        }

        return this.login(exist.getUserId());
    }

    @Override
    public String authLogin(String xToken) {
        if (null == xToken) {
            throw new BusinessException(ExceptionEnum.NOT_LOGIN_ERR);
        }

        UserLoginPO exist = iUserLoginRepository.selectByToken(xToken);
        if (null == exist) {
            throw new BusinessException(ExceptionEnum.NOT_LOGIN_ERR);
        }

        if (new Date().after(exist.getExpiredTime())) {
            throw new BusinessException(ExceptionEnum.LOGIN_INVALID);
        }

        return exist.getUserId();
    }

    private String login(String userId) {
        iUserLoginRepository.delete(userId);
        return iUserLoginRepository.login(userId);
    }
}
