package com.bootdo.sys.controller;

import com.bootdo.common.annotation.Log;
import com.bootdo.common.config.Constant;
import com.bootdo.common.controller.BaseController;
import com.bootdo.common.domain.Tree;
import com.bootdo.common.service.DictService;
import com.bootdo.common.utils.MD5Utils;
import com.bootdo.common.utils.PageUtils;
import com.bootdo.common.utils.Query;
import com.bootdo.common.utils.R;
import com.bootdo.sys.domain.DeptDO;
import com.bootdo.sys.domain.RoleDO;
import com.bootdo.sys.domain.UserDO;
import com.bootdo.sys.service.RoleService;
import com.bootdo.sys.service.UserService;
import com.bootdo.sys.vo.UserVO;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

/**
 * <p>Title: UserController</p>
 * <p>Description: 用户 Controller</p>
 *
 * @author
 * @version 1.0
 * @date
 */
@RequestMapping("/sys/user")
@Controller
public class UserController extends BaseController {

    private String prefix = "sys/user";
    @Autowired
    private UserService userService;
    @Autowired
    private RoleService roleService;
    @Autowired
    private DictService dictService;

    /**
     * user user
     *
     * @param model model
     * @return String
     */
    @GetMapping()
    @RequiresPermissions("sys:user:user")
    public String user(Model model) {
        return prefix + "/user";
    }

    /**
     * list 列表
     *
     * @param params params
     * @return PageUtils
     */
    @ResponseBody
    @GetMapping("/list")
    public PageUtils list(@RequestParam Map<String, Object> params) {
        // 查询列表数据
        Query query = new Query(params);
        List<UserDO> sysUserList = userService.list(query);
        int total = userService.count(query);
        PageUtils pageUtil = new PageUtils(sysUserList, total);
        return pageUtil;
    }

    /**
     * add 添加用户
     *
     * @param model model
     * @return String
     */
    @Log("添加用户")
    @GetMapping("/add")
    @RequiresPermissions("sys:user:add")
    public String add(Model model) {
        List<RoleDO> roles = roleService.list();
        model.addAttribute("roles", roles);
        return prefix + "/add";
    }

    /**
     * edit 编辑用户
     *
     * @param model model
     * @param id    id
     * @return String
     */
    @Log("编辑用户")
    @GetMapping("/edit/{id}")
    @RequiresPermissions("sys:user:edit")
    public String edit(Model model, @PathVariable("id") Long id) {
        UserDO userDO = userService.get(id);
        model.addAttribute("user", userDO);
        List<RoleDO> roles = roleService.list(id);
        model.addAttribute("roles", roles);
        return prefix + "/edit";
    }

    /**
     * save 保存用户
     *
     * @param user user
     * @return R
     */

    @Log("保存用户")
    @ResponseBody
    @PostMapping("/save")
    @RequiresPermissions("sys:user:add")
    public R save(UserDO user) {
        if (Constant.DEMO_ACCOUNT.equals(getUsername())) {
            return R.error(1, "演示系统不允许修改,完整体验请部署程序");
        }
        user.setPassword(MD5Utils.encrypt(user.getUsername(), user.getPassword()));
        if (userService.save(user) > 0) {
            return R.ok();
        }
        return R.error();
    }

    /**
     * update 更新用户
     *
     * @param user user
     * @return R
     */
    @Log("更新用户")
    @ResponseBody
    @PostMapping("/update")
    @RequiresPermissions("sys:user:edit")
    public R update(UserDO user) {
        if (Constant.DEMO_ACCOUNT.equals(getUsername())) {
            return R.error(1, "演示系统不允许修改,完整体验请部署程序");
        }
        if (userService.update(user) > 0) {
            return R.ok();
        }
        return R.error();
    }

    /**
     * updatePeronal  更新用户
     *
     * @param user user
     * @return R
     */
    @Log("更新用户")
    @ResponseBody
    @PostMapping("/updatePeronal")
    @RequiresPermissions("sys:user:edit")
    public R updatePeronal(UserDO user) {
        if (Constant.DEMO_ACCOUNT.equals(getUsername())) {
            return R.error(1, "演示系统不允许修改,完整体验请部署程序");
        }
        if (userService.updatePersonal(user) > 0) {
            return R.ok();
        }
        return R.error();
    }

    /**
     * remove 删除用户
     *
     * @param id id
     * @return R
     */

    @Log("删除用户")
    @ResponseBody
    @PostMapping("/remove")
    @RequiresPermissions("sys:user:remove")
    public R remove(Long id) {
        if (Constant.DEMO_ACCOUNT.equals(getUsername())) {
            return R.error(1, "演示系统不允许修改,完整体验请部署程序");
        }
        if (userService.remove(id) > 0) {
            return R.ok();
        }
        return R.error();
    }

    /**
     * batchRemove 批量删除用户
     *
     * @param userIds userIds
     * @return R
     */
    @Log("批量删除用户")
    @ResponseBody
    @PostMapping("/batchRemove")
    @RequiresPermissions("sys:user:batchRemove")
    public R batchRemove(@RequestParam("ids[]") Long[] userIds) {
        if (Constant.DEMO_ACCOUNT.equals(getUsername())) {
            return R.error(1, "演示系统不允许修改,完整体验请部署程序");
        }
        int r = userService.batchremove(userIds);
        if (r > 0) {
            return R.ok();
        }
        return R.error();
    }

    /**
     * exit exit
     *
     * @param params params
     * @return boolean
     */
    @ResponseBody
    @PostMapping("/exit")
    public boolean exit(@RequestParam Map<String, Object> params) {
        // 存在，不通过，false
        return !userService.exit(params);
    }

    /**
     * resetPwd 重置密码入口页
     *
     * @param id    id
     * @param model model
     * @return String
     */
    @Log("请求更改用户密码")
    @GetMapping("/resetPwd/{id}")
    @RequiresPermissions("sys:user:resetPwd")
    public String resetPwd(@PathVariable("id") Long id, Model model) {
        UserDO userDO = new UserDO();
        userDO.setId(id);
        model.addAttribute("user", userDO);
        return prefix + "/reset_pwd";
    }

    /**
     * resetPwd 重置密码
     *
     * @param userVO userVO
     * @return R
     */
    @Log("提交更改用户密码")
    @ResponseBody
    @PostMapping("/resetPwd")
    public R resetPwd(UserVO userVO) {
        if (Constant.DEMO_ACCOUNT.equals(getUsername())) {
            return R.error(1, "演示系统不允许修改,完整体验请部署程序");
        }
        try {
            userService.resetPwd(userVO, getUser());
            return R.ok();
        } catch (Exception e) {
            return R.error(1, e.getMessage());
        }

    }

    /**
     * adminResetPwd  admin更改用户密码
     *
     * @param userVO userVO
     * @return R
     */

    @Log("admin提交更改用户密码")
    @ResponseBody
    @PostMapping("/adminResetPwd")
    @RequiresPermissions("sys:user:resetPwd")
    public R adminResetPwd(UserVO userVO) {
        if (Constant.DEMO_ACCOUNT.equals(getUsername())) {
            return R.error(1, "演示系统不允许修改,完整体验请部署程序");
        }
        try {
            userService.adminResetPwd(userVO);
            return R.ok();
        } catch (Exception e) {
            return R.error(1, e.getMessage());
        }
    }

    /**
     * tree 部门树
     *
     * @return Tree<DeptDO>
     */
    @ResponseBody
    @GetMapping("/tree")
    public Tree<DeptDO> tree() {
        Tree<DeptDO> tree = userService.getTree();
        return tree;
    }

    /**
     * treeView 部门树入口页
     *
     * @return String
     */
    @GetMapping("/treeView")
    public String treeView() {
        return prefix + "/userTree";
    }

    /**
     * personal 个人资料
     *
     * @param model model
     * @return model
     */
    @GetMapping("/personal")
    public String personal(Model model) {
        UserDO userDO = userService.get(getUserId());
        model.addAttribute("user", userDO);
        model.addAttribute("hobbyList", dictService.getHobbyList(userDO));
        model.addAttribute("sexList", dictService.getSexList());
        return prefix + "/personal";
    }

    /**
     * uploadImg 上传图片
     *
     * @param file       file
     * @param avatarData avatarData
     * @param request    request
     * @return R
     */
    @ResponseBody
    @PostMapping("/uploadImg")
    public R uploadImg(@RequestParam("avatarFile") MultipartFile file, String avatarData, HttpServletRequest request) {
        if ("test".equals(getUsername())) {
            return R.error(1, "演示系统不允许修改,完整体验请部署程序");
        }
        Map<String, Object> result = null;
        try {
            result = userService.updatePersonalImg(file, avatarData, getUserId());
        } catch (Exception e) {
            return R.error("更新图像失败！");
        }
        if (result != null && result.size() > 0) {
            return R.ok(result);
        } else {
            return R.error("更新图像失败！");
        }
    }
}
