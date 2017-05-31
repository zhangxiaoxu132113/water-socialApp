package com.water.db.service.impl;

import com.water.db.dao.CourseMapper;
import com.water.db.service.interfaces.CourseService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service("courseService")
public class CourseServiceImpl implements CourseService {
    @Resource
    private CourseMapper courseMapper;
}