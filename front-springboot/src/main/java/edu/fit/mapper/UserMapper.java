package edu.fit.mapper;

import edu.fit.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;
@Mapper
public interface UserMapper {

    public User selectUser(String username);
    int insertUser(User user);
}
