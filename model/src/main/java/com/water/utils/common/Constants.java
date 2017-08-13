package com.water.utils.common;

/**
 * Created by mrwater on 2017/1/23.
 */
public class Constants {

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
    }

    public static enum ARTICLE_MODULE {
        BLOG(0,"技术博文"),
        ZI_XUN(1,"资讯"),
        TOU_TIAO(2,"头条"),
        JIAO_CHENG(3,"教程"),
        ZHI_SHI_KU(4,"知识库");

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

        private int index;
        private String name;

        public int getIndex() {
            return index;
        }

        public String getName() {
            return name;
        }
    }
}
