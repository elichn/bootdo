package com.bootdo.common.dao;

import com.bootdo.common.domain.TaskDO;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

/**
 * <p>Title: TaskDao</p>
 * <p>Description: TaskDao</p>
 *
 * @author
 * @version 1.0
 * @date
 */
@Mapper
public interface TaskDao {

	TaskDO get(Long id);
	
	List<TaskDO> list(Map<String,Object> map);
	
	int count(Map<String,Object> map);
	
	int save(TaskDO task);
	
	int update(TaskDO task);
	
	int remove(Long id);
	
	int batchRemove(Long[] ids);
}
