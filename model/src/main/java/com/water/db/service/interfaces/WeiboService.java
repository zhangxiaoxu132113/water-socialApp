package com.water.db.service.interfaces;

import com.water.db.model.Weibo;
import com.water.utils.web.view.ResultView;

import java.util.List;

public interface WeiboService {
    List<Weibo> getWeiboByUserid(String userId);

    ResultView addWeibo(Weibo weibo);
}