package org.litchi.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.litchi.constant.Strings;
import org.litchi.core.BaseController;
import org.litchi.core.QueryRequest;
import org.litchi.core.Result;
import org.litchi.core.ResultGenerator;
import org.litchi.entity.Job;
import org.litchi.service.IJobService;
import org.quartz.CronExpression;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;

/**
 * @author: gaozp
 * @date: 2021-04-30 10:48
 * @desc:
 */
@Slf4j
@Validated
@RestController
@RequestMapping("job")
@RequiredArgsConstructor
public class JobController extends BaseController {

    private final IJobService jobService;

    @GetMapping
    public Result jobList(QueryRequest request, Job job) {

        return ResultGenerator.genSuccessResult(getDataTable(jobService.findJobs(request, job)));
    }

    @GetMapping("cron/check")
    public boolean checkCron(String cron) {
        try {
            return CronExpression.isValidExpression(cron);
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * 新增定时任务
     * @param job
     * @return
     */
    @PostMapping
    public Result addJob(@Valid Job job) {
        jobService.createJob(job);
        return ResultGenerator.genSuccessResult();
    }

    /**
     * 删除定时任务
     * @param jobIds
     * @return
     */
    @GetMapping("delete/{jobIds}")
    public Result deleteJob(@NotBlank(message = "{required}") @PathVariable String jobIds) {
        jobService.deleteJobs(StringUtils.split(jobIds, Strings.COMMA));
        return ResultGenerator.genSuccessResult();
    }

    /**
     * 修改定时任务
     * @param job
     * @return
     */
    @PostMapping("update")
    public Result updateJob(@Valid Job job) {
        jobService.updateJob(job);
        return ResultGenerator.genSuccessResult();
    }

    /**
     * 执行定时任务
     * @param jobIds
     * @return
     */
    @GetMapping("run/{jobIds}")
    public Result runJob(@NotBlank(message = "{required}") @PathVariable String jobIds) {
        jobService.run(jobIds);
        return ResultGenerator.genSuccessResult();
    }

    /**
     * 暂停定时任务
     * @param jobIds
     * @return
     */
    @GetMapping("pause/{jobIds}")
    public Result pauseJob(@NotBlank(message = "{required}") @PathVariable String jobIds) {
        jobService.pause(jobIds);
        return ResultGenerator.genSuccessResult();
    }

    /**
     * 恢复定时任务
     * @param jobIds
     * @return
     */
    @GetMapping("resume/{jobIds}")
    public Result resumeJob(@NotBlank(message = "{required}") @PathVariable String jobIds) {
        jobService.resume(jobIds);
        return ResultGenerator.genSuccessResult();
    }
}
