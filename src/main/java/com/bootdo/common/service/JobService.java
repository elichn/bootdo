package com.bootdo.common.service;

import com.bootdo.common.domain.TaskDO;

import java.util.List;
import java.util.Map;

import org.quartz.SchedulerException;

/**
 * <p>Title: JobService</p>
 * <p>Description: JobService</p>
 *
 * @author
 * @version 1.0
 * @date
 */
public interface JobService {
	
	TaskDO get(Long id);
	
	List<TaskDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(TaskDO taskScheduleJob);
	
	int update(TaskDO taskScheduleJob);
	
	int remove(Long id);
	
	int batchRemove(Long[] ids);

	void initSchedule() throws SchedulerException;

	void changeStatus(Long jobId, String cmd) throws SchedulerException;

	void updateCron(Long jobId) throws SchedulerException;
}
