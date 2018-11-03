package com.bootdo.oa.service;

import com.bootdo.common.utils.PageUtils;
import com.bootdo.oa.domain.NotifyDO;

import java.util.List;
import java.util.Map;

/**
 * <p>Title: NotifyService</p>
 * <p>Description: 通知通告 Service</p>
 *
 * @author
 * @version 1.0
 * @date
 */
public interface NotifyService {

    NotifyDO get(Long id);

    List<NotifyDO> list(Map<String, Object> map);

    int count(Map<String, Object> map);

    int save(NotifyDO notify);

    int update(NotifyDO notify);

    int remove(Long id);

    int batchRemove(Long[] ids);

//	Map<String, Object> message(Long userId);

    PageUtils selfList(Map<String, Object> map);
}
