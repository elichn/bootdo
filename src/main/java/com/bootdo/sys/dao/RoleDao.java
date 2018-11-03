package com.bootdo.sys.dao;

import com.bootdo.sys.domain.RoleDO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

/**
 * <p>Title: RoleDao</p>
 * <p>Description: 角色 Dao</p>
 *
 * @author
 * @version 1.0
 * @date
 */
@Mapper
public interface RoleDao {

    /**
     * get 获取RoleDO
     *
     * @param roleId roleId
     * @return RoleDO
     */
    RoleDO get(Long roleId);

    /**
     * list 获取RoleDO列表
     *
     * @param map map
     * @return List<RoleDO>
     */
    List<RoleDO> list(Map<String, Object> map);

    /**
     * count 统计RoleDO条数
     *
     * @param map map
     * @return 统计条数
     */
    int count(Map<String, Object> map);

    /**
     * save 保存role
     *
     * @param role role
     * @return 保存成功条数
     */
    int save(RoleDO role);

    /**
     * update 更新role
     *
     * @param role role
     * @return 更新成功条数
     */
    int update(RoleDO role);

    /**
     * remove 根据roleId删除role
     *
     * @param roleId roleId
     * @return 删除成功条数
     */
    int remove(Long roleId);

    /**
     * batchRemove 根据ids删除role
     *
     * @param roleIds roleIds
     * @return 批量删除成功条数
     */
    int batchRemove(Long[] roleIds);
}
