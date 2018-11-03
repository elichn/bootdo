package com.bootdo.common.service;

import com.bootdo.common.domain.LogDO;
import com.bootdo.common.domain.PageDO;
import com.bootdo.common.utils.Query;
import org.springframework.stereotype.Service;

/**
 * <p>Title: LogService</p>
 * <p>Description: 日志 Service</p>
 *
 * @author
 * @version 1.0
 * @date
 */
@Service
public interface LogService {
    /**
     * save 保存日志
     *
     * @param logDO logDO
     */
    void save(LogDO logDO);

    /**
     * queryList 查询获取列表
     *
     * @param query query
     * @return PageDO<LogDO>
     */
    PageDO<LogDO> queryList(Query query);

    /**
     * remove 根据id删除日志
     *
     * @param id id
     * @return 删除成功条数
     */
    int remove(Long id);

    /**
     * batchRemove 根据ids删除日志
     *
     * @param ids ids
     * @return 删除成功条数
     */
    int batchRemove(Long[] ids);
}
