package edu.fit.pojo;

import lombok.Data;

@Data
public class ExpressResult {
    private String eiNumber;
    private String sender;
    private String senderAddress;
    private String recipient;
    private String recipientAddress;
    private String eiType;
    private String eiState;
    private String createTime;
    private String eiWeight;
}
