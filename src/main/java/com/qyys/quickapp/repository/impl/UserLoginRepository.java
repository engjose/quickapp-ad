package com.qyys.quickapp.repository.impl;
import com.qyys.quickapp.intergration.id.IdWorker;
import com.qyys.quickapp.pojo.po.UserLoginPO;
import com.qyys.quickapp.repository.IUserLoginRepository;
import com.qyys.quickapp.repository.mapper.UserLoginMapper;
import org.apache.commons.lang3.time.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import java.util.Date;

/**
 * @author : Yuan.Pan 2022/4/16 1:41 PM
 */
@Repository
public class UserLoginRepository implements IUserLoginRepository {

    @Autowired
    private IdWorker idWorker;

    @Autowired
    private UserLoginMapper userLoginMapper;

    @Override
    public void delete(String userId) {
        userLoginMapper.deleteByUserId(userId);
    }

    @Override
    public String login(String userId) {
        UserLoginPO record = new UserLoginPO();
        record.setUserId(userId);
        record.setAddTime(new Date());
        record.setLoginToken(idWorker.nextId("TOKEN"));
        record.setExpiredTime(DateUtils.addDays(new Date(), 7));
        return record.getLoginToken();
    }

    @Override
    public UserLoginPO selectByToken(String xToken) {
        return userLoginMapper.selectByToken(xToken);
    }
}
