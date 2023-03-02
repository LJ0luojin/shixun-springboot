package edu.fit.service;

import edu.fit.pojo.Admin;

import java.util.List;

public interface IAdminService {
    Admin findAdminToLogin(Admin admin);

    Admin findAdminToGetInfo(String adminLoginname);
    List<Admin> selectAllCourierList();
    int insertCourier(Admin courier);
    int updateState(Admin admin);

    int updataCourier(Admin admin);

    int delCourierById(int adminId);
}
