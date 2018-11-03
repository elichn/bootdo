package com.bootdo.sys.controller;

import com.bootdo.common.config.Constant;
import com.bootdo.common.controller.BaseController;
import com.bootdo.common.domain.Tree;
import com.bootdo.common.utils.R;
import com.bootdo.sys.domain.DeptDO;
import com.bootdo.sys.service.DeptService;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>Title: DeptController</p>
 * <p>Description: 部门管理 Controller</p>
 *
 * @author
 * @version 1.0
 * @date
 */
@Controller
@RequestMapping("/sys/dept")
public class DeptController extends BaseController {

    private String prefix = "sys/dept";
    @Autowired
    private DeptService sysDeptService;

    @GetMapping()
    @RequiresPermissions("sys:dept:dept")
    public String dept() {
        return prefix + "/dept";
    }

    /**
     * list 列表
     *
     * @return List<DeptDO>
     */
    @ApiOperation(value = "获取部门列表", notes = "")
    @ResponseBody
    @GetMapping("/list")
    @RequiresPermissions("sys:dept:dept")
    public List<DeptDO> list() {
        Map<String, Object> query = new HashMap<>(16);
        List<DeptDO> sysDeptList = sysDeptService.list(query);
        return sysDeptList;
    }

    /**
     * add 添加入口页
     *
     * @param pId   pId
     * @param model model
     * @return String
     */
    @GetMapping("/add/{pId}")
    @RequiresPermissions("sys:dept:add")
    public String add(@PathVariable("pId") Long pId, Model model) {
        model.addAttribute("pId", pId);
        if (pId == 0) {
            model.addAttribute("pName", "总部门");
        } else {
            model.addAttribute("pName", sysDeptService.get(pId).getName());
        }
        return prefix + "/add";
    }

    /**
     * edit 编辑入口页
     *
     * @param deptId deptId
     * @param model  model
     * @return String
     */
    @GetMapping("/edit/{deptId}")
    @RequiresPermissions("sys:dept:edit")
    public String edit(@PathVariable("deptId") Long deptId, Model model) {
        DeptDO dept = sysDeptService.get(deptId);
        model.addAttribute("dept", dept);
        if (Constant.DEPT_ROOT_ID.equals(dept.getParentId())) {
            model.addAttribute("parentDeptName", "无");
        } else {
            DeptDO parDept = sysDeptService.get(dept.getParentId());
            model.addAttribute("parentDeptName", parDept.getName());
        }
        return prefix + "/edit";
    }

    /**
     * save 保存
     *
     * @param dept dept
     * @return R
     */
    @ResponseBody
    @PostMapping("/save")
    @RequiresPermissions("sys:dept:add")
    public R save(DeptDO dept) {
        if (Constant.DEMO_ACCOUNT.equals(getUsername())) {
            return R.error(1, "演示系统不允许修改,完整体验请部署程序");
        }
        if (sysDeptService.save(dept) > 0) {
            return R.ok();
        }
        return R.error();
    }

    /**
     * update 修改
     *
     * @param dept dept
     * @return R
     */
    @ResponseBody
    @RequestMapping("/update")
    @RequiresPermissions("sys:dept:edit")
    public R update(DeptDO dept) {
        if (Constant.DEMO_ACCOUNT.equals(getUsername())) {
            return R.error(1, "演示系统不允许修改,完整体验请部署程序");
        }
        if (sysDeptService.update(dept) > 0) {
            return R.ok();
        }
        return R.error();
    }

    /**
     * remove  删除
     *
     * @param deptId deptId
     * @return R
     */
    @PostMapping("/remove")
    @ResponseBody
    @RequiresPermissions("sys:dept:remove")
    public R remove(Long deptId) {
        if (Constant.DEMO_ACCOUNT.equals(getUsername())) {
            return R.error(1, "演示系统不允许修改,完整体验请部署程序");
        }
        Map<String, Object> map = new HashMap<>(16);
        map.put("parentId", deptId);
        if (sysDeptService.count(map) > 0) {
            return R.error(1, "包含下级部门,不允许修改");
        }
        if (sysDeptService.checkDeptHasUser(deptId)) {
            if (sysDeptService.remove(deptId) > 0) {
                return R.ok();
            }
        } else {
            return R.error(1, "部门包含用户,不允许修改");
        }
        return R.error();
    }

    /**
     * batchRemove 批量删除
     *
     * @param deptIds deptIds
     * @return R
     */
    @PostMapping("/batchRemove")
    @ResponseBody
    @RequiresPermissions("sys:dept:batchRemove")
    public R batchRemove(@RequestParam("ids[]") Long[] deptIds) {
        if (Constant.DEMO_ACCOUNT.equals(getUsername())) {
            return R.error(1, "演示系统不允许修改,完整体验请部署程序");
        }
        sysDeptService.batchRemove(deptIds);
        return R.ok();
    }

    /**
     * tree 部门树
     *
     * @return Tree<DeptDO>
     */
    @GetMapping("/tree")
    @ResponseBody
    public Tree<DeptDO> tree() {
        Tree<DeptDO> tree = sysDeptService.getTree();
        return tree;
    }

    /**
     * treeView 部门树 入口页
     *
     * @return String
     */
    @GetMapping("/treeView")
    public String treeView() {
        return prefix + "/deptTree";
    }

}
