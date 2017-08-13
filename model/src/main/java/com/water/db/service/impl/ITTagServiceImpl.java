package com.water.db.service.impl;

import com.alibaba.druid.support.logging.Log;
import com.alibaba.druid.support.logging.LogFactory;
import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import com.water.utils.common.Constants;
import com.water.uubook.dao.ITTagMapper;
import com.water.uubook.dao.TagMapper;
import com.water.uubook.model.ITArticle;
import com.water.uubook.model.ITTag;
import com.water.uubook.model.dto.CourseSubjectDto;
import com.water.uubook.model.dto.ITTagDto;
import com.water.db.service.interfaces.ITTagService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

@Service("iTTagService")
public class ITTagServiceImpl implements ITTagService {
    @Resource
    private ITTagMapper iTTagMapper;

    private LoadingCache<String, Object> cacheLocal;

    private static Map<String, ITTagDto> tagMap = new HashMap<>();

    private static Log logger = LogFactory.getLog(ITTagServiceImpl.class);


    public Map<String, ITTagDto> getTagMap() {
        try {
            tagMap = (Map<String, ITTagDto>) cacheLocal.get(Constants.CacheKey.GreeArticle);
            if (tagMap == null) {
                tagMap = this.getTagMap();
            }
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        return tagMap;
    }

    @Override
    public List<ITTagDto> getAllParentTags() {
        List<ITTagDto> parentList = new ArrayList<>();
        List<ITTagDto> nodeList = this.getAllTags();
        for (ITTagDto tagDto : nodeList) {
            if (StringUtils.isBlank(tagDto.getParent())) {
                parentList.add(tagDto);
            }
        }
        return parentList;
    }

    public List<ITTagDto> getAllTags() {
        List<ITTagDto> itTagDtos = iTTagMapper.getAllTags();
        List<ITTagDto> nodeList = new ArrayList<>();
        if (itTagDtos != null && itTagDtos.size() > 0) {
            for (ITTagDto node1 : itTagDtos) {
                for (ITTagDto node2 : itTagDtos) {
                    if (node1.getParent() != null && node1.getParent().equals(node2.getId())) {
                        if (node2.getChildren() == null)
                            node2.setChildren(new ArrayList<>());
                        node2.getChildren().add(node1);
                        break;
                    }
                }

                nodeList.add(node1);
            }
        }
        return nodeList;
    }

    private Map<String, ITTagDto> initializeTagMap() {
        Map<String, ITTagDto> tagMap = new HashMap<>();
        List<ITTagDto> itTagDtos = this.getAllTags();
        itTagDtos.stream().forEach(p -> {
            tagMap.put(p.getId(), p);
        });

        logger.info("init tag map!");
        return tagMap;
    }

    @PostConstruct
    public void init() {
        cacheLocal = CacheBuilder.newBuilder().refreshAfterWrite(1, TimeUnit.DAYS).build(
                new CacheLoader<String, Object>() {
                    @Override
                    public Object load(String key) {
                        switch (key) {
                            case Constants.CacheKey.ALL_TAGS:
                                return initializeTagMap();
                        }
                        return null;
                    }
                }
        );
    }
}