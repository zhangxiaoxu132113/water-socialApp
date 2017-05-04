package com.water.utils.web.vo;

import java.util.List;

/**
 * Created by zhangmiaojie on 2017/5/3.
 */
public class Category implements java.io.Serializable {
    private int id;
    private int sort;
    private String name;
    private List<Category> categories;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSort() {
        return sort;
    }

    public void setSort(int sort) {
        this.sort = sort;
    }

    public List<Category> getCategories() {
        return categories;
    }

    public void setCategories(List<Category> categories) {
        this.categories = categories;
    }
}
