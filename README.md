# Personal Web App

- **这是一个个人的WEB应用**

#### 实现文章投票功能
1. 功能概述
>如果一篇文章获得n张支持票，则说明这篇文章是有趣的文章
>如果每天发布的文章数量中有50篇是有趣文章，则将文章推到文章列表前
>文章超过一定时间就不可以进行投票了。

2. 实现方法
在技术方案上，我选择了redis来作为存储数据的媒介。
使用一个散列集合来存放文章的信息 
article:12345
 title:How to use redis
 link:http://www.uubook.net:8080/article/detail/12345.html
 time:123238239283
 votes:328

定义两个有序集合来存放文章的发布时间，文章的评分。
article_relase_time:
 article:12345 : 12323827323
 
artile_score:
 article:1234 : 79342393
 
为了防止用户对同一篇文章进行多次投票，定义个集合来存储已经投票的ip地址
voted:12345
 ip:
 
3. 代码实现

        int ONE_WEEK_IN_SECONDS = 7 * 24 * 60 * 60;
        int VOTE_SCORE = 432;
        String articleKey = String.format(CacheKey.ARTICLE, articleId);
        long cutOff = DateUtil.getSecondTimestamp() - ONE_WEEK_IN_SECONDS;
        if (cacheManager.zscore(CacheKey.ARTICLE_RELASE_TIME, articleKey) < cutOff) { //不能对发布超过一周的文章进行投票
            return;
        }
        if (cacheManager.sadd(String.format(CacheKey.VOTED, articleId), ip) ==  0) { //同一个ip地址不能对文章进行重复投票
            return;
        }
        cacheManager.zincrby(CacheKey.ARTICLE_VOTED_SCORE, VOTE_SCORE, articleKey);
        cacheManager.hincrBy(articleKey, "voted", 1);
        
