package com.water.db.service.impl;

import com.water.db.dao.WeiboMapper;
import com.water.db.model.Weibo;
import com.water.db.service.interfaces.WeiboService;
import com.water.utils.common.Constants;
import com.water.utils.web.view.ResultView;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service("weiboService")
public class WeiboServiceImpl implements WeiboService {
    @Resource
    private WeiboMapper weiboMapper;

    public List<Weibo> getWeiboByUserid(String userId) {
        if (StringUtils.isBlank(userId)) {
            throw new RuntimeException("用户id不合法！");
        }
        return weiboMapper.getWeiboByUserId(userId);
    }

    public ResultView addWeibo(Weibo weibo) {
        if (weibo == null) {
            throw new RuntimeException("参数不合法");
        }
        weibo.setId(UUID.randomUUID().toString());
        weibo.setTimeline(new Date());
        weibo.setLast_updatime(new Date());
        int effectRow = weiboMapper.insert(weibo);
        if (effectRow == 1) {
            return new ResultView(Constants.STATUS_CODE.SUCCESS, "操作成功");
        }
        return new ResultView(Constants.STATUS_CODE.FAILURE, "操作失败");
    }
}