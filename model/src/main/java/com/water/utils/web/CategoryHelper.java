package com.water.utils.web;

import com.water.utils.web.vo.Category;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * Created by zhangmiaojie on 2017/5/3.
 */
public class CategoryHelper {
    private static String FILE_PATH = "menu.xml";
    private static String REDIS_KEY = "menu";
    public static void getAllCategories() {


    }

    public static List<Category> initiablize() {
        URL url = CategoryHelper.class.getClassLoader().getResource(FILE_PATH);
        SAXReader reader = new SAXReader();
        try {
            Document xmlDoc = reader.read(new File(url.getPath()));
            Element rootEle = xmlDoc.getRootElement();
            List<Element> categoryEleList = rootEle.elements("category");
            List<Category> categoryList = getCategories(categoryEleList);
            return categoryList;
        } catch (DocumentException e) {
            e.printStackTrace();
        }
        return null;
    }

    private static List<Category> getCategories(List<Element> categoryEleList) {
        List<Category> categoryList = new ArrayList<>();
        for (Element categoryEle : categoryEleList) {
            Category category = new Category();
            Element idElement = categoryEle.element("id");
            Element nameElement = categoryEle.element("name");
            Element sortElement = categoryEle.element("sort");
            Element categoriesEle = categoryEle.element("categories");

            String id = idElement.getText();
            String name = nameElement.getText();
            String sort = sortElement.getText();

            category.setId(Integer.parseInt(id));
            category.setName(name);
            category.setSort(Integer.parseInt(sort));
            if (categoriesEle != null) {
                List<Element> categoriesEleList = categoriesEle.elements("category");
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
        getAllCategories();
    }
}
