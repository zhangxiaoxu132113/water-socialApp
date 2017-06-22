package com.water.db.service.interfaces;

import com.water.db.model.dto.CourseDto;
import com.water.db.model.dto.CourseSubjectDto;

import java.util.List;

public interface CourseService {

    /**
     * 根据课程名称获取课程目录
     */
    List<CourseDto> getCatalogByCourseName(String courseName);

}