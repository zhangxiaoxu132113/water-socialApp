package com.water.utils.web;

import com.water.utils.SerializeHelper;
import com.water.utils.cache.CacheManager;
import com.water.utils.web.vo.Category;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * 获取菜单分类
 * Created by zhangmiaojie on 2017/5/3.
 */
@Component
public class CategoryHelper {
    private static String ID = "id";
    private static String NAME = "name";
    private static String SORT = "sort";
    private static String CATEGORY = "category";
    private static String CATEGORIES = "categories";
    private static String FILE_PATH = "menu.xml";
    private static String REDIS_KEY = "index_page_menu";

    private Log LOG = LogFactory.getLog(CategoryHelper.class);

    @Resource
    private CacheManager cacheManager;

    public List<Category> getAllCategories() {
        List<Category> categoryList = new ArrayList<>();
        byte[] data = null;
        long len = cacheManager.llen(REDIS_KEY);
        if (len == 0) {
            categoryList = initiablize();
            for (Category category : categoryList) {
                data = SerializeHelper.serializer(category);
                cacheManager.lpush(REDIS_KEY, data);
            }
            LOG.info("初始化首页菜单选项！");
        } else {
            List<byte[]> datas = cacheManager.lrange(REDIS_KEY.getBytes(), 0, len);
            if (datas != null && datas.size()>0){
                for (byte[] data1 : datas) {
                    Category category = SerializeHelper.deserializer(data1, Category.class);
                    categoryList.add(category);
                }
            }
        }
        return sort(categoryList);
    }

    public List<Category> sort(List<Category> list) {
        Collections.sort(list, new Comparator<Category>() {
            @Override
            public int compare(Category o1, Category o2) {
                return new Integer(o1.getSort()).compareTo(new Integer(o2.getSort()));
            }
        });
        return list;
    }

    public List<Category> initiablize() {
        InputStream is = CategoryHelper.class.getClassLoader().getResourceAsStream(FILE_PATH);
        SAXReader reader = new SAXReader();
        try {
            Document xmlDoc = reader.read(is);
            Element rootEle = xmlDoc.getRootElement();
            List<Element> categoryEleList = rootEle.elements(CATEGORY);
            List<Category> categoryList = getCategories(categoryEleList);
            return categoryList;
        } catch (DocumentException e) {
            e.printStackTrace();
        }
        return null;
    }

    private List<Category> getCategories(List<Element> categoryEleList) {
        List<Category> categoryList = new ArrayList<>();
        for (Element categoryEle : categoryEleList) {
            Category category = new Category();
            Element idElement = categoryEle.element(ID);
            Element nameElement = categoryEle.element(NAME);
            Element sortElement = categoryEle.element(SORT);
            Element categoriesEle = categoryEle.element(CATEGORIES);

            String id = idElement.getText();
            String name = nameElement.getText();
            String sort = sortElement.getText();

            category.setId(Integer.parseInt(id));
            category.setName(name);
            category.setSort(Integer.parseInt(sort));
            if (categoriesEle != null) {
                List<Element> categoriesEleList = categoriesEle.elements(CATEGORY);
                List<Category> sonCategoriesList = getCategories(categoriesEleList);
                if (sonCategoriesList != null && sonCategoriesList.size() > 0) {
                    category.setCategories(sonCategoriesList);
                }
            }
            categoryList.add(category);
        }
        return categoryList;
    }

    public static void main(String[] args) {
    }
}
