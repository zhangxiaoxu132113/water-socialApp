package com.water.utils.web;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.*;
import com.water.utils.web.view.ResultView;
import org.apache.commons.lang3.StringUtils;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.util.List;

/**
 * Created by mrwater on 2017/1/25.
 */
public class WebUtils {
    private static final Logger logger = LoggerFactory.getLogger(WebUtils.class);

    protected static final String ENCODEING_UTF8 = "UTF-8";
    protected static final String CONTENTTYPE_TEXT = "text/plain";
    protected static final String CONTENTTYPE_HTML = "html/plain";
    protected static final String CONTENTTYPE_XML = "xml/plain";
    protected static final String CONTENTTYPE_JSON = "json/plain";

    private WebUtils() {

    }

    /**
     * 获取客户端的真实ip地址
     * @param request
     * @return
     */
    public static String getRemortIP(HttpServletRequest request) {
        if (request.getHeader("x-forwarded-for") == null) {
            return request.getRemoteAddr();
        }
        return request.getHeader("x-forwarded-for");
    }

    /**
     * 输出字符串到页面
     *
     * @param response
     * @param charset
     * @param contentType
     * @param content
     */
    public static void print(HttpServletResponse response, String charset, String contentType, String content) {
        if (StringUtils.isBlank(charset)) { //默认使用字符
            charset = ENCODEING_UTF8;
        }
        if (StringUtils.isBlank(contentType)) { //默认使用文本渲染
            contentType = CONTENTTYPE_TEXT;
        }
        PrintWriter writer = null;
        try {
            response.setCharacterEncoding(charset);
            response.setContentType(contentType);
            writer = response.getWriter();
            writer.write(content);
            writer.flush();
        } catch (Exception e) {
            logger.error("返回结果失败：" + e.getMessage());
            e.printStackTrace();
        } finally {
            if (writer != null) {
                writer.close();
            }
        }

    }

    public static void sendString(HttpServletResponse response, String str) {
        print(response, null, CONTENTTYPE_HTML, str);
    }

    public static void sendXml(HttpServletResponse response, String xml) {
        Document document = null;
        try {
            document = DocumentHelper.parseText(xml);
            print(response, null, CONTENTTYPE_XML, document.asXML());
        } catch (DocumentException e) {
            logger.error("XML转document失败：" + e.getMessage());
            e.printStackTrace();
        }
    }

    public static void sendJson(HttpServletResponse response) {
        // TODO: 2017/1/25
    }

    public static void sendResult(HttpServletResponse response, ResultView resultView) {
        JSONSerializer jser = null;
        if (resultView != null) {
            Object data = resultView.getData();
            if (data != null) {
                jser = new JSONSerializer();
                addJsonFilter(jser, resultView.getFilters());
                jser.write(data);
                resultView.setData(JSONObject.parse(jser.toString()));
            }
            resultView.setFilters(null); //清空过滤器
            jser = new JSONSerializer();
            jser.write(resultView);
            print(response, ENCODEING_UTF8, CONTENTTYPE_JSON, jser.toString());
        } else {
            print(response, ENCODEING_UTF8, CONTENTTYPE_JSON, "");
        }
    }

    /**
     * 向JSON序列化对象添加过滤器
     *
     * @param jser
     * @param filters
     */
    private static void addJsonFilter(JSONSerializer jser, List<SerializeFilter> filters) {
        if (filters != null && filters.size() > 0) {
            for (SerializeFilter filter : filters) {
                if (filter instanceof ValueFilter) {
                    jser.getValueFilters().add((ValueFilter) filter);
                } else if (filter instanceof NameFilter) {
                    jser.getNameFilters().add((NameFilter) filter);
                } else if (filter instanceof PropertyFilter) {
                    jser.getPropertyFilters().add((PropertyFilter) filter);
                } else if (filter instanceof PropertyPreFilter) {
                    jser.getPropertyPreFilters().add((PropertyPreFilter) filter);
                }
            }
        }
        jser.config(SerializerFeature.DisableCircularReferenceDetect, true);
    }
}
