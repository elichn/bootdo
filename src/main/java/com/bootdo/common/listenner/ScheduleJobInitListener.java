package com.bootdo.common.listenner;

import com.bootdo.common.quartz.utils.QuartzManager;
import com.bootdo.common.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * <p>Title: ScheduleJobInitListener</p>
 * <p>Description: ScheduleJobInitListener</p>
 *
 * @author
 * @version 1.0
 * @date
 */
@Component
@Order(value = 1)
public class ScheduleJobInitListener implements CommandLineRunner {

    @Autowired
    private JobService scheduleJobService;
    @Autowired
    private QuartzManager quartzManager;

    @Override
    public void run(String... arg0) throws Exception {
        try {
            scheduleJobService.initSchedule();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}