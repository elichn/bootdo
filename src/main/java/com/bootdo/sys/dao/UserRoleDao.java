package com.bootdo.sys.dao;

import com.bootdo.sys.domain.UserRoleDO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

/**
 * <p>Title: UserRoleDao</p>
 * <p>Description: 用户与角色对应关系 Dao</p>
 *
 * @author
 * @version 1.0
 * @date
 */
@Mapper
public interface UserRoleDao {

    /**
     * get 获取UserRoleDO
     *
     * @param id id
     * @return UserRoleDO
     */
    UserRoleDO get(Long id);

    /**
     * list 获取UserRoleDO列表
     *
     * @return List<UserRoleDO>
     */
    List<UserRoleDO> list(Map<String, Object> map);

    /**
     * count 统计UserRoleDO条数
     *
     * @param map map
     * @return 统计条数
     */
    int count(Map<String, Object> map);

    /**
     * save 保存userRole
     *
     * @param userRole userRole
     * @return 保存成功条数
     */
    int save(UserRoleDO userRole);

    /**
     * update 更新userRole
     *
     * @param userRole userRole
     * @return 更新成功条数
     */
    int update(UserRoleDO userRole);

    /**
     * remove 根据id删除userRole
     *
     * @param id id
     * @return 删除成功条数
     */
    int remove(Long id);

    /**
     * batchRemove 根据ids批量删除userRole
     *
     * @param ids ids
     * @return 删除成功条数
     */
    int batchRemove(Long[] ids);

    /**
     * listRoleId listRoleId
     *
     * @param userId userId
     * @return List<Long>
     */
    List<Long> listRoleId(Long userId);

    /**
     * removeByUserId removeByUserId
     *
     * @param userId userId
     * @return int
     */
    int removeByUserId(Long userId);

    /**
     * removeByRoleId removeByRoleId
     *
     * @param roleId roleId
     * @return int
     */
    int removeByRoleId(Long roleId);

    /**
     * batchSave batchSave
     *
     * @param list list
     * @return int
     */
    int batchSave(List<UserRoleDO> list);

    /**
     * batchRemoveByUserId batchRemoveByUserId
     *
     * @param ids ids
     * @return int
     */
    int batchRemoveByUserId(Long[] ids);
}
