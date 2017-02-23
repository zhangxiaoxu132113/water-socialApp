package com.water.db.dao.extend;

import com.water.db.model.Weibo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface WeiboMapperExtend {
    List<Weibo> getWeiboByUserId(@Param(value = "userId") String userId);
}