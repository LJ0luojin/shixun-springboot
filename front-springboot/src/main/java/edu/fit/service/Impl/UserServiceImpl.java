package edu.fit.service.Impl;

import edu.fit.mapper.UserMapper;
import edu.fit.pojo.User;
import edu.fit.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements IUserService {
    @Autowired
    private UserMapper userMapper;
    @Override
    public User selectUser(String username) {
        return userMapper.selectUser(username);
    }

    @Override
    public int insertUser(User user) {
        return userMapper.insertUser(user);
    }
}
