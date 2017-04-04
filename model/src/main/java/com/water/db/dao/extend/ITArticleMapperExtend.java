package com.water.db.dao.extend;

import com.water.db.model.ITArticle;

import java.util.List;
import java.util.Map;

public interface ITArticleMapperExtend {
    List<ITArticle> getArticle(Map<String, Object> queryParam);
}