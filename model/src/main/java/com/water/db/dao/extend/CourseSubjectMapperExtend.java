package com.water.db.dao.extend;

import com.water.db.model.dto.CourseSubjectDto;

import java.util.List;
import java.util.Map;

public interface CourseSubjectMapperExtend {
    List<CourseSubjectDto> getAllCourseSubject();

    List<CourseSubjectDto> getCourseSubjectByExample(Map<String, Object> queryMap);
}