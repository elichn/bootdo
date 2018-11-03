package com.bootdo.common.dao;

import com.bootdo.common.domain.LogDO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

/**
 * <p>Title: LogDao</p>
 * <p>Description: 日志 Dao</p>
 *
 * @author
 * @version 1.0
 * @date
 */
@Mapper
public interface LogDao {

    LogDO get(Long id);

    List<LogDO> list(Map<String, Object> map);

    int count(Map<String, Object> map);

    int save(LogDO log);

    int update(LogDO log);

    int remove(Long id);

    int batchRemove(Long[] ids);
}
