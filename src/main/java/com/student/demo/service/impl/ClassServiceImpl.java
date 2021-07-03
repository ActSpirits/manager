package com.student.demo.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.student.demo.Bean.Class;
import com.student.demo.mapper.ClassMapper;
import com.student.demo.service.ClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ClassServiceImpl extends ServiceImpl<ClassMapper, Class> implements ClassService {

    @Autowired
    private ClassMapper classMapper;

    @Override
    public Class getOneById(Integer id) {
        return classMapper.getOneById(id);
    }

    @Override
    public List<Class> listAllClass() {
        return classMapper.listAllClass();
    }
}
