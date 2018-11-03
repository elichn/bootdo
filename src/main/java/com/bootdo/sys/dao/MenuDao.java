package com.bootdo.sys.dao;

import com.bootdo.sys.domain.MenuDO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

/**
 * <p>Title: MenuDao</p>
 * <p>Description: 菜单管理 Dao</p>
 *
 * @author
 * @version 1.0
 * @date
 */
@Mapper
public interface MenuDao {

    /**
     * get 获取MenuDO
     *
     * @param menuId menuId
     * @return MenuDO
     */
    MenuDO get(Long menuId);

    /**
     * list 根据参数获取菜单树列表
     *
     * @param map map
     * @return List<MenuDO>
     */
    List<MenuDO> list(Map<String, Object> map);

    /**
     * count 统计MenuDO条数
     *
     * @param map map
     * @return 统计条数
     */
    int count(Map<String, Object> map);

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
     * remove 根据menuId删除menu
     *
     * @param menuId menuId
     * @return 删除成功条数
     */
    int remove(Long menuId);

    /**
     * batchRemove 根据menuIds批量删除menu
     *
     * @param menuIds menuIds
     * @return 删除成功条数
     */
    int batchRemove(Long[] menuIds);

    /**
     * listMenuByUserId listMenuByUserId
     *
     * @param id id
     * @return List<MenuDO>
     */
    List<MenuDO> listMenuByUserId(Long id);

    /**
     * listUserPerms listUserPerms
     *
     * @param id id
     * @return List<String>
     */
    List<String> listUserPerms(Long id);
}
