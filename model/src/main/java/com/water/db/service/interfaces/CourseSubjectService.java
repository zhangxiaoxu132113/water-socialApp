package com.water.db.service.interfaces;

import com.water.db.model.CourseSubject;
import com.water.db.model.dto.CourseSubjectDto;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;

public interface CourseSubjectService {
    List<CourseSubjectDto> findAllCourseSubject() throws ExecutionException;

    CourseSubjectDto getCourseSubjectByExample(Map<String, Object> queryMap) throws ExecutionException;
}