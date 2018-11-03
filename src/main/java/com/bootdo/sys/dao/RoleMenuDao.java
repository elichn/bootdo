package com.bootdo.sys.dao;

import com.bootdo.sys.domain.RoleMenuDO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

/**
 * <p>Title: RoleMenuDao</p>
 * <p>Description: 角色与菜单对应关系 Dao</p>
 *
 * @author
 * @version 1.0
 * @date
 */
@Mapper
public interface RoleMenuDao {

    /**
     * get 获取RoleMenuDO
     *
     * @param id id
     * @return RoleMenuDO
     */
    RoleMenuDO get(Long id);

    /**
     * list 获取RoleMenuDO列表
     *
     * @return List<RoleMenuDO>
     */
    List<RoleMenuDO> list(Map<String, Object> map);

    /**
     * count 统计RoleMenuDO条数
     *
     * @param map map
     * @return 统计条数
     */
    int count(Map<String, Object> map);

    /**
     * save 保存roleMenu
     *
     * @param roleMenu roleMenu
     * @return 保存成功条数
     */
    int save(RoleMenuDO roleMenu);

    /**
     * update 更新roleMenu
     *
     * @param roleMenu roleMenu
     * @return 更新成功条数
     */
    int update(RoleMenuDO roleMenu);

    /**
     * remove 根据id删除roleMenu
     *
     * @param id id
     * @return 删除成功条数
     */
    int remove(Long id);

    /**
     * batchRemove 根据ids批量删除roleMenu
     *
     * @param ids ids
     * @return 删除成功条数
     */
    int batchRemove(Long[] ids);

    /**
     * listMenuIdByRoleId 通过roleId获取菜单id列表
     *
     * @param roleId roleId
     * @return List<Long>
     */
    List<Long> listMenuIdByRoleId(Long roleId);

    /**
     * removeByRoleId 根据roleId删除
     *
     * @param roleId roleId
     * @return int
     */
    int removeByRoleId(Long roleId);

    /**
     * removeByMenuId removeByMenuId
     *
     * @param menuId menuId
     * @return int
     */
    int removeByMenuId(Long menuId);

    /**
     * batchSave 批量保存
     *
     * @param list list
     * @return int
     */
    int batchSave(List<RoleMenuDO> list);
}
