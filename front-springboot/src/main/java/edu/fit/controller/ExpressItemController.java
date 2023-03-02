package edu.fit.controller;

import edu.fit.api.CommonResult;
import edu.fit.api.NumberUtil;
import edu.fit.pojo.ExpressItem;
import edu.fit.service.IExpressItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ExpressItemController {
    @Autowired
    private IExpressItemService expressItemService;

    @RequestMapping("/sendexpress")
    public CommonResult addOrder(@RequestBody ExpressItem expressItem){
        expressItem.setEiNumber(NumberUtil.eiNumberUtil());
        //判断寄件人和收件人名字是否为空
        if ("".equals(expressItem.getSenderName()) || expressItem.getSenderName() == null ||
        "".equals(expressItem.getRecipientName() )|| expressItem.getRecipientName()==null){
            return CommonResult.failed("寄件人或收件人姓名为空");
        }
        //判断寄件人和收件人电话是否为空
        if ("".equals(expressItem.getSenderPhone()) || expressItem.getSenderPhone()== null ||
        "".equals(expressItem.getRecipientPhone() )|| expressItem.getRecipientPhone() == null){
            return CommonResult.failed("寄件人或收件人电话为空");
        }
        //判断寄件人和收件人所在省份是否为空
        if ("".equals(expressItem.getSenderProvince()) || expressItem.getSenderProvince() == null ||
        "".equals(expressItem.getRecipientProvince()) || expressItem.getRecipientProvince() == null){
            return CommonResult.failed("寄件人或收件人所在省份为空");
        }
        //判断寄件人和收件人所在城市是否为空
        if ("".equals(expressItem.getSenderCity()) || expressItem.getSenderCity() == null ||
                "".equals(expressItem.getRecipientCity()) || expressItem.getRecipientCity() == null){
            return CommonResult.failed("寄件人或收件人所在城市是否为空");
        }
        //判断寄件人和收件人所在区域是否为空
        if ("".equals(expressItem.getSenderArea()) || expressItem.getSenderArea() == null ||
                "".equals(expressItem.getRecipientArea()) || expressItem.getRecipientArea() == null){
            return CommonResult.failed("寄件人或收件人所在区域是否为空");
        }
        //判断寄件人和收件人详细地址是否为空
        if ("".equals(expressItem.getSenderAddress()) || expressItem.getSenderAddress() == null ||
                "".equals(expressItem.getRecipientAddress()) || expressItem.getRecipientAddress() == null){
            return CommonResult.failed("寄件人或收件人详细地址是否为空");
        }
        int i = expressItemService.insertOrder(expressItem);
        if (i==1){
            return CommonResult.success("已生成订单");
        }else {
            return CommonResult.failed("生成订单失败");
        }
    }
    @RequestMapping("/query")
    public CommonResult queryEi(String eiNumber){
//        System.out.println(eiNumber);
        ExpressItem expressItem = expressItemService.selectEIMessage(eiNumber);
        if(expressItem!=null){
            return CommonResult.success(expressItem);
        }else{
            return CommonResult.failed("快递单号不存在");
        }

    }
}
