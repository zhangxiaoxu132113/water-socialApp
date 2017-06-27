package com.water.db.service.impl;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import com.water.db.dao.CourseSubjectMapper;
import com.water.db.model.CourseSubject;
import com.water.db.model.CourseSubjectCriteria;
import com.water.db.model.ITArticle;
import com.water.db.model.dto.CourseSubjectDto;
import com.water.db.service.interfaces.CourseSubjectService;
import com.water.utils.SerializeHelper;
import com.water.utils.cache.CacheManager;
import com.water.utils.common.Constants;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

@Service("courseSubjectService")
public class CourseSubjectServiceImpl implements CourseSubjectService {
    private static String REDIS_KEY = "ub_course_subject";

    private LoadingCache<String, Object> cacheLocal;

    private Map<String, CourseSubject> courseSubjectMap;

    @Resource
    private CourseSubjectMapper courseSubjectMapper;

    @Resource
    private CacheManager cacheManager;

    private Log LOG = LogFactory.getLog(CourseSubjectServiceImpl.class);

    @Override
    public List<CourseSubjectDto> findAllCourseSubject() {
        List<CourseSubjectDto> courseSubjectDtoArrayList;
        long len = cacheManager.llen(REDIS_KEY);
        byte[] data;

        if (len == 0) {
            courseSubjectDtoArrayList = getTreeList();
            for (CourseSubjectDto model : courseSubjectDtoArrayList) {
                data = SerializeHelper.serializer(model);
                cacheManager.lpush(REDIS_KEY, data);
            }
            LOG.info("初始化首页菜单选项！");
        } else {
            courseSubjectDtoArrayList = new ArrayList<>();
            List<byte[]> datas = cacheManager.lrange(REDIS_KEY.getBytes(), 0, len);
            for (byte[] data1 : datas) {
                CourseSubjectDto model = SerializeHelper.deserializer(data1, CourseSubjectDto.class);
                courseSubjectDtoArrayList.add(model);
            }
        }

        return courseSubjectDtoArrayList;
    }

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

    @Override
    public CourseSubjectDto getCourseSubjectListByCourseName(String courseName) {
        CourseSubjectDto courseSubjectDto = null;
        if (StringUtils.isNotBlank(courseName)) {

        }
        return courseSubjectDto;
    }

    @Override
    public CourseSubject getCourseSubjectByExample(Map<String, Object> queryMap) {
        CourseSubject courseSubject = null;
        CourseSubjectCriteria courseSubjectCriteria = new CourseSubjectCriteria();
        CourseSubjectCriteria.Criteria criteria = courseSubjectCriteria.createCriteria();
        if (queryMap != null) {
            if (queryMap.containsKey("courseName")) {
                criteria.andNameEqualTo((String) queryMap.get("courseName"));
            }
        }
        List<CourseSubject> courseSubjectList = courseSubjectMapper.selectByExample(courseSubjectCriteria);
        if (courseSubjectList != null && !courseSubjectList.isEmpty()) {
            courseSubject = courseSubjectList.get(0);
        }
        return courseSubject;
    }

    private CourseSubject findCourseSubjectByIdWithLocalCache(String id) {
        CourseSubject courseSubject = null;
        if (StringUtils.isNotBlank(id)) {
            courseSubject = courseSubjectMap.get(id);
        }
        return courseSubject;
    }

    private CourseSubject findParentCourseSubByIdWithLocalCache(String id) {
        CourseSubject courseSubject = null;
        courseSubject = findCourseSubjectByIdWithLocalCache(id);
        if (courseSubject != null ) {
            courseSubject = findCourseSubjectByIdWithLocalCache(courseSubject.getPartentId());
        }
        return courseSubject;
    }


    @PostConstruct
    public void init() {
        cacheLocal = CacheBuilder.newBuilder().refreshAfterWrite(1, TimeUnit.DAYS).build(
                new CacheLoader<String, Object>() {
                    @Override
                    public List<CourseSubject> load(String key) {
                        switch (key) {
                            case Constants.CacheKey.ALL_COURSE_SUBJECT:
                                List<CourseSubject> courseSubjectList = courseSubjectMapper.selectByExample(null);
                                courseSubjectMap = new HashMap<>();
                                for (CourseSubject courseSubject : courseSubjectList) {
                                    courseSubjectMap.put(courseSubject.getId(), courseSubject);
                                }
                                return courseSubjectList;
                        }
                        return null;
                    }
                }
        );
    }

}