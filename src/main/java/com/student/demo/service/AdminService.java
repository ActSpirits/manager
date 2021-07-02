package com.student.demo.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.student.demo.Bean.Admin;
import org.apache.ibatis.annotations.Param;

public interface AdminService extends IService<Admin> {

    public Admin getAdminByUsername(String username);
}
