package com.water.db.dao.extend;

import com.water.db.model.dto.CourseDto;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Value;

import java.util.List;
import java.util.Map;

public interface CourseMapperExtend {
    List<CourseDto> getCatalogByCourseName(@Param("courseName")String courseName);
}