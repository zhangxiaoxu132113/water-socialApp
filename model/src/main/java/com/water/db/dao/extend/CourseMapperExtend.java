package com.water.db.dao.extend;

import com.water.db.model.dto.CourseDto;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CourseMapperExtend {
    List<CourseDto> getCatalogByCourseName(@Param("courseName") String courseName);
}