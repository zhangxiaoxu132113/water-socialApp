package com.water.utils.web.view;

import com.alibaba.fastjson.serializer.SerializeFilter;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by mrwater on 2017/1/25.
 *
 * @Description 返回页面的视图model
 */
public class ResultView implements java.io.Serializable {

    private Integer code; //状态码
    private String msg;   //消息
    private Object data;  //数据
    private List<SerializeFilter> filters;

    public static final Integer FAIL_CODE = -1;
    public static final Integer SUCCESS_CODE = 0;
    public static final Integer NOT_FOUND = 4;

    public static final String FAIL_MSG = "操作异常";
    public static final String SUCCESS_MSG = "操作成功";
    public static final String NOT_FOUND_MSG = "访问资源不存在";



    public ResultView() {

    }

    public ResultView(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public ResultView(Integer code, String msg, Object data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public ResultView(Integer code, String msg, Object data, List<SerializeFilter> filters) {
        this.code = code;
        this.msg = msg;
        this.data = data;
        this.filters = filters;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public List<SerializeFilter> getFilters() {
        return filters;
    }

    public void setFilters(List<SerializeFilter> filters) {
        this.filters = filters;
    }

    public ResultData createResultData() {
        return new ResultData();
    }

    public class ResultData {
        Map<String, Object> map = new HashMap<String, Object>();

        public ResultData set(String key, Object obj) {
            map.put(key, obj);
            return this;
        }

        public Object get(String key) {
            return map.get(key);
        }

        public void build() {
            data = this.map;
        }
    }
}
