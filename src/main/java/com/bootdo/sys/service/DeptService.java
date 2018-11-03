package com.bootdo.sys.service;

import com.bootdo.common.domain.Tree;
import com.bootdo.sys.domain.DeptDO;

import java.util.List;
import java.util.Map;

/**
 * <p>Title: DeptService</p>
 * <p>Description: 部门管理 Service</p>
 *
 * @author
 * @version 1.0
 * @date
 */
public interface DeptService {

    /**
     * get 获取DeptDO
     *
     * @param deptId deptId
     * @return DeptDO
     */
    DeptDO get(Long deptId);

    /**
     * list 获取DeptDO列表
     *
     * @param map map
     * @return List<DeptDO>
     */
    List<DeptDO> list(Map<String, Object> map);

    /**
     * count 统计DeptDO条数
     *
     * @param map map
     * @return 统计条数
     */
    int count(Map<String, Object> map);

    /**
     * save 保存dept
     *
     * @param sysDept sysDept
     * @return 保存成功条数
     */
    int save(DeptDO sysDept);

    /**
     * update 更新sysDept
     *
     * @param sysDept sysDept
     * @return 更新成功条数
     */
    int update(DeptDO sysDept);

    /**
     * remove 根据deptId删除sysDept
     *
     * @param deptId deptId
     * @return 删除成功条数
     */
    int remove(Long deptId);

    /**
     * batchRemove 根据deptIds删除sysDept
     *
     * @param deptIds deptIds
     * @return 批量删除成功条数
     */
    int batchRemove(Long[] deptIds);

    /**
     * getTree 根据sysDept树
     *
     * @return Tree<DeptDO>
     */
    Tree<DeptDO> getTree();

    /**
     * checkDeptHasUser 根据deptId检查该部门是否有用户
     *
     * @return boolean
     */
    boolean checkDeptHasUser(Long deptId);
}
