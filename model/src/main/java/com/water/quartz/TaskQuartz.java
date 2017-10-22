package com.water.quartz;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.water.utils.common.Constants;
import com.water.utils.lang.StringUtil;
import com.water.utils.web.HttpRequestTool;
import com.water.uubook.dao.AccessLogInfoMapper;
import com.water.uubook.dao.IpAddressInfoMapper;
import com.water.uubook.model.AccessLogInfo;
import com.water.uubook.model.IpAddressInfo;
import com.water.uubook.utils.DateUtil;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import javax.annotation.Resource;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Date;
import java.util.UUID;

/**
 * Created by zhangmiaojie on 2016/11/17.
 */
public class TaskQuartz {
    private static Log LOG = LogFactory.getLog(TaskQuartz.class);

    @Resource
    private AccessLogInfoMapper accessLogInfoMapper;

    @Resource
    private IpAddressInfoMapper ipAddressInfoMapper;

    public void disposableUrlTask() {
        System.out.println("定时任务执行！");

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
                    AccessLogInfo log = new AccessLogInfo();
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
//                            IpAddressInfo ipAddressInfo = JSON.parseObject(dataObj.toJSONString(), IpAddressInfo.class);
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
