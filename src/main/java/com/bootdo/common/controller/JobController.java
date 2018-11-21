package com.bootdo.common.controller;

import com.bootdo.common.config.Constant;
import com.bootdo.common.domain.TaskDO;
import com.bootdo.common.service.JobService;
import com.bootdo.common.utils.PageUtils;
import com.bootdo.common.utils.Query;
import com.bootdo.common.utils.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * <p>Title: JobController</p>
 * <p>Description: 任务 Controller</p>
 *
 * @author
 * @version 1.0
 * @date
 */
@Controller
@RequestMapping("/common/job")
public class JobController extends BaseController {

    @Autowired
    private JobService taskScheduleJobService;

    @GetMapping()
    public String taskScheduleJob() {
        return "common/job/job";
    }

    @ResponseBody
    @GetMapping("/list")
    public PageUtils list(@RequestParam Map<String, Object> params) {
        // 查询列表数据
        Query query = new Query(params);
        List<TaskDO> taskScheduleJobList = taskScheduleJobService.list(query);
        int total = taskScheduleJobService.count(query);
        PageUtils pageUtils = new PageUtils(taskScheduleJobList, total);
        return pageUtils;
    }

    @GetMapping("/add")
    public String add() {
        return "common/job/add";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, Model model) {
        TaskDO job = taskScheduleJobService.get(id);
        model.addAttribute("job", job);
        return "common/job/edit";
    }

    @GetMapping("/info/{id}")
    public R info(@PathVariable("id") Long id) {
        TaskDO taskScheduleJob = taskScheduleJobService.get(id);
        return R.ok().put("taskScheduleJob", taskScheduleJob);
    }

    @ResponseBody
    @PostMapping("/save")
    public R save(TaskDO taskScheduleJob) {
        if (Constant.DEMO_ACCOUNT.equals(getUsername())) {
            return R.error(1, "演示系统不允许修改,完整体验请部署程序");
        }
        if (taskScheduleJobService.save(taskScheduleJob) > 0) {
            return R.ok();
        }
        return R.error();
    }

    @ResponseBody
    @PostMapping("/update")
    public R update(TaskDO taskScheduleJob) {
        if (Constant.DEMO_ACCOUNT.equals(getUsername())) {
            return R.error(1, "演示系统不允许修改,完整体验请部署程序");
        }
        taskScheduleJobService.update(taskScheduleJob);
        return R.ok();
    }

    @ResponseBody
    @PostMapping("/remove")
    public R remove(Long id) {
        if (Constant.DEMO_ACCOUNT.equals(getUsername())) {
            return R.error(1, "演示系统不允许修改,完整体验请部署程序");
        }
        if (taskScheduleJobService.remove(id) > 0) {
            return R.ok();
        }
        return R.error();
    }

    @ResponseBody
    @PostMapping("/batchRemove")
    public R remove(@RequestParam("ids[]") Long[] ids) {
        if (Constant.DEMO_ACCOUNT.equals(getUsername())) {
            return R.error(1, "演示系统不允许修改,完整体验请部署程序");
        }
        taskScheduleJobService.batchRemove(ids);

        return R.ok();
    }

    @ResponseBody
    @PostMapping(value = "/changeJobStatus")
    public R changeJobStatus(Long id, String cmd) {
        if (Constant.DEMO_ACCOUNT.equals(getUsername())) {
            return R.error(1, "演示系统不允许修改,完整体验请部署程序");
        }
        String label = "停止";
        if ("start".equals(cmd)) {
            label = "启动";
        } else {
            label = "停止";
        }
        try {
            taskScheduleJobService.changeStatus(id, cmd);
            return R.ok("任务" + label + "成功");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return R.ok("任务" + label + "失败");
    }

}
