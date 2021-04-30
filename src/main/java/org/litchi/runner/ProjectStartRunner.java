package org.litchi.runner;

import lombok.extern.slf4j.Slf4j;
import org.litchi.service.impl.JobServiceImpl;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @author: gaozp
 * @date: 2021-04-30 10:56
 * @desc:
 */

@Slf4j
@Component
public class ProjectStartRunner implements ApplicationRunner {

    @Resource
    private JobServiceImpl jobService;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        this.jobService.init();
    }
}
