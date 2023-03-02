package edu.fit.service;

import edu.fit.pojo.User;

public interface IUserService {
    User selectUser(String username);
    int insertUser(User user);
}
