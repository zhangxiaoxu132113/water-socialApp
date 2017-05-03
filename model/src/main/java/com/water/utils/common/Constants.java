package com.water.utils.common;

import com.water.utils.web.vo.Category;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import javax.xml.parsers.SAXParser;
import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

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
}
