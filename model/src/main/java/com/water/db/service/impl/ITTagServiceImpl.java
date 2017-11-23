package com.water.db.service.impl;

import com.alibaba.druid.support.logging.Log;
import com.alibaba.druid.support.logging.LogFactory;
import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import com.water.db.service.interfaces.ITTagService;
import com.water.utils.common.Constants;
import com.water.uubook.dao.TbUbTagMapper;
import com.water.uubook.model.dto.TbUbTagDto;
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
    private TbUbTagMapper iTTagMapper;

    private LoadingCache<String, Object> cacheLocal;

    private static Map<String, TbUbTagDto> tagMap = new HashMap<>();

    private static Log logger = LogFactory.getLog(ITTagServiceImpl.class);


    public Map<String, TbUbTagDto> getTagMap() {
        try {
            tagMap = (Map<String, TbUbTagDto>) cacheLocal.get(Constants.CacheKey.GreeArticle);
            if (tagMap == null) {
                tagMap = this.getTagMap();
            }
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        return tagMap;
    }

    @Override
    public List<TbUbTagDto> getAllParentTags() {
        List<TbUbTagDto> parentList = new ArrayList<>();
        List<TbUbTagDto> nodeList = this.getAllTags();
        for (TbUbTagDto tagDto : nodeList) {
            if (tagDto.getParentId() != null) {
                parentList.add(tagDto);
            }
        }
        return parentList;
    }

    public List<TbUbTagDto> getAllTags() {
        List<TbUbTagDto> tbUbTagDtos = iTTagMapper.getAllTags();
        List<TbUbTagDto> nodeList = new ArrayList<>();
        if (tbUbTagDtos != null && tbUbTagDtos.size() > 0) {
            for (TbUbTagDto node1 : tbUbTagDtos) {
                for (TbUbTagDto node2 : tbUbTagDtos) {
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

    private Map<Integer, TbUbTagDto> initializeTagMap() {
        Map<Integer, TbUbTagDto> tagMap = new HashMap<>();
        List<TbUbTagDto> tbUbTagDtos = this.getAllTags();
        tbUbTagDtos.stream().forEach(p -> {
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