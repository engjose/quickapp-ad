package com.qyys.quickapp.repository.impl;
import com.qyys.quickapp.intergration.id.IdWorker;
import com.qyys.quickapp.pojo.po.UserPO;
import com.qyys.quickapp.repository.IUserRepository;
import com.qyys.quickapp.repository.mapper.UserMapper;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import java.util.Date;

/**
 * @author : Yuan.Pan 2022/4/16 1:40 PM
 */
@Repository
public class UserRepository implements IUserRepository {

    @Autowired
    private IdWorker idWorker;

    @Autowired
    private UserMapper userMapper;

    @Override
    public UserPO selectUser(String userName) {
        return userMapper.selectByUserName(userName);
    }

    @Override
    public UserPO save(String userName, String password) {
        UserPO record = new UserPO();
        record.setUserName(userName);
        record.setAddTime(new Date());
        record.setUpdateTime(new Date());
        record.setUserId(idWorker.nextId(null));
        record.setPassword(DigestUtils.md5Hex(password.getBytes()));
        userMapper.insertSelective(record);
        return record;
    }
}
