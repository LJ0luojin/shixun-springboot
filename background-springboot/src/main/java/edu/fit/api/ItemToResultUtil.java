package edu.fit.api;

import edu.fit.pojo.ExpressItem;
import edu.fit.pojo.ExpressResult;

import java.util.ArrayList;
import java.util.List;

public class ItemToResultUtil {
    public static List<ExpressResult> getResultList(List<ExpressItem> expressItems){
        List<ExpressResult> expressResults = new ArrayList<>();
        for (ExpressItem expressItem : expressItems) {
            ExpressResult expressResult = new ExpressResult();
            expressResult.setEiNumber(expressItem.getEiNumber());
            expressResult.setSender(expressItem.getSenderName()+" "+expressItem.getSenderPhone());
            expressResult.setSenderAddress(expressItem.getSenderProvince()+" "+expressItem.getSenderCity()+" "+
                    expressItem.getSenderArea()+" "+expressItem.getSenderAddress());
            expressResult.setRecipient(expressItem.getRecipientName()+" "+expressItem.getRecipientPhone());
            expressResult.setRecipientAddress(expressItem.getRecipientProvince()+" "+expressItem.getRecipientCity()+" "+
                    expressItem.getRecipientArea()+" "+expressItem.getRecipientAddress());
            if(expressItem.getEiState().equals(0)){
                expressResult.setEiState("待审核");
            }else if(expressItem.getEiState().equals(1)){
                expressResult.setEiState("待揽收");
            }else if(expressItem.getEiState().equals(2)){
                expressResult.setEiState("运输中");
            }else if(expressItem.getEiState().equals(3)){
                expressResult.setEiState("派件中");
            }else if(expressItem.getEiState().equals(4)){
                expressResult.setEiState("已投妥");
            }else if(expressItem.getEiState().equals(5)){
                expressResult.setEiState("已撤单");
            }else if(expressItem.getEiState().equals(6)){
                expressResult.setEiState("拒收");
            }
            if(expressItem.getEiType().equals("1")){
                expressResult.setEiType("文件");
            } else if (expressItem.getEiType().equals("2")) {
                expressResult.setEiType("电子产品");
            } else if (expressItem.getEiType().equals("3")) {
                expressResult.setEiType("服装鞋帽");
            }else if (expressItem.getEiType().equals("4")) {
                expressResult.setEiType("食品");
            }else if (expressItem.getEiType().equals("5")) {
                expressResult.setEiType("医药卫生");
            }else if (expressItem.getEiType().equals("6")) {
                expressResult.setEiType("其他");
            }
            expressResult.setEiWeight(expressItem.getEiWeight()+"kg");
            expressResult.setCreateTime(expressItem.getCreateTime());
            expressResults.add(expressResult);
        }
        return expressResults;
    }
}
