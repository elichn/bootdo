package com.bootdo.common.controller;

import com.bootdo.common.config.Constant;
import com.bootdo.common.domain.DictDO;
import com.bootdo.common.service.DictService;
import com.bootdo.common.utils.PageUtils;
import com.bootdo.common.utils.Query;
import com.bootdo.common.utils.R;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>Title: DictController</p>
 * <p>Description: 字典表 Controller</p>
 *
 * @author
 * @version 1.0
 * @date
 */
@Controller
@RequestMapping("/common/dict")
public class DictController extends BaseController {

    @Autowired
    private DictService dictService;

    @GetMapping()
    @RequiresPermissions("common:dict:dict")
    public String dict() {
        return "common/dict/dict";
    }

    @ResponseBody
    @GetMapping("/list")
    @RequiresPermissions("common:dict:dict")
    public PageUtils list(@RequestParam Map<String, Object> params) {
        // 查询列表数据
        Query query = new Query(params);
        List<DictDO> dictList = dictService.list(query);
        int total = dictService.count(query);
        PageUtils pageUtils = new PageUtils(dictList, total);
        return pageUtils;
    }

    @GetMapping("/add")
    @RequiresPermissions("common:dict:add")
    public String add() {
        return "common/dict/add";
    }

    @GetMapping("/edit/{id}")
    @RequiresPermissions("common:dict:edit")
    public String edit(@PathVariable("id") Long id, Model model) {
        DictDO dict = dictService.get(id);
        model.addAttribute("dict", dict);
        return "common/dict/edit";
    }

    @ResponseBody
    @PostMapping("/save")
    @RequiresPermissions("common:dict:add")
    public R save(DictDO dict) {
        if (Constant.DEMO_ACCOUNT.equals(getUsername())) {
            return R.error(1, "演示系统不允许修改,完整体验请部署程序");
        }
        if (dictService.save(dict) > 0) {
            return R.ok();
        }
        return R.error();
    }

    @ResponseBody
    @PostMapping("/update")
    @RequiresPermissions("common:dict:edit")
    public R update(DictDO dict) {
        if (Constant.DEMO_ACCOUNT.equals(getUsername())) {
            return R.error(1, "演示系统不允许修改,完整体验请部署程序");
        }
        dictService.update(dict);
        return R.ok();
    }

    @ResponseBody
    @PostMapping("/remove")
    @RequiresPermissions("common:dict:remove")
    public R remove(Long id) {
        if (Constant.DEMO_ACCOUNT.equals(getUsername())) {
            return R.error(1, "演示系统不允许修改,完整体验请部署程序");
        }
        if (dictService.remove(id) > 0) {
            return R.ok();
        }
        return R.error();
    }

    @ResponseBody
    @PostMapping("/batchRemove")
    @RequiresPermissions("common:dict:batchRemove")
    public R remove(@RequestParam("ids[]") Long[] ids) {
        if (Constant.DEMO_ACCOUNT.equals(getUsername())) {
            return R.error(1, "演示系统不允许修改,完整体验请部署程序");
        }
        dictService.batchRemove(ids);
        return R.ok();
    }

    @GetMapping("/type")
    @ResponseBody
    public List<DictDO> listType() {
        return dictService.listType();
    }

    // 类别已经指定增加
    @GetMapping("/add/{type}/{description}")
    @RequiresPermissions("common:dict:add")
    String addD(Model model, @PathVariable("type") String type, @PathVariable("description") String description) {
        model.addAttribute("type", type);
        model.addAttribute("description", description);
        return "common/dict/add";
    }

    @ResponseBody
    @GetMapping("/list/{type}")
    public List<DictDO> listByType(@PathVariable("type") String type) {
        // 查询列表数据
        Map<String, Object> map = new HashMap<>(16);
        map.put("type", type);
        List<DictDO> dictList = dictService.list(map);
        return dictList;
    }
}
