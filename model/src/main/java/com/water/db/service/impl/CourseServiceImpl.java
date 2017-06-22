package com.water.db.service.impl;

import com.water.db.dao.CourseMapper;
import com.water.db.model.dto.CourseDto;
import com.water.db.model.dto.CourseSubjectDto;
import com.water.db.service.interfaces.CourseService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service("courseService")
public class CourseServiceImpl implements CourseService {
    @Resource
    private CourseMapper courseMapper;


    @Override
    public List<CourseDto> getCatalogByCourseName(String courseName) {
        List<CourseDto> courseDtos = null;
        if (StringUtils.isNotBlank(courseName)) {
            courseDtos = courseMapper.getCatalogByCourseName(courseName);
        }
        return courseDtos;
    }

}