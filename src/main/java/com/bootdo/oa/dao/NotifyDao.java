package com.bootdo.oa.dao;

import com.bootdo.oa.domain.NotifyDO;
import com.bootdo.oa.domain.NotifyDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;


/**
 * <p>Title: NotifyDao</p>
 * <p>Description: 通知通告 Dao</p>
 *
 * @author
 * @version 1.0
 * @date
 */
@Mapper
public interface NotifyDao {

    NotifyDO get(Long id);

    List<NotifyDO> list(Map<String, Object> map);

    int count(Map<String, Object> map);

    int save(NotifyDO notify);

    int update(NotifyDO notify);

    int remove(Long id);

    int batchRemove(Long[] ids);

    List<NotifyDO> listByIds(Long[] ids);

    int countDTO(Map<String, Object> map);

    List<NotifyDTO> listDTO(Map<String, Object> map);
}
