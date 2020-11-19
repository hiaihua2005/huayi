package com.huayi.framework.cache;

import redis.clients.jedis.ShardedJedis;

/**
 * @author shiaihua
 */
public class ShardedRedisUtil {
    public static String set(String key, String value) {
        ShardedJedis jedis = null;
        String result = null;
        try {
            jedis = ShardedRedisPool.getJedis();
            result = jedis.set(key, value);
        } catch (Exception e) {
            //log.error("set key:{} value:{}", key, value, e);
        } finally {
            release(jedis);
        }
        return result;
    }

    public static String set(String key, String value,Long expire) {
        ShardedJedis jedis = null;
        String result = null;
        try {
            jedis = ShardedRedisPool.getJedis();
            result = jedis.set(key, value);
            if(expire.intValue()>0) {
                jedis.expire(key, expire.intValue());
            }
        } catch (Exception e) {
            //log.error("set key:{} value:{}", key, value, e);
        } finally {
            release(jedis);
        }
        return result;
    }

    public static Long setnx(String key, String value) {
        ShardedJedis jedis = null;
        Long result = null;
        try {
            jedis = ShardedRedisPool.getJedis();
            result = jedis.setnx(key, value);
        } catch (Exception e) {
            //log.error("setnx key:{} value:{}", key, value, e);
        } finally {
            release(jedis);
        }
        return result;
    }

    public static String getSet(String key, String value) {
        ShardedJedis jedis = null;
        String result = null;
        try {
            jedis = ShardedRedisPool.getJedis();
            result = jedis.getSet(key, value);
        } catch (Exception e) {
            //log.error("getSet key:{} value:{}", key, value, e);
        } finally {
            release(jedis);
        }
        return result;
    }

    /**
     * 设置key的过期时间，单位秒
     */
    public static Long expire(String key, int expires) {
        ShardedJedis jedis = null;
        Long result = null;
        try {
            jedis = ShardedRedisPool.getJedis();
            result = jedis.expire(key, expires);
        } catch (Exception e) {
            //log.error("setExpire key:{} expires:{}", key, expires, e);
        } finally {
            release(jedis);
        }
        return result;
    }

    //exTime的单位是秒
    public static String setEx(String key, String value, int exTime) {
        ShardedJedis jedis = null;
        String result = null;
        try {
            jedis = ShardedRedisPool.getJedis();
            result = jedis.setex(key, exTime, value);
        } catch (Exception e) {
            //log.error("setex key:{} value:{} error", key, value, e);
        } finally {
            release(jedis);
        }
        return result;
    }

    public static String get(String key) {
        ShardedJedis jedis = null;
        String result = null;
        try {
            jedis = ShardedRedisPool.getJedis();
            result = jedis.get(key);
        } catch (Exception e) {
            //log.error("get key:{}", key, e);
        } finally {
            release(jedis);
        }
        return result;
    }

    public static Long del(String key) {
        ShardedJedis jedis = null;
        Long result = null;
        try {
            jedis = ShardedRedisPool.getJedis();
            result = jedis.del(key);
        } catch (Exception e) {
            //log.error("del key:{}", key, e);
        } finally {
            release(jedis);
        }
        return result;
    }

    private static void release(ShardedJedis jedis) {
        if (jedis != null) {
            jedis.close();
        }
    }
}