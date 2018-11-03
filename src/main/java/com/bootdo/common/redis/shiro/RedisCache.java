package com.bootdo.common.redis.shiro;

import org.apache.shiro.cache.Cache;
import org.apache.shiro.cache.CacheException;
import org.apache.shiro.util.CollectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.redis.core.RedisTemplate;

import java.util.*;
import java.util.concurrent.TimeUnit;

/**
 * <p>Title: RedisCache<K, V></p>
 * <p>Description: RedisCache<K, V></p>
 *
 * @author
 * @version 1.0
 * @date
 */
public class RedisCache<K, V> implements Cache<K, V> {

    private static final Logger LOG = LoggerFactory.getLogger(RedisCache.class);

    /**
     * The wrapped Jedis instance.
     */
    private RedisTemplate<K, V> cache;

    /**
     * The Redis key prefix for the sessions
     */
    private String keyPrefix = "shiro_redis_session:";

    /**
     * Returns the Redis session keys
     * prefix.
     *
     * @return The prefix
     */
    public String getKeyPrefix() {
        return keyPrefix;
    }

    /**
     * Sets the Redis sessions key
     * prefix.
     *
     * @param keyPrefix The prefix
     */
    public void setKeyPrefix(String keyPrefix) {
        this.keyPrefix = keyPrefix;
    }

    /**
     * 通过一个JedisManager实例构造RedisCache
     */
    public RedisCache(RedisTemplate<K, V> cache) {
        if (cache == null) {
            throw new IllegalArgumentException("Cache argument cannot be null.");
        }
        this.cache = cache;
    }

    /**
     * Constructs a cache instance with the specified
     * Redis manager and using a custom key prefix.
     *
     * @param cache  The cache manager instance
     * @param prefix The Redis key prefix
     */
    public RedisCache(RedisTemplate<K, V> cache,
                      String prefix) {
        this(cache);
        // set the prefix
        this.keyPrefix = prefix;
    }

    private K getCacheKey(K key) {
        return (K) (this.keyPrefix + key);
    }

    @Override
    public V get(K key) throws CacheException {
        LOG.debug("根据key从Redis中获取对象 key [" + key + "]");
        try {
            if (key == null) {
                return null;
            } else {
                V rawValue = cache.opsForValue().get(getCacheKey(key));
                return rawValue;
            }
        } catch (Throwable t) {
            throw new CacheException(t);
        }

    }

    @Override
    public V put(K key, V value) throws CacheException {
        LOG.debug("根据key从存储 key [" + key + "]");
        try {
            cache.opsForValue().set(getCacheKey(key), value, 30, TimeUnit.MINUTES);
            return value;
        } catch (Throwable t) {
            throw new CacheException(t);
        }
    }

    @Override
    public V remove(K key) throws CacheException {
        LOG.debug("从redis中删除 key [" + key + "]");
        try {
            V previous = get(key);
            cache.delete(getCacheKey(key));
            return previous;
        } catch (Throwable t) {
            throw new CacheException(t);
        }
    }

    @Override
    public void clear() throws CacheException {
        LOG.debug("从redis中删除所有元素");
        try {
            cache.delete(keys());
        } catch (Throwable t) {
            throw new CacheException(t);
        }
    }

    @Override
    public int size() {
        try {
            return keys().size();
        } catch (Throwable t) {
            throw new CacheException(t);
        }
    }

    @Override
    public Set<K> keys() {
        try {
            Set<K> keys = cache.keys(getCacheKey((K) "*"));
            if (CollectionUtils.isEmpty(keys)) {
                return Collections.emptySet();
            }
            return keys;
        } catch (Throwable t) {
            throw new CacheException(t);
        }
    }

    @Override
    public Collection<V> values() {
        try {
            Set<K> keys = keys();
            if (!CollectionUtils.isEmpty(keys)) {
                List<V> values = new ArrayList<>(keys.size());
                for (K key : keys) {
                    V value = get(key);
                    if (value != null) {
                        values.add(value);
                    }
                }
                return Collections.unmodifiableList(values);
            } else {
                return Collections.emptyList();
            }
        } catch (Throwable t) {
            throw new CacheException(t);
        }
    }

}
