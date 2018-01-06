package com.water.utils.common;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PropertiesLoaderUtils;

import java.io.IOException;
import java.util.Properties;

/**
 * Created by mrwater on 2017/1/23.
 */
public class Constants {
    public static Properties properties;
    public static String ACCESS_LOG_PATH;
    public static String FILTER_STATIC_RESOURCE;
    public static String CRALWER_PATH;
    public static String WEB_SITE_HTML_PATH;


    static {
        Resource resource = new ClassPathResource("/config.properties");
        try {
            properties = PropertiesLoaderUtils.loadProperties(resource);
            CRALWER_PATH = (String) properties.get("crawler.path");
            WEB_SITE_HTML_PATH = (String) properties.get("web.site.html.path");
            ACCESS_LOG_PATH = "/Users/mrwater/Documents/access";
            FILTER_STATIC_RESOURCE = "js,css,jpg,png,jpeg,gif";
//            FILTER_STATIC_RESOURCE = (String) properties.get("filter.static.resource");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static class STATUS_CODE {
        public static Integer SUCCESS = 0;
        public static Integer FAILURE = 1;
    }

    public static class WEIBO_CONFIG {
        public static String APP_KEY = "3917244546";
        public static String APP_SECRET = "b67aef2a9076171ac50b5768f9ba6be1";
        public static String REDIRECT_URL = "http://www.mrwater.com:8080/weibo/getAuthCode";
        public static String ACCESS_TOKEN = "2.00aZaxTDeP3GRE67b30c1dac2omDLE";
        public static String UID = "3191114182";
    }

    public static class CacheKey {
        public final static String NEWS = "NEWS";
        public final static String GreeArticle = "GreeArticle";
        public final static String ALL_COURSE_SUBJECT = "ALL_COURSE_SUBJECT";
        public final static String ALL_ROOT_COURSE_SUBJECT = "ALL_ROOT_COURSE_SUBJECT";
        public final static String ALL_TAGS = "ALL_TAGS";

        //文章投票
        public final static String VOTED = "voted:%s";
        public final static String ARTICLE_RELASE_TIME = "article_relase_time:";

        //热门文章
        public final static String HOT_TOP_ARTICLE = "hot_article:top";
        public final static String HOT_BLOG_ARTICLE = "hot_blog_article:";

    }


    public static enum ARTICLE_MODULE {
        BLOG(0, "技术博文"),
        ZI_XUN(1, "资讯"),
        TOU_TIAO(11, "头条"),
        RUANJIAN_GENGXIN(12, "软件更新"),
        IT_HANGYE(13, "IT行业"),
        JIAO_CHENG(3, "教程"),
        ZHI_SHI_KU(4, "知识库");

        public static String getName(int index) {
            for (ARTICLE_MODULE item : ARTICLE_MODULE.values()) {
                if (item.getIndex() == index) {
                    return item.name;
                }
            }
            return null;
        }

        private ARTICLE_MODULE(int index, String name) {
            this.index = index;
            this.name = name;
        }

        public int index;
        public String name;

        public int getIndex() {
            return index;
        }

        public String getName() {
            return name;
        }
    }

    /**
     * 第三方api接口信息
     */
    public static class API {
        public static String QUERY_IP = "http://ip.taobao.com/service/getIpInfo.php?ip=%s"; //查询IP地址信息
    }
}
