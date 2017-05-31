package com.water.db.service.interfaces;

import com.water.db.model.dto.CourseSubjectDto;

import java.util.List;

public interface CourseSubjectService {
    List<CourseSubjectDto> findAllCourseSubject();
}