package edu.fit.controller;

import edu.fit.api.CommonResult;
import edu.fit.api.ItemToResultUtil;
import edu.fit.api.JWTutil;
import edu.fit.pojo.Admin;
import edu.fit.pojo.ExpressItem;
import edu.fit.service.IAdminService;
import edu.fit.service.IExpressItemService;
import io.jsonwebtoken.Claims;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController()
@RequestMapping("/back")
public class ExpressItemController {
    @Autowired
    private IExpressItemService expressItemService;

    @Autowired
    private IAdminService adminService;
    @RequestMapping(value = "/geteilist",method = RequestMethod.GET)
    public CommonResult getEiList(){
        HttpServletRequest request = ((ServletRequestAttributes) (RequestContextHolder.currentRequestAttributes())).getRequest();
        String token = request.getHeader("Authorization");
        Claims claimsByToken = JWTutil.getClaimsByToken(token);
        String adminLoginname = claimsByToken.getSubject();
        if(adminLoginname.equals("admin")){
            List<ExpressItem> expressItems = expressItemService.selectAllEi();
            return CommonResult.success(ItemToResultUtil.getResultList(expressItems));
        }else if(adminLoginname.equals("") || adminLoginname == null){
            return CommonResult.failed("未登录");
        }else{
            String courierName = adminLoginname;
            Admin adminToGetInfo = adminService.findAdminToGetInfo(courierName);
            int courierId = adminToGetInfo.getAdminId();
            List<ExpressItem> expressItems = expressItemService.selectForCourier(courierId);
            return CommonResult.success(ItemToResultUtil.getResultList(expressItems));
        }
    }
    @RequestMapping(value = "/geteilistbystate",method = RequestMethod.GET)
    public CommonResult getEiListByState(int eiState){
        HttpServletRequest request = ((ServletRequestAttributes) (RequestContextHolder.currentRequestAttributes())).getRequest();
        String token = request.getHeader("Authorization");
        Claims claimsByToken = JWTutil.getClaimsByToken(token);
        String adminLoginname = claimsByToken.getSubject();
        if(adminLoginname.equals("admin")){
            List<ExpressItem> expressItems = expressItemService.selectAllByEiState(eiState);
            if(expressItems!=null){
                return CommonResult.success(ItemToResultUtil.getResultList(expressItems));
            }else {
                return CommonResult.failed("查询失败");
            }
        }else{
            ExpressItem expressItem = new ExpressItem();
            expressItem.setEiState(eiState);
            Admin adminToGetInfo = adminService.findAdminToGetInfo(adminLoginname);
            int courierId = adminToGetInfo.getAdminId();
            expressItem.setCourierId(courierId);
            List<ExpressItem> expressItems = expressItemService.selectAllByEiStateForCourier(expressItem);
            return CommonResult.success(ItemToResultUtil.getResultList(expressItems));
        }

    }
    @RequestMapping(value = "/updataeistate",method = RequestMethod.POST)
    public CommonResult updataEiState(@RequestBody ExpressItem expressItem){
        int i = expressItemService.updataEiState(expressItem);
        if(i==1){
            return CommonResult.success("修改成功");
        }else {
            return CommonResult.failed("修改失败");
        }
    }


}
