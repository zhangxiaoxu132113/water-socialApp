package com.water.utils.common;

/**
 * redis key值
 * Created by mrwater on 2017/10/1.
 */
public class CacheKey {
    public final static String NEWS = "NEWS";
    public final static String GreeArticle = "GreeArticle";
    public final static String ALL_COURSE_SUBJECT = "ALL_COURSE_SUBJECT";
    public final static String ALL_ROOT_COURSE_SUBJECT = "ALL_ROOT_COURSE_SUBJECT";
    public final static String ALL_TAGS = "ALL_TAGS";

    //文章投票
    public final static String VOTED_YES = "voted_yes:%s";
    public final static String VOTED_NO = "voted_no:%s";
    public final static String ARTICLE = "article:%s";
    public final static String ARTICLE_VOTED_SCORE = "article_voted_socre:";
    public final static String ARTICLE_RELASE_TIME = "article_relase_time:";
}
