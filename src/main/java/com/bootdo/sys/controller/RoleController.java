package com.bootdo.sys.controller;

import com.bootdo.common.annotation.Log;
import com.bootdo.common.config.Constant;
import com.bootdo.common.controller.BaseController;
import com.bootdo.common.utils.R;
import com.bootdo.sys.domain.RoleDO;
import com.bootdo.sys.service.RoleService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>Title: RoleController</p>
 * <p>Description: 角色 Controller</p>
 *
 * @author
 * @version 1.0
 * @date
 */
@RequestMapping("/sys/role")
@Controller
public class RoleController extends BaseController {

    private String prefix = "sys/role";

    @Autowired
    private RoleService roleService;

    /**
     * role role
     *
     * @return String
     */
    @RequiresPermissions("sys:role:role")
    @GetMapping()
    public String role() {
        return prefix + "/role";
    }

    /**
     * list 列表
     *
     * @return List<RoleDO>
     */
    @RequiresPermissions("sys:role:role")
    @GetMapping("/list")
    @ResponseBody()
    public List<RoleDO> list() {
        List<RoleDO> roles = roleService.list();
        return roles;
    }

    /**
     * add 添加
     *
     * @return
     */
    @Log("添加角色")
    @RequiresPermissions("sys:role:add")
    @GetMapping("/add")
    public String add() {
        return prefix + "/add";
    }

    /**
     * edit 编辑角色
     *
     * @param id    id
     * @param model model
     * @return String
     */
    @Log("编辑角色")
    @RequiresPermissions("sys:role:edit")
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, Model model) {
        RoleDO roleDO = roleService.get(id);
        model.addAttribute("role", roleDO);
        return prefix + "/edit";
    }

    /**
     * save 保存角色
     *
     * @param role role
     * @return R
     */
    @Log("保存角色")
    @RequiresPermissions("sys:role:add")
    @PostMapping("/save")
    @ResponseBody()
    public R save(RoleDO role) {
        if (Constant.DEMO_ACCOUNT.equals(getUsername())) {
            return R.error(1, "演示系统不允许修改,完整体验请部署程序");
        }
        if (roleService.save(role) > 0) {
            return R.ok();
        } else {
            return R.error(1, "保存失败");
        }
    }

    /**
     * update 更新角色
     *
     * @param role role
     * @return R
     */
    @Log("更新角色")
    @RequiresPermissions("sys:role:edit")
    @PostMapping("/update")
    @ResponseBody()
    public R update(RoleDO role) {
        if (Constant.DEMO_ACCOUNT.equals(getUsername())) {
            return R.error(1, "演示系统不允许修改,完整体验请部署程序");
        }
        if (roleService.update(role) > 0) {
            return R.ok();
        } else {
            return R.error(1, "保存失败");
        }
    }

    /**
     * remove  删除角色
     *
     * @param id id
     * @return R
     */
    @Log("删除角色")
    @RequiresPermissions("sys:role:remove")
    @PostMapping("/remove")
    @ResponseBody()
    public R remove(Long id) {
        if (Constant.DEMO_ACCOUNT.equals(getUsername())) {
            return R.error(1, "演示系统不允许修改,完整体验请部署程序");
        }
        if (roleService.remove(id) > 0) {
            return R.ok();
        } else {
            return R.error(1, "删除失败");
        }
    }

    /**
     * batchRemove 批量删除角色
     *
     * @param ids ids
     * @return R
     */
    @RequiresPermissions("sys:role:batchRemove")
    @Log("批量删除角色")
    @PostMapping("/batchRemove")
    @ResponseBody
    public R batchRemove(@RequestParam("ids[]") Long[] ids) {
        if (Constant.DEMO_ACCOUNT.equals(getUsername())) {
            return R.error(1, "演示系统不允许修改,完整体验请部署程序");
        }
        int r = roleService.batchremove(ids);
        if (r > 0) {
            return R.ok();
        }
        return R.error();
    }
}
