package com.bootdo.sys.service;

import com.bootdo.sys.domain.UserDO;
import com.bootdo.sys.domain.UserOnline;
import org.apache.shiro.session.Session;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;

/**
 * <p>Title: SessionService</p>
 * <p>Description: 会话 Service</p>
 *
 * @author
 * @version 1.0
 * @date
 */
@Service
public interface SessionService {

    /**
     * list 用户在线列表
     *
     * @return List<UserOnline>
     */
    List<UserOnline> list();

    /**
     * listOnlineUser listOnlineUser
     *
     * @return List<UserDO>
     */
    List<UserDO> listOnlineUser();

    /**
     * sessionList 会话列表
     *
     * @return Collection<Session>
     */
    Collection<Session> sessionList();

    /**
     * forceLogout forceLogout
     *
     * @param sessionId sessionId
     * @return boolean
     */
    boolean forceLogout(String sessionId);
}
