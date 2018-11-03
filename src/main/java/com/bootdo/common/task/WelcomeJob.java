package com.bootdo.common.task;

import com.bootdo.oa.domain.Response;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Component;

/**
 * <p>Title: WelcomeJob</p>
 * <p>Description: WelcomeJob</p>
 *
 * @author
 * @version 1.0
 * @date
 */
@Component
public class WelcomeJob implements Job {

    @Autowired
    private SimpMessagingTemplate template;

    @Override
    public void execute(JobExecutionContext arg0) {
        template.convertAndSend("/topic/getResponse", new Response("欢迎体验bootdo,这是一个任务计划，使用了websocket和quzrtz技术，可以在计划列表中取消，欢迎您加入qq群交流学习!"));
    }

}