package com.bootdo.common.dao;

import com.bootdo.common.domain.DictDO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

/**
 * <p>Title: DictDao</p>
 * <p>Description: 字典表 Dao</p>
 *
 * @author
 * @version 1.0
 * @date
 */
@Mapper
public interface DictDao {

    DictDO get(Long id);

    List<DictDO> list(Map<String, Object> map);

    int count(Map<String, Object> map);

    int save(DictDO dict);

    int update(DictDO dict);

    int remove(Long id);

    int batchRemove(Long[] ids);

    List<DictDO> listType();
}
