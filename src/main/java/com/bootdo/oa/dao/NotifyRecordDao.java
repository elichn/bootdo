package com.bootdo.oa.dao;

import com.bootdo.oa.domain.NotifyRecordDO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

/**
 * <p>Title: NotifyRecordDao</p>
 * <p>Description: 通知通告发送记录 Dao</p>
 *
 * @author
 * @version 1.0
 * @date
 */
@Mapper
public interface NotifyRecordDao {

    NotifyRecordDO get(Long id);

    List<NotifyRecordDO> list(Map<String, Object> map);

    int count(Map<String, Object> map);

    int save(NotifyRecordDO notifyRecord);

    int update(NotifyRecordDO notifyRecord);

    int remove(Long id);

    int batchRemove(Long[] ids);

    int batchSave(List<NotifyRecordDO> records);

    Long[] listNotifyIds(Map<String, Object> map);

    int removeByNotifbyId(Long notifyId);

    int batchRemoveByNotifbyId(Long[] notifyIds);

    int changeRead(NotifyRecordDO notifyRecord);
}
