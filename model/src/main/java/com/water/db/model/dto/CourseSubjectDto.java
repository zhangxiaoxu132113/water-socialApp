package com.water.db.model.dto;

import com.water.db.model.CourseSubject;

import java.util.List;

/**
 * Created by zhangmiaojie on 2017/5/31.
 */
public class CourseSubjectDto extends CourseSubject {
    private List<CourseSubject> sonCourseSubjectList;

    public List<CourseSubject> getSonCourseSubjectList() {
        return sonCourseSubjectList;
    }

    public void setSonCourseSubjectList(List<CourseSubject> sonCourseSubjectList) {
        this.sonCourseSubjectList = sonCourseSubjectList;
    }


}
