package edu.fit.service.impl;

import edu.fit.mapper.AdminMapper;
import edu.fit.pojo.Admin;
import edu.fit.service.IAdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminServiceImpl implements IAdminService {
    @Autowired
    private AdminMapper adminMapper;

    @Override
    public Admin findAdminToLogin(Admin admin) {
        return adminMapper.findAdminToLogin(admin);
    }

    @Override
    public Admin findAdminToGetInfo(String adminLoginname) {
        return adminMapper.findAdminToGetInfo(adminLoginname);
    }

    @Override
    public List<Admin> selectAllCourierList() {
        return adminMapper.selectAllCourierList();
    }

    @Override
    public int insertCourier(Admin courier) {
        return adminMapper.insertCourier(courier);
    }

    @Override
    public int updateState(Admin admin) {
        return adminMapper.updateState(admin);
    }

    @Override
    public int updataCourier(Admin admin) {
        return adminMapper.updataCourier(admin);
    }

    @Override
    public int delCourierById(int adminId) {
        return adminMapper.delCourierById(adminId);
    }


}
