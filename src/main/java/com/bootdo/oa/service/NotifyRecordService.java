package com.bootdo.oa.service;

import com.bootdo.oa.domain.NotifyRecordDO;

import java.util.List;
import java.util.Map;

/**
 * <p>Title: NotifyRecordService</p>
 * <p>Description: 通知通告发送记录 Service</p>
 *
 * @author
 * @version 1.0
 * @date
 */
public interface NotifyRecordService {

    NotifyRecordDO get(Long id);

    List<NotifyRecordDO> list(Map<String, Object> map);

    int count(Map<String, Object> map);

    int save(NotifyRecordDO notifyRecord);

    int update(NotifyRecordDO notifyRecord);

    int remove(Long id);

    int batchRemove(Long[] ids);

    /**
     * 更改阅读状态
     *
     * @return
     */
    int changeRead(NotifyRecordDO notifyRecord);
}
