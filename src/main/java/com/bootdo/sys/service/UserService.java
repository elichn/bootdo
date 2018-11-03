package com.bootdo.sys.service;

import com.bootdo.common.domain.Tree;
import com.bootdo.sys.domain.DeptDO;
import com.bootdo.sys.domain.UserDO;
import com.bootdo.sys.vo.UserVO;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * <p>Title: UserService</p>
 * <p>Description: 用户 Service</p>
 *
 * @author
 * @version 1.0
 * @date
 */
@Service
public interface UserService {

    /**
     * get 获取UserDO
     *
     * @param id id
     * @return UserDO
     */
    UserDO get(Long id);

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
    int batchremove(Long[] userIds);

    /**
     * exit exit
     *
     * @param params params
     * @return boolean
     */
    boolean exit(Map<String, Object> params);

    /**
     * listRoles listRoles
     *
     * @param userId userId
     * @return Set<String>
     */
    Set<String> listRoles(Long userId);

    /**
     * resetPwd 重置密码
     *
     * @param userVO userVO
     * @param userDO userDO
     * @return int
     * @throws Exception Exception
     */
    int resetPwd(UserVO userVO, UserDO userDO) throws Exception;

    /**
     * adminResetPwd 超级管理员重置密码
     *
     * @param userVO userVO
     * @return int
     * @throws Exception Exception
     */
    int adminResetPwd(UserVO userVO) throws Exception;

    /**
     * getTree 获取部门树
     *
     * @return Tree<DeptDO>
     */
    Tree<DeptDO> getTree();

    /**
     * updatePersonal 更新个人信息
     *
     * @param userDO userDO
     * @return int
     */
    int updatePersonal(UserDO userDO);

    /**
     * updatePersonalImg 更新个人图片
     *
     * @param file        图片
     * @param avatarData 裁剪信息
     * @param userId      用户ID
     * @return Map<String, Object>
     * @throws Exception Exception
     */
    Map<String, Object> updatePersonalImg(MultipartFile file, String avatarData, Long userId) throws Exception;
}
