package com.bootdo.common.redis.shiro;

import org.apache.shiro.session.Session;
import org.apache.shiro.session.UnknownSessionException;
import org.apache.shiro.session.mgt.eis.AbstractSessionDAO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.redis.core.RedisTemplate;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.TimeUnit;

/**
 * <p>Title: RedisSessionDAO</p>
 * <p>Description: RedisSessionDAO</p>
 *
 * @author
 * @version 1.0
 * @date
 */
public class RedisSessionDAO extends AbstractSessionDAO {

    private static final Logger LOG = LoggerFactory.getLogger(RedisSessionDAO.class);

    @Resource(name = "byteRedisTemplate")
    private RedisTemplate<String, byte[]> redisTemplate;

    /**
     * The Redis key prefix for the sessions
     */
    private String keyPrefix = "shiro_redis_session:";

    @Override
    public void update(Session session) throws UnknownSessionException {
        if (session != null) {
            LOG.debug("RedisSessionDAO update , sessionId : {}", session.getId());
        }
        this.saveSession(session);
    }

    /**
     * save session
     *
     * @param session
     * @throws UnknownSessionException
     */
    private void saveSession(Session session) throws UnknownSessionException {
        if (session == null || session.getId() == null) {
            LOG.error("session or session id is null");
            return;
        }
        String key = getStringKey(session.getId());
        byte[] value = SerializeUtils.serialize(session);
        session.setTimeout(12 * 60 * 60 * 1000);
        // session.setTimeout(60 *1000);
        redisTemplate.opsForValue().set(key, value, session.getTimeout(), TimeUnit.MILLISECONDS);
    }

    @Override
    public void delete(Session session) {
        if (session == null || session.getId() == null) {
            LOG.error("session or session id is null");
            return;
        }
        LOG.debug("RedisSessionDAO delete, sessionId = {}", session.getId());
        redisTemplate.delete(getStringKey(session.getId()));
    }

    @Override
    public Collection<Session> getActiveSessions() {
        Set<Session> sessions = new HashSet<>();
        Set<String> keys = redisTemplate.keys(this.keyPrefix + "*");
        if (keys != null && keys.size() > 0) {
            for (String bs : keys) {
                Session s = (Session) SerializeUtils.deserialize(redisTemplate.opsForValue().get(bs));
                sessions.add(s);
            }
        }
        return sessions;
    }

    @Override
    protected Serializable doCreate(Session session) {
        Serializable sessionId = this.generateSessionId(session);
        this.assignSessionId(session, sessionId);
        this.saveSession(session);
        if (session != null) {
            LOG.debug("RedisSessionDAO doCreate , sessionId : {}, timeout : {}", session.getId(), session.getTimeout());
        }
        return sessionId;
    }

    @Override
    protected Session doReadSession(Serializable sessionId) {
        if (sessionId == null) {
            LOG.error("session id is null");
            return null;
        }
        Session s = (Session) SerializeUtils.deserialize(redisTemplate.opsForValue().get(this.getStringKey(sessionId)));
        return s;
    }

    private String getStringKey(Serializable sessionId) {
        return this.keyPrefix + sessionId;
    }

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
}
