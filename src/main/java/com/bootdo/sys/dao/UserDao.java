package com.bootdo.sys.dao;

import com.bootdo.sys.domain.UserDO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

/**
 * <p>Title: UserDao</p>
 * <p>Description: 用户 Dao</p>
 *
 * @author
 * @version 1.0
 * @date
 */
@Mapper
public interface UserDao {

    /**
     * get 获取UserDO
     *
     * @param userId userId
     * @return UserDO
     */
    UserDO get(Long userId);

    /**
     * list 获取UserDO列表
     *
     * @param map map
     * @return List<UserDO>
     */
    List<UserDO> list(Map<String, Object> map);

    /**
     * count 统计UserDO条数
     *
     * @param map map
     * @return 统计条数
     */
    int count(Map<String, Object> map);

    /**
     * save 保存user
     *
     * @param user user
     * @return 保存成功条数
     */
    int save(UserDO user);

    /**
     * update 更新user
     *
     * @param user user
     * @return 更新成功条数
     */
    int update(UserDO user);

    /**
     * remove 根据userId删除user
     *
     * @param userId userId
     * @return 删除成功条数
     */
    int remove(Long userId);

    /**
     * batchRemove 根据userIds删除user
     *
     * @param userIds userIds
     * @return 批量删除成功条数
     */
    int batchRemove(Long[] userIds);

    /**
     * listAllDept 所有部门id
     *
     * @return Long[]
     */
    Long[] listAllDept();

}
