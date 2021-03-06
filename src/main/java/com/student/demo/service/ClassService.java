package com.student.demo.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.student.demo.Bean.Class;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ClassService extends IService<Class> {

    public Class getOneById(Integer id);

    public List<Class> listAllClass();
}
