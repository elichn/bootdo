package com.bootdo.sys.service;

import com.bootdo.sys.domain.RoleDO;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>Title: RoleService</p>
 * <p>Description: 角色 Service</p>
 *
 * @author
 * @version 1.0
 * @date
 */
@Service
public interface RoleService {

    /**
     * get 获取RoleDO
     *
     * @param id id
     * @return RoleDO
     */
    RoleDO get(Long id);

    /**
     * list 获取RoleDO列表
     *
     * @return List<RoleDO>
     */
    List<RoleDO> list();

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
     * remove 根据id删除role
     *
     * @param id id
     * @return 删除成功条数
     */
    int remove(Long id);

    /**
     * batchRemove 根据ids删除role
     *
     * @param ids ids
     * @return 批量删除成功条数
     */
    int batchremove(Long[] ids);

    /**
     * list 根据userId获取角色列表
     *
     * @param userId userId
     * @return List<RoleDO>
     */
    List<RoleDO> list(Long userId);


}
