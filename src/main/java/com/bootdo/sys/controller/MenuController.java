package com.bootdo.sys.controller;

import com.bootdo.common.annotation.Log;
import com.bootdo.common.config.Constant;
import com.bootdo.common.controller.BaseController;
import com.bootdo.common.domain.Tree;
import com.bootdo.common.utils.R;
import com.bootdo.sys.domain.MenuDO;
import com.bootdo.sys.service.MenuService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * <p>Title: MenuController</p>
 * <p>Description: 菜单管理 Controller</p>
 *
 * @author
 * @version 1.0
 * @date
 */
@RequestMapping("/sys/menu")
@Controller
public class MenuController extends BaseController {

    private String prefix = "sys/menu";

    @Autowired
    private MenuService menuService;

    /**
     * menu menu
     *
     * @param model model
     * @return String
     */
    @GetMapping()
    @RequiresPermissions("sys:menu:menu")
    public String menu(Model model) {
        return prefix + "/menu";
    }

    /**
     * list 列表
     *
     * @param params params
     * @return List<MenuDO>
     */
    @ResponseBody
    @GetMapping("/list")
    @RequiresPermissions("sys:menu:menu")
    public List<MenuDO> list(@RequestParam Map<String, Object> params) {
        List<MenuDO> menus = menuService.list(params);
        return menus;
    }

    /**
     * add 添加
     *
     * @param model model
     * @param pId   pId
     * @return String
     */
    @Log("添加菜单")
    @GetMapping("/add/{pId}")
    @RequiresPermissions("sys:menu:add")
    public String add(Model model, @PathVariable("pId") Long pId) {
        model.addAttribute("pId", pId);
        if (pId == 0) {
            model.addAttribute("pName", "根目录");
        } else {
            model.addAttribute("pName", menuService.get(pId).getName());
        }
        return prefix + "/add";
    }

    /**
     * edit 编辑菜单
     *
     * @param model model
     * @param id    id
     * @return String
     */
    @Log("编辑菜单")
    @GetMapping("/edit/{id}")
    @RequiresPermissions("sys:menu:edit")
    public String edit(Model model, @PathVariable("id") Long id) {
        MenuDO mdo = menuService.get(id);
        Long pId = mdo.getParentId();
        model.addAttribute("pId", pId);
        if (pId == 0) {
            model.addAttribute("pName", "根目录");
        } else {
            model.addAttribute("pName", menuService.get(pId).getName());
        }
        model.addAttribute("menu", mdo);
        return prefix + "/edit";
    }

    /**
     * save  保存菜单
     *
     * @param menu menu
     * @return R
     */
    @Log("保存菜单")
    @ResponseBody
    @PostMapping("/save")
    @RequiresPermissions("sys:menu:add")
    public R save(MenuDO menu) {
        if (Constant.DEMO_ACCOUNT.equals(getUsername())) {
            return R.error(1, "演示系统不允许修改,完整体验请部署程序");
        }
        if (menuService.save(menu) > 0) {
            return R.ok();
        } else {
            return R.error(1, "保存失败");
        }
    }

    /**
     * update 更新菜单
     *
     * @param menu menu
     * @return R
     */
    @Log("更新菜单")
    @ResponseBody
    @PostMapping("/update")
    @RequiresPermissions("sys:menu:edit")
    public R update(MenuDO menu) {
        if (Constant.DEMO_ACCOUNT.equals(getUsername())) {
            return R.error(1, "演示系统不允许修改,完整体验请部署程序");
        }
        if (menuService.update(menu) > 0) {
            return R.ok();
        } else {
            return R.error(1, "更新失败");
        }
    }

    /**
     * remove 删除菜单
     *
     * @param id id
     * @return R
     */
    @Log("删除菜单")
    @ResponseBody
    @PostMapping("/remove")
    @RequiresPermissions("sys:menu:remove")
    public R remove(Long id) {
        if (Constant.DEMO_ACCOUNT.equals(getUsername())) {
            return R.error(1, "演示系统不允许修改,完整体验请部署程序");
        }
        if (menuService.remove(id) > 0) {
            return R.ok();
        } else {
            return R.error(1, "删除失败");
        }
    }

    /**
     * tree 菜单树
     *
     * @return Tree<MenuDO>
     */
    @ResponseBody
    @GetMapping("/tree")
    public Tree<MenuDO> tree() {
        Tree<MenuDO> tree = menuService.getTree();
        return tree;
    }

    /**
     * tree 根据角色id获取菜单树
     *
     * @param roleId roleId
     * @return Tree<MenuDO>
     */
    @ResponseBody
    @GetMapping("/tree/{roleId}")
    public Tree<MenuDO> tree(@PathVariable("roleId") Long roleId) {
        Tree<MenuDO> tree = menuService.getTree(roleId);
        return tree;
    }
}
