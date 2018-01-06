package com.water.quartz;

import com.hankcs.hanlp.HanLP;
import com.water.utils.common.Constants;
import com.water.utils.lang.StringUtil;
import com.water.uubook.dao.TbUbAccessLogInfoMapper;
import com.water.uubook.dao.TbUbArticleMapper;
import com.water.uubook.dao.TbUbIpAddressInfoMapper;
import com.water.uubook.model.TbUbAccessLogInfo;
import com.water.uubook.model.TbUbArticle;
import com.water.uubook.utils.DateUtil;
import com.water.uubook.utils.HtmlUtil;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.BeanUtils;

import javax.annotation.Resource;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by zhangmiaojie on 2016/11/17.
 */
public class TaskQuartz {
    private static Log LOG = LogFactory.getLog(TaskQuartz.class);

    @Resource
    private TbUbAccessLogInfoMapper accessLogInfoMapper;
    @Resource
    private TbUbIpAddressInfoMapper ipAddressInfoMapper;
    @Resource
    private TbUbArticleMapper tbUbArticleMapper;

    public void disposableUrlTask() {
        Map<String, Object> queryMap = new HashMap<>();
        Integer id = 0;
        queryMap.put("count", 100);
        double processValue = 0.0;
        int allValue = tbUbArticleMapper.countByExample(null);
        LOG.info("开始处理任务，数据总量为" + allValue);
        System.out.println("开始处理任务，数据总量为" + allValue);
        while (true) {
            queryMap.put("id", id);
            List<TbUbArticle> articleList = tbUbArticleMapper.getArticle(queryMap);
            for (TbUbArticle article : articleList) {
                String content = HtmlUtil.Html2Text(article.getContent());
                StringBuilder sb = new StringBuilder();
                List<String> sentenceList = HanLP.extractSummary(content, 7);
                if (sentenceList != null) {
                    for (String  sentence: sentenceList) {
                        sb.append(sentence + ",");
                    }
                }
                String description = sb.toString().substring(0, sb.length()-1);
                if (StringUtils.isNoneBlank(description)) {// 如果description内容为空，则设置description的内容
                    article.setDescription(description);
                    tbUbArticleMapper.updateByPrimaryKeySelective(article);
                }

                id = article.getId();
            }

            processValue += 100.0;
            LOG.info("已处理:" + processValue + ",当前进度=" + ((processValue / allValue) * 100) + "%");
            System.out.println("已处理:" + processValue + ",当前进度=" + ((processValue / allValue) * 100) + "%");
        }

    }

    /**
     * 每天凌晨5点处理并分析日志
     */
    public void handleAccessLog() {
        String filePattern = "localhost_access_log.%s.txt";
        String currentdDateStr = DateUtil.DATE_FORMAT_YMD.format(new Date(DateUtil.getDayTimeInMillis(new Date(), -1)));
        String filePath = Constants.ACCESS_LOG_PATH + String.format(filePattern, currentdDateStr);
        File logPath = new File(Constants.ACCESS_LOG_PATH);
        if (!logPath.exists()) {
            LOG.warn("【" + currentdDateStr + "】 - 当天没有需要分析的日志！");
            return;
        }
        try {
            LOG.info("开始分析访问日志......");
            for (File logFile : logPath.listFiles()) {
                BufferedReader reader = new BufferedReader(new InputStreamReader(
                        new FileInputStream(logFile)));
                int b;
                while ((b = reader.read()) != -1) {
                    TbUbAccessLogInfo log = new TbUbAccessLogInfo();
                    String line = reader.readLine();
                    line = line.replace("\"", "");
                    if (StringUtils.isNotBlank(line)) {
                        String[] accessInfos = line.split(" ");
                        if (accessInfos.length < 9) continue;
                        LOG.info("---------------处理日志-----------------");
                        String requestUrl = accessInfos[4];
                        if (StringUtil.isRequestStaticResourceUrl(requestUrl)) continue; // 不记录静态文件访问记录
                        String dateStr = accessInfos[1] + " " + accessInfos[2];
                        dateStr = dateStr.replace("[", "");
                        dateStr = dateStr.replace("]", "");
                        Date accessDate = DateUtil.DATE_FORMAT_ZONE.parse(dateStr);
                        log.setAccessDate(accessDate);

                        //调用ip地址查询接口，设置ip的详细信息
                        String ip = accessInfos[0];
//                        String ipAddrQueryApi = String.format(Constants.API.QUERY_IP, ip);
//                        String resultJson = (String) HttpRequestTool.getRequest(ipAddrQueryApi, false);
//                        LOG.info(resultJson);
//                        if (StringUtils.isNotBlank(resultJson)) {
//                            JSONObject jsonObj = JSONObject.parseObject(resultJson);
//                            if (jsonObj.getInteger("code") != 0) continue;
//                            JSONObject dataObj = jsonObj.getJSONObject("data");
//                            TbUbIpAddressInfo ipAddressInfo = JSON.parseObject(dataObj.toJSONString(), TbUbIpAddressInfo.class);
//                            ipAddressInfo.setCreateOn(new Date());
//                            ipAddressInfoMapper.insert(ipAddressInfo);
//                        }
                        log.setRequestIp(ip);
                        log.setRequestMethod(accessInfos[3]);
                        log.setRequestUrl(requestUrl);
                        log.setStatus(Integer.valueOf(accessInfos[6]));
                        int sentByte = 0;
                        if (accessInfos.length == 8 && !accessInfos[7].equals("-")) {
                            sentByte = Integer.valueOf(accessInfos[7]);
                        }
                        log.setSendBytes(Integer.valueOf(sentByte));
                        log.setProcessRequestTime(Integer.valueOf(accessInfos[8]));
                        log.setCreateOn(new Date());
                        accessLogInfoMapper.insert(log);
                    }
                    LOG.info("访问日志分析结束......");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
