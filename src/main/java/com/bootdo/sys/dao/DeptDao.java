package com.bootdo.sys.dao;

import com.bootdo.sys.domain.DeptDO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

/**
 * <p>Title: DeptDao</p>
 * <p>Description: 部门管理 Dao</p>
 *
 * @author
 * @version 1.0
 * @date
 */
@Mapper
public interface DeptDao {

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
     * @param dept dept
     * @return 保存成功条数
     */
    int save(DeptDO dept);

    /**
     * update 更新dept
     *
     * @param dept dept
     * @return 更新成功条数
     */
    int update(DeptDO dept);

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
     * listParentDept listParentDept
     *
     * @return Long[]
     */
    Long[] listParentDept();

    /**
     * getDeptUserNumber 根据deptId查询部门以及此部门的下级部门
     *
     * @param deptId deptId
     * @return int
     */
    int getDeptUserNumber(Long deptId);
}
