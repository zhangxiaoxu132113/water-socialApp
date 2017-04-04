package com.water.db.service.impl;

import com.water.db.dao.ITTagMapper;
import com.water.db.model.dto.ITTagDto;
import com.water.db.service.interfaces.ITTagService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service("iTTagService")
public class ITTagServiceImpl implements ITTagService {
    @Resource
    private ITTagMapper iTTagMapper;


    public List<ITTagDto> getAllTags() {
        List<ITTagDto> itTagDtos = iTTagMapper.getAllTags();
        List<ITTagDto> nodeList = new ArrayList<ITTagDto>();
        if (itTagDtos != null && itTagDtos.size() > 0) {
            for (ITTagDto node1 : itTagDtos) {
                boolean mark = false;
                for (ITTagDto node2 : itTagDtos) {
                    if (node1.getParent() != null && node1.getParent().equals(node2.getId())) {
                        mark = true;
                        if (node2.getChildren() == null)
                            node2.setChildren(new ArrayList<ITTagDto>());
                        node2.getChildren().add(node1);
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