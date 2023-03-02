package edu.fit.controller;

import edu.fit.api.CommonResult;
import edu.fit.api.JWTutil;
import edu.fit.pojo.Admin;
import edu.fit.service.IAdminService;
import io.jsonwebtoken.Claims;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/back")
public class UserAdminController {
    @Autowired
    private IAdminService adminService;


    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public CommonResult login(@RequestBody Admin admin){
        Admin adminToLogin = adminService.findAdminToLogin(admin);
        if (adminToLogin == null){
            return CommonResult.failed("用户不存在");
        }else {
            String token = JWTutil.generateToken(adminToLogin.getAdminLoginname());
            Map<String,String> data = new HashMap<>();
            data.put("token",token);
            return CommonResult.success(token);
        }
    }

    @RequestMapping("/getInfo")
    public CommonResult getInfo(){
        HttpServletRequest request = ((ServletRequestAttributes) (RequestContextHolder.currentRequestAttributes())).getRequest();
        String token = request.getHeader("Authorization");
        Claims claimsByToken = JWTutil.getClaimsByToken(token);
        String adminLoginname = claimsByToken.getSubject();
        Admin adminToGetInfo = adminService.findAdminToGetInfo(adminLoginname);
        return CommonResult.success(adminToGetInfo);
    }
    @RequestMapping(value = "/getcourierlist",method = RequestMethod.GET)
    public CommonResult getCourierList(){
        HttpServletRequest request = ((ServletRequestAttributes) (RequestContextHolder.currentRequestAttributes())).getRequest();
        String token = request.getHeader("Authorization");
        Claims claimsByToken = JWTutil.getClaimsByToken(token);
        String adminLoginname = claimsByToken.getSubject();
        if(adminLoginname.equals("admin")){
            List<Admin> admins = adminService.selectAllCourierList();
            return CommonResult.success(admins);
        }else {
            return CommonResult.failed();
        }
    }
    @RequestMapping("/addcourier")
    public CommonResult addCourier(@RequestBody Admin courier){
        int i = adminService.insertCourier(courier);
        if(i==1){
            return CommonResult.success("创建成功");
        }else {
            return CommonResult.failed("创建失败");
        }
    }

    @RequestMapping(value = "/updatastate",method = RequestMethod.POST)
    public CommonResult updateState(@RequestBody Admin admin){
        int i = adminService.updateState(admin);
        if (i==1){
            return CommonResult.success("修改成功");
        }else {
            return CommonResult.failed("修改失败");
        }
    }
    @RequestMapping(value = "/updatacourier",method = RequestMethod.POST)
    public CommonResult updataCourier(@RequestBody Admin admin){
        int i = adminService.updataCourier(admin);
        if (i==1){
            return CommonResult.success("修改成功");
        }else {
            return CommonResult.failed("修改失败");
        }
    }
    @RequestMapping(value = "/delcourier",method = RequestMethod.POST)
    public CommonResult delCourier(@RequestBody Admin admin){
        int i = adminService.delCourierById(admin.getAdminId());
        if(i==1){
            return CommonResult.success("删除成功");
        }else {
            return CommonResult.failed("删除失败");
        }
    }
}
