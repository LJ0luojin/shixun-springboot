package edu.fit.pojo;

import lombok.Data;

@Data
public class ExpressItem {
    private int eiId;
    private String eiNumber;
    private int createId;
    private String senderName;
    private String senderPhone;
    private String senderProvince;
    private String senderCity;
    private String senderArea;
    private String senderAddress;
    private String recipientName;
    private String recipientPhone;
    private String recipientProvince;
    private String recipientCity;
    private String recipientArea;
    private String recipientAddress;
    private String eiType;
    private Integer eiState;
    private String createTime;
    private int courierId;
    private double eiWeight;
}
