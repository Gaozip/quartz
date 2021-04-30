package org.litchi.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import org.litchi.constant.ProjectConstant;
import org.litchi.core.QueryRequest;
import org.litchi.entity.JobLog;
import org.springframework.scheduling.annotation.Async;

/**
 * @author: gaozp
 * @date: 2021-04-30 10:11
 * @desc:
 */
public interface IJobLogService {

    /**
     * 获取定时任务日志分页数据
     *
     * @param request request
     * @param jobLog  jobLog
     * @return 定时任务日志分页数据
     */
    IPage<JobLog> findJobLogs(QueryRequest request, JobLog jobLog);

    /**
     * 保存定时任务日志
     *
     * @param log 定时任务日志
     */
    @Async(ProjectConstant.PROJECT_THREAD_POOL)
    void saveJobLog(JobLog log);

    /**
     * 删除定时任务日志
     *
     * @param jobLogIds 定时任务日志id数组
     */
    void deleteJobLogs(String[] jobLogIds);
}
