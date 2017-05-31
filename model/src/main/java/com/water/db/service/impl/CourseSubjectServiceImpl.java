package com.water.db.service.impl;

import com.water.db.dao.CourseSubjectMapper;
import com.water.db.model.CourseSubject;
import com.water.db.model.dto.CourseSubjectDto;
import com.water.db.service.interfaces.CourseSubjectService;
import com.water.utils.SerializeHelper;
import com.water.utils.cache.CacheManager;
import com.water.utils.web.vo.Category;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service("courseSubjectService")
public class CourseSubjectServiceImpl implements CourseSubjectService {
    private static String REDIS_KEY = "ub_course_subject";

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
            List<byte[]> datas = cacheManager.lrange(REDIS_KEY.getBytes(), 0 , len);
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
}