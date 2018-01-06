package com.water.utils.cache;

import redis.clients.jedis.ShardedJedis;
import redis.clients.jedis.ShardedJedisPool;

import java.util.List;
import java.util.Map;

/**
 * Created by zhangmiaojie on 2017/2/4.
 */
public interface CacheManager {
    ShardedJedis getShardedJedis();

    ShardedJedisPool getShardedJedisPool();

    void set(String key, String value);

    void set(String key, byte[] value);

    byte[] get(byte[] key);

    String get(String key);

    Long sadd(String key, String... value);

    Long llen(String key);

    void del(String key);

    void lpush(String key, String... value);

    void lpush(String key, byte[]... value);

    String lpop(String key);

    byte[] lpop(byte[] key);

    double zscore(String key, String member);

    double zincrby(String key, double value, String member);

    long hincrBy(String key, String field, long value);

    long expire(String key, int second);

    String hmset(String key, Map<String, String> param);

    long srem(String key, String... member);

    List<byte[]> lrange(byte[] key, long start, long end);

    long zadd(String key, String member, double score);

    boolean exists(String key);

    boolean sismember(String key, String member);

    List getList(String key, Class classType);

    void setList(String key, List list, int seconds, Class classType);

    void set(String key, byte[] data, int seconds);
}
