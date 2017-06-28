package com.water.db.service.impl;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import com.water.db.dao.CourseSubjectMapper;
import com.water.db.model.CourseSubject;
import com.water.db.model.CourseSubjectCriteria;
import com.water.db.model.dto.CourseSubjectDto;
import com.water.db.service.interfaces.CourseSubjectService;
import com.water.utils.common.Constants;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

@Service("courseSubjectService")
public class CourseSubjectServiceImpl implements CourseSubjectService {
    private LoadingCache<String, Object> cacheLocal;

    @Resource
    private CourseSubjectMapper courseSubjectMapper;

    private Log logger = LogFactory.getLog(CourseSubjectServiceImpl.class);

    @Override
    public List<CourseSubjectDto> findAllCourseSubject() throws ExecutionException {
        List<CourseSubjectDto> courseSubjectDtoArrayList = null;
        courseSubjectDtoArrayList = (List<CourseSubjectDto>) cacheLocal.get(Constants.CacheKey.ALL_ROOT_COURSE_SUBJECT);
        if (courseSubjectDtoArrayList == null) {
            throw new RuntimeException("缓存异常！无法加载教程列表数据。");
        }
        return courseSubjectDtoArrayList;
    }

    @Override
    public CourseSubjectDto getCourseSubjectByExample(Map<String, Object> queryMap) throws ExecutionException {
        CourseSubjectDto courseSubjectDto = null;
        courseSubjectDto = findCourseSubjectByExampleWithLocalCache(queryMap);
        if (courseSubjectDto == null) {
            logger.warn("无法从缓存加载数据！");
            courseSubjectDto = findCourseSubjectByExampleWithDB(queryMap);
            if (StringUtils.isNotBlank(courseSubjectDto.getPartentId())) {
                queryMap.clear();
                queryMap.put("id", courseSubjectDto.getPartentId());
                CourseSubjectDto pCourseSubjectDto = findCourseSubjectByExampleWithDB(queryMap);
                courseSubjectDto.setPartentCourseSubject(pCourseSubjectDto);

                queryMap.clear();
                queryMap.put("partentId", courseSubjectDto.getPartentId());
                List<CourseSubjectDto> sonCourseSubList = findSonCourseSubsByExampleWithDB(queryMap);
                courseSubjectDto.setSonCourseSubjectList(sonCourseSubList);
            }
        }

        return courseSubjectDto;
    }

    @PostConstruct
    public void init() {
        cacheLocal = CacheBuilder.newBuilder().refreshAfterWrite(1, TimeUnit.DAYS).build(
                new CacheLoader<String, Object>() {
                    @Override
                    public List<CourseSubjectDto> load(String key) {
                        switch (key) {
                            case Constants.CacheKey.ALL_COURSE_SUBJECT:
                                return initializeCourseSubject();
                            case Constants.CacheKey.ALL_ROOT_COURSE_SUBJECT:
                                return getTreeList();
                        }
                        return null;
                    }
                }
        );
    }

    private List<CourseSubjectDto> findSonCourseSubsByExampleWithDB(Map<String, Object> queryMap) {
        List<CourseSubjectDto> courseSubjectDtoList = null;
        courseSubjectDtoList = courseSubjectMapper.getCourseSubjectByExample(queryMap);
        return courseSubjectDtoList;
    }

    private CourseSubjectDto findCourseSubjectByExampleWithDB(Map<String, Object> queryMap) {
        CourseSubjectDto courseSubjectDto = null;
        List<CourseSubjectDto> courseSubjectDtoList = findSonCourseSubsByExampleWithDB(queryMap);
        if (courseSubjectDtoList != null && !courseSubjectDtoList.isEmpty()) {
            CourseSubject courseSubject = courseSubjectDtoList.get(0);
            courseSubjectDto = new CourseSubjectDto();
            BeanUtils.copyProperties(courseSubject, courseSubjectDto);
        }

        return courseSubjectDto;
    }

    /**
     * 根据条件，从缓存加载数据
     *
     * @param queryMap
     * @return
     * @throws ExecutionException
     */
    private CourseSubjectDto findCourseSubjectByExampleWithLocalCache(Map<String, Object> queryMap) throws ExecutionException {
        CourseSubjectDto courseSubjectDto = new CourseSubjectDto();
        List<CourseSubjectDto> courseSubjectDtoList = null;
        if (queryMap != null) {
            courseSubjectDtoList = (List<CourseSubjectDto>) cacheLocal.get(Constants.CacheKey.ALL_COURSE_SUBJECT);
            if (courseSubjectDtoList != null && !courseSubjectDtoList.isEmpty()) {
                if (queryMap.containsKey("id")) {
                    String id = (String) queryMap.get("id");
                    for (CourseSubjectDto model : courseSubjectDtoList) {
                        if (model.getId().equals(id)) {
                            courseSubjectDto = model;
                            return courseSubjectDto;
                        }
                    }
                }
                if (queryMap.containsKey("courseName")) {
                    String courseName = (String) queryMap.get("courseName");
                    for (CourseSubjectDto model : courseSubjectDtoList) {
                        if (model.getName().equals(courseName)) {
                            courseSubjectDto = model;
                            return courseSubjectDto;
                        }
                    }
                }
                if (queryMap.containsKey("partentId")) {
                    String partentId = (String) queryMap.get("partentId");
                    for (CourseSubjectDto model : courseSubjectDtoList) {
                        if (model.getPartentId().equals(partentId)) {
                            courseSubjectDto = model;
                            return courseSubjectDto;
                        }
                    }
                }
            }
        }
        return courseSubjectDto;
    }

    /**
     * 初始化数据，加载到内存。
     * @return List<CourseSubjectDto>
     */
    private List<CourseSubjectDto> initializeCourseSubject() {
        List<CourseSubjectDto> courseSubjects = courseSubjectMapper.getAllCourseSubject();
        List<CourseSubjectDto> nodeList = new ArrayList<>();
        if (courseSubjects != null && courseSubjects.size() > 0) {
            for (CourseSubjectDto node1 : courseSubjects) {
                for (CourseSubjectDto node2 : courseSubjects) {
                    if (node1.getPartentId() != null && node1.getPartentId().equals(node2.getId())) {
                        if (node2.getSonCourseSubjectList() == null) {
                            node2.setSonCourseSubjectList(new ArrayList<>());
                        }
                        node1.setPartentCourseSubject(node2);
                        node2.getSonCourseSubjectList().add(node1);
                        break;
                    }
                }
                nodeList.add(node1);
            }
        }
        return nodeList;
    }

    /**
     * 初始化数据，加载到内存。只保存父级目录
     * @return List<CourseSubjectDto>
     */
    private List<CourseSubjectDto> getTreeList() {
        List<CourseSubjectDto> courseSubjects = courseSubjectMapper.getAllCourseSubject();
        List<CourseSubjectDto> nodeList = new ArrayList<>();
        if (courseSubjects != null && courseSubjects.size() > 0) {
            for (CourseSubjectDto node1 : courseSubjects) {
                boolean mark = false;
                for (CourseSubjectDto node2 : courseSubjects) {
                    if (node1.getPartentId() != null && node1.getPartentId().equals(node2.getId())) {
                        mark = true;
                        if (node2.getSonCourseSubjectList() == null)
                            node2.setSonCourseSubjectList(new ArrayList<>());
                        node2.getSonCourseSubjectList().add(node1);
                        break;
                    }
                }
                if (!mark) {
                    nodeList.add(node1);
                }
            }
        }

        return nodeList;
    }

}