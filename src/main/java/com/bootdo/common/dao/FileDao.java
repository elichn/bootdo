package com.bootdo.common.dao;

import com.bootdo.common.domain.FileDO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

/**
 * <p>Title: FileDao</p>
 * <p>Description: 文件上传 Dao</p>
 *
 * @author
 * @version 1.0
 * @date
 */
@Mapper
public interface FileDao {

    FileDO get(Long id);

    List<FileDO> list(Map<String, Object> map);

    int count(Map<String, Object> map);

    int save(FileDO file);

    int update(FileDO file);

    int remove(Long id);

    int batchRemove(Long[] ids);
}
