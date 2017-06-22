package com.water.db.service.interfaces;

import com.water.db.model.CourseSubject;
import com.water.db.model.dto.CourseSubjectDto;

import java.util.List;
import java.util.Map;

public interface CourseSubjectService {
    List<CourseSubjectDto> findAllCourseSubject();

    CourseSubjectDto getCourseSubjectListByCourseName(String courseName);

    CourseSubject getCourseSubjectByExample(Map<String, Object> queryMap);
}