package com.water.utils.lang;

import com.water.utils.common.Constants;
import org.apache.commons.lang.StringUtils;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by mrwater on 2017/6/24.
 */
public class StringUtil {
    public static Set<String> staticResourceNames = new HashSet<String>();

    static {
        initStaticResourceNames();
    }

    private StringUtil() {
    }

    public static String deconde(String content) throws UnsupportedEncodingException {
        content = URLDecoder.decode(content, "utf-8");
        return URLDecoder.decode(content, "utf-8");
    }

    public static String transform2utf8(String content) throws UnsupportedEncodingException {
        content = new String(content.getBytes("iso-8859-1"), "utf-8");
        return content;
    }

    public static void initStaticResourceNames() {
        String filterStaticResource = Constants.FILTER_STATIC_RESOURCE;
        String[] resources = filterStaticResource.split(",");
        for (String resource : resources) {
            staticResourceNames.add(resource);
        }
    }

    /**
     * 判断是否访问的是静态资源
     */
    public static boolean isRequestStaticResourceUrl(String url) {
        if (StringUtils.isNotBlank(url)) {
            for (String srn : staticResourceNames) {
                if (url.lastIndexOf(srn) != -1) return true;
            }
        }
        return false;
    }
}
