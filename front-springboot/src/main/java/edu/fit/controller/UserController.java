package edu.fit.controller;

import edu.fit.api.CommonResult;
import edu.fit.api.JWTutil;
import edu.fit.pojo.User;
import edu.fit.qo.UserInfoQo;
import edu.fit.service.IUserService;
import io.jsonwebtoken.Claims;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@RestController
public class UserController {

    @Autowired
    private IUserService userService;

    @RequestMapping("/login")
    public CommonResult login(@RequestBody User user){
        String userName = user.getUserName();
        String password = user.getPassWord();
        User user1 = userService.selectUser(user.getUserName());
        //判断登录名是否为空
        if(userName.equals("") || userName==null){
            return CommonResult.failed("登录名为空");
        }
        //判断密码是否为空
        if (password.equals("") || password==null){
            return CommonResult.failed("密码不能为空");
        }
        password = password.trim();
        //判断密码是否符合规范
        if (password.length() < 6 || password.length() > 20 ){
            return CommonResult.failed("密码长度不符合规范");
        }
        if (user1==null){
            return CommonResult.validateFailed("登录失败,登录名或密码错误");
        }
        if(user.getUserName().equals(user1.getUserName())
                && user.getPassWord().equals(user1.getPassWord())){
            String token = JWTutil.generateToken(userName);
            Map<String,Object> data = new HashMap<>();
            data.put("token",token);
            return CommonResult.success(data);
        }else {
            return CommonResult.validateFailed("登录失败,登录名或密码错误");
        }

    }

    @RequestMapping ("/user/getInfo")
    public User getInfo(@RequestBody String token){
        Claims claimsByToken = JWTutil.getClaimsByToken(token);
        String username = claimsByToken.getSubject();
        return userService.selectUser(username);
    }

    @RequestMapping("/register")
    public CommonResult register(@RequestBody UserInfoQo userInfoQo){
        //进行数据校验
        String userName = userInfoQo.getUserName();
        String password = userInfoQo.getPassword();
        String checkpass = userInfoQo.getCheckpass();

        //判断登录名是否为空
        if(userName.equals("") || userName==null){
            return CommonResult.failed("登录名为空");
        }
        //判断用户名是否符合规范
        userName = userName.trim();
        if (userName.length() < 6 || userName.length() > 20){
            return  CommonResult.failed("用户名不符合规范");
        }
        //判断密码是否为空
        if (password.equals("") || password==null){
            return CommonResult.failed("密码不能为空");
        }
        password = password.trim();
        //判断密码是否符合规范
        if (password.length() < 6 || password.length() > 20 ){
            return CommonResult.failed("密码长度不符合规范");
        }
        //判断确认密码是否为空
        if (checkpass.equals("") || checkpass==null){
            return CommonResult.failed("确认密码不能为空");
        }
        //判断确认密码是否等于密码
        if(!checkpass.equals(password)){
            return CommonResult.failed("两次输入的密码不一致");
        }
//        当前置校验通过后，进行一次数据库数据校验，相同的用户名无法重复注册
        User user = userService.selectUser(userName);
        if(user!=null){
            return CommonResult.failed("用户已存在");
        }
        User user1 = new User();
        user1.setUserName(userName);
        user1.setPassWord(password);
        int i = userService.insertUser(user1);
        if (i==1){
            return CommonResult.success("注册成功");
        }else {
            return CommonResult.failed("注册失败");
        }
    }


}
