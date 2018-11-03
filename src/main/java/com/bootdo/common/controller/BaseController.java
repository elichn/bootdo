package com.bootdo.common.controller;

import com.bootdo.common.utils.ShiroUtils;
import com.bootdo.sys.domain.UserDO;
import org.springframework.stereotype.Controller;

/**
 * <p>Title: BaseController</p>
 * <p>Description: BaseController</p>
 *
 * @author
 * @version 1.0
 * @date
 */
@Controller
public class BaseController {

    public UserDO getUser() {
        return ShiroUtils.getUser();
    }

    public Long getUserId() {
        return getUser().getId();
    }

    public String getUsername() {
        return getUser().getUsername();
    }
}