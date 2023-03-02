package edu.fit.pojo;

import lombok.Data;

@Data
public class Admin {

  private int adminId;
  private String adminLoginname;
  private String adminPassword;
  private String courierName;
  private String courierPhone;
  private long state;
  private long type;


}
