package com.bootdo.common.service;

import com.bootdo.common.domain.DictDO;
import com.bootdo.sys.domain.UserDO;

import java.util.List;
import java.util.Map;

/**
 * <p>Title: DictService</p>
 * <p>Description: 字典表 Service</p>
 *
 * @author
 * @version 1.0
 * @date
 */
public interface DictService {

    DictDO get(Long id);

    List<DictDO> list(Map<String, Object> map);

    int count(Map<String, Object> map);

    int save(DictDO dict);

    int update(DictDO dict);

    int remove(Long id);

    int batchRemove(Long[] ids);

    List<DictDO> listType();

    String getName(String type, String value);

    /**
     * getHobbyList 获取爱好列表
     *
     * @param userDO userDO
     * @return List<DictDO>
     */
    List<DictDO> getHobbyList(UserDO userDO);

    /**
     * getSexList 获取性别列表
     *
     * @return List<DictDO>
     */
    List<DictDO> getSexList();

    /**
     * listByType 根据type获取数据
     *
     * @param type type
     * @return List<DictDO>
     */
    List<DictDO> listByType(String type);

}
