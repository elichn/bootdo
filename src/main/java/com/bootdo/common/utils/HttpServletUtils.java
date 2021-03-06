package com.bootdo.common.utils;

import javax.servlet.http.HttpServletRequest;

/**
 * <p>Title: HttpServletUtils</p>
 * <p>Description: HttpServletUtils</p>
 *
 * @author
 * @version 1.0
 * @date
 */
public class HttpServletUtils {

    public static boolean jsAjax(HttpServletRequest req) {
        // 判断是否为ajax请求，默认不是
        boolean isAjaxRequest = false;
        if (!StringUtils.isBlank(req.getHeader("x-requested-with")) && req.getHeader("x-requested-with").equals("XMLHttpRequest")) {
            isAjaxRequest = true;
        }
        return isAjaxRequest;
    }
}
