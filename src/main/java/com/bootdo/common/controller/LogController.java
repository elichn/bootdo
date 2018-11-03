package com.bootdo.common.controller;

import com.bootdo.common.domain.LogDO;
import com.bootdo.common.domain.PageDO;
import com.bootdo.common.service.LogService;
import com.bootdo.common.utils.Query;
import com.bootdo.common.utils.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * <p>Title: LogController</p>
 * <p>Description: 日志 Controller</p>
 *
 * @author
 * @version 1.0
 * @date
 */
@RequestMapping("/common/log")
@Controller
public class LogController {

    @Autowired
    private LogService logService;

    String prefix = "common/log";

    @GetMapping()
    public String log() {
        return prefix + "/log";
    }

    @ResponseBody
    @GetMapping("/list")
    public PageDO<LogDO> list(@RequestParam Map<String, Object> params) {
        Query query = new Query(params);
        PageDO<LogDO> page = logService.queryList(query);
        return page;
    }

    @ResponseBody
    @PostMapping("/remove")
    public R remove(Long id) {
        if (logService.remove(id) > 0) {
            return R.ok();
        }
        return R.error();
    }

    @ResponseBody
    @PostMapping("/batchRemove")
    public R batchRemove(@RequestParam("ids[]") Long[] ids) {
        int r = logService.batchRemove(ids);
        if (r > 0) {
            return R.ok();
        }
        return R.error();
    }
}
