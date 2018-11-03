package com.bootdo.sys.controller;

import com.bootdo.common.utils.R;
import com.bootdo.sys.domain.UserOnline;
import com.bootdo.sys.service.SessionService;
import org.apache.shiro.session.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Collection;
import java.util.List;

/**
 * <p>Title: SessionController</p>
 * <p>Description: 会话 Controller</p>
 *
 * @author
 * @version 1.0
 * @date
 */
@RequestMapping("/sys/online")
@Controller
public class SessionController {

    @Autowired
    private SessionService sessionService;

    /**
     * online online
     *
     * @return String
     */
    @GetMapping()
    public String online() {
        return "sys/online/online";
    }

    /**
     * list 在线列表
     *
     * @return List<UserOnline>
     */
    @ResponseBody
    @RequestMapping("/list")
    public List<UserOnline> list() {
        return sessionService.list();
    }

    /**
     * forceLogout 强制登出
     *
     * @param sessionId          sessionId
     * @param redirectAttributes redirectAttributes
     * @return R
     */
    @ResponseBody
    @RequestMapping("/forceLogout/{sessionId}")
    public R forceLogout(@PathVariable("sessionId") String sessionId, RedirectAttributes redirectAttributes) {
        try {
            sessionService.forceLogout(sessionId);
            return R.ok();
        } catch (Exception e) {
            e.printStackTrace();
            return R.error();
        }
    }

    /**
     * sessionList 会话列表
     *
     * @return Collection<Session>
     */
    @ResponseBody
    @RequestMapping("/sessionList")
    public Collection<Session> sessionList() {
        return sessionService.sessionList();
    }
}
