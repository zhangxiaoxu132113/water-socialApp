package com.water.db.dao;

import com.water.db.dao.extend.CourseMapperExtend;
import com.water.db.model.Course;
import com.water.db.model.CourseCriteria;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

import java.util.List;

public interface CourseMapper extends CourseMapperExtend {
    int countByExample(CourseCriteria example);

    int deleteByExample(CourseCriteria example);

    int deleteByPrimaryKey(String id);

    int insert(Course record);

    int insertSelective(Course record);

    List<Course> selectByExampleWithRowbounds(CourseCriteria example, RowBounds rowBounds);

    List<Course> selectByExample(CourseCriteria example);

    Course selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") Course record, @Param("example") CourseCriteria example);

    int updateByExample(@Param("record") Course record, @Param("example") CourseCriteria example);

    int updateByPrimaryKeySelective(Course record);

    int updateByPrimaryKey(Course record);

    int insertBatch(List<Course> list);
}