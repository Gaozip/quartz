package org.litchi.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.litchi.constant.Strings;
import org.litchi.core.BaseController;
import org.litchi.core.QueryRequest;
import org.litchi.core.Result;
import org.litchi.core.ResultGenerator;
import org.litchi.entity.JobLog;
import org.litchi.service.IJobLogService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.NotBlank;

/**
 * @author: gaozp
 * @date: 2021-04-30 10:48
 * @desc:
 */
@Slf4j
@Validated
@RestController
@RequestMapping("jobLog")
@RequiredArgsConstructor
public class JobLogController extends BaseController {

    private final IJobLogService jobLogService;

    @GetMapping
    public Result jobLogList(QueryRequest request, JobLog log) {
        return ResultGenerator.genSuccessResult(getDataTable(jobLogService.findJobLogs(request, log)));
    }

    @GetMapping("delete/{jobIds}")
    public Result deleteJobLog(@NotBlank(message = "{required}") @PathVariable String jobIds) {
        jobLogService.deleteJobLogs(StringUtils.split(jobIds, Strings.COMMA));
        return ResultGenerator.genSuccessResult();
    }
}