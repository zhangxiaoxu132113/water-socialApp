package com.water.db.model.dto;

import com.water.db.model.ITTag;

import java.util.List;

/**
 * Created by mrwater on 2017/4/3.
 */
public class ITTagDto extends ITTag {
    private List<ITTagDto> children;

    private String parentId;

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    public List<ITTagDto> getChildren() {
        return children;
    }

    public void setChildren(List<ITTagDto> children) {
        this.children = children;
    }
}
