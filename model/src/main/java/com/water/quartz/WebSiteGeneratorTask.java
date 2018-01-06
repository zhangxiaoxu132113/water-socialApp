package com.water.quartz;

import com.water.utils.cache.CacheManager;
import com.water.utils.common.Constants;
import com.water.uubook.dao.TbUbArticleMapper;
import com.water.uubook.model.TbUbArticle;
import com.water.uubook.model.dto.TbUbArticleDto;
import org.apache.commons.lang3.StringUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by mrwater on 2018/1/6.
 */
@Service("webSiteGeneratorTask")
public class WebSiteGeneratorTask {

    @Resource
    private TbUbArticleMapper tbUbArticleMapper;

    @Resource
    private CacheManager cacheManager;

    private final static String LAST_ARTICLE_ID = "last.article.id";

    private final static Logger LOGGER = LoggerFactory.getLogger(WebSiteGeneratorTask.class);

    public void geneatorWebSite() {
        LOGGER.info("生成站点的链接任务，开始执行。");
        FileOutputStream fos;
        OutputStreamWriter osw;
        int lastArticleId = 0;
        try {
            File websiteFile = new File(Constants.WEB_SITE_HTML_PATH);
            Document doc = Jsoup.parse(websiteFile, "utf-8");
            Element element = doc.select(".recently_link").get(0);

            //获取上次的最后文章链接id
            if (StringUtils.isNoneBlank(cacheManager.get(LAST_ARTICLE_ID))) {
                lastArticleId = Integer.parseInt(cacheManager.get(LAST_ARTICLE_ID));
            }

            //清空旧的链接
            element.children().remove();
            //获取最新的文章集合
            Map<String, Object> queryMap = new HashMap<>();
            TbUbArticleDto model = new TbUbArticleDto();
            model.setModule(0);

            String[] cols = {"id", "title"};
            queryMap.put("id", lastArticleId);
            queryMap.put("count", 500);
            queryMap.put("cols", cols);
            queryMap.put("model", model );
            List<TbUbArticle> articleList = tbUbArticleMapper.getArticle(queryMap);
            if (articleList == null || articleList.size() == 0) return;
            for (TbUbArticle article : articleList) {
                element.append("<li><a href=\"http://www.uubook.net/article/detail/" + article.getId() + ".html\">" + article.getTitle() + "</a></li>");
            }

            cacheManager.set(LAST_ARTICLE_ID, articleList.get(articleList.size() - 1).getId().toString());
            fos = new FileOutputStream(websiteFile, false);
            osw = new OutputStreamWriter(fos, "utf-8");
            osw.write(doc.html());
            osw.close();

            LOGGER.info("生成站点的链接任务，执行结束。");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws IOException, URISyntaxException {
        WebSiteGeneratorTask webSiteGeneratorTask = new WebSiteGeneratorTask();
        webSiteGeneratorTask.geneatorWebSite();
    }
}
