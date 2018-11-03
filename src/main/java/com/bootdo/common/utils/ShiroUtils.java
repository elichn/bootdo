package com.bootdo.common.utils;

import com.bootdo.sys.domain.UserDO;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;
import org.apache.shiro.session.mgt.eis.SessionDAO;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;

import java.security.Principal;
import java.util.Collection;
import java.util.List;

/**
 * <p>Title: ShiroUtils</p>
 * <p>Description: ShiroUtils</p>
 *
 * @author
 * @version 1.0
 * @date
 */
public class ShiroUtils {

    @Autowired
    private static SessionDAO sessionDAO;

    public static Subject getSubjct() {
        return SecurityUtils.getSubject();
    }

    public static UserDO getUser() {
        Object object = getSubjct().getPrincipal();
        return (UserDO) object;
    }

    public static Long getUserId() {
        return getUser().getId();
    }

    public static void logout() {
        getSubjct().logout();
    }

    public static List<Principal> getPrinciples() {
        List<Principal> principals = null;
        Collection<Session> sessions = sessionDAO.getActiveSessions();
        return principals;
    }
}
