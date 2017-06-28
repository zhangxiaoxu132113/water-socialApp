package com.water.db.model.dto;

import com.water.db.model.CourseSubject;

import java.util.List;

/**
 * Created by zhangmiaojie on 2017/5/31.
 */
public class CourseSubjectDto extends CourseSubject {
    private CourseSubjectDto partentCourseSubject;

    private List<CourseSubjectDto> sonCourseSubjectList;

    public CourseSubjectDto getPartentCourseSubject() {
        return partentCourseSubject;
    }

    public void setPartentCourseSubject(CourseSubjectDto partentCourseSubject) {
        this.partentCourseSubject = partentCourseSubject;
    }

    public List<CourseSubjectDto> getSonCourseSubjectList() {
        return sonCourseSubjectList;
    }

    public void setSonCourseSubjectList(List<CourseSubjectDto> sonCourseSubjectList) {
        this.sonCourseSubjectList = sonCourseSubjectList;
    }


}
