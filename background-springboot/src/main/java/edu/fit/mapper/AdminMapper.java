package edu.fit.mapper;

import edu.fit.pojo.Admin;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface AdminMapper {
    Admin findAdminToLogin(Admin admin);

    Admin findAdminToGetInfo(String adminLoginame);

    List<Admin> selectAllCourierList();

    int insertCourier(Admin courier);

    int updateState(Admin admin);

    int updataCourier(Admin admin);

    int delCourierById(int adminId);
}
