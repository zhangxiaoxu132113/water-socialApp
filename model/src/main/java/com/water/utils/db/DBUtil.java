package com.water.utils.db;

import com.water.utils.common.Constants;
import com.water.uubook.model.Article;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by mrwater on 2017/10/21.
 */
public class DBUtil {

    /**
     * 构建查询map
     * @param model
     * @param cols 查询列
     * @param sortMap 排序
     * @param size 行数
     * @param currentPage 当前页
     * @return
     */
    public static Map<String, Object> getParamMap(Object model, String[] cols, Map<String, String> sortMap, Integer size, Integer currentPage) {
        Map<String, Object> param = new HashMap<>();
        if (sortMap != null && sortMap.size() > 0) {
            param.put("sortMap", sortMap);
        }
        if (model != null) {
            param.put("model", model);
        }
        if (cols != null) {
            param.put("cols", cols);
        }
        int begin = 0;
        int pageSize = 10;
        if (size != null && currentPage != null && currentPage >= 1) {
            pageSize = size;
            begin = (currentPage -1) * pageSize;
        }
        param.put("begin", begin);
        param.put("pageSize", pageSize);
        return param;
    }

}
