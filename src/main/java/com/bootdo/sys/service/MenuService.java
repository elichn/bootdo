package com.bootdo.sys.service;

import com.bootdo.common.domain.Tree;
import com.bootdo.sys.domain.MenuDO;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * <p>Title: MenuService</p>
 * <p>Description: 菜单管理 Service</p>
 *
 * @author
 * @version 1.0
 * @date
 */
@Service
public interface MenuService {

    /**
     * getSysMenuTree 根据菜单id获取菜单树
     *
     * @param id id
     * @return Tree<MenuDO>
     */
    Tree<MenuDO> getSysMenuTree(Long id);

    /**
     * listMenuTree 根据菜单id获取菜单树列表
     *
     * @param id id
     * @return List<Tree<MenuDO>>
     */
    List<Tree<MenuDO>> listMenuTree(Long id);

    /**
     * getTree 获取菜单树
     *
     * @return Tree<MenuDO>
     */
    Tree<MenuDO> getTree();

    /**
     * getTree 根据菜单id获取菜单树
     *
     * @param id id
     * @return Tree<MenuDO>
     */
    Tree<MenuDO> getTree(Long id);

    /**
     * get 获取MenuDO
     *
     * @param id id
     * @return MenuDO
     */
    MenuDO get(Long id);

    /**
     * list 根据参数获取菜单树列表
     *
     * @param params params
     * @return List<MenuDO>
     */
    List<MenuDO> list(Map<String, Object> params);

    /**
     * save 保存menu
     *
     * @param menu menu
     * @return 保存成功条数
     */
    int save(MenuDO menu);

    /**
     * update 更新menu
     *
     * @param menu menu
     * @return 更新成功条数
     */
    int update(MenuDO menu);

    /**
     * remove 根据id删除menu
     *
     * @param id id
     * @return 删除成功条数
     */
    int remove(Long id);

    /**
     * listPerms listPerms
     *
     * @param userId userId
     * @return Set<String>
     */
    Set<String> listPerms(Long userId);
}
