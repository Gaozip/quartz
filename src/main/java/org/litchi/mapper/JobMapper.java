package org.litchi.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.litchi.entity.Job;

import java.util.List;

/**
 * @author: gaozp
 * @date: 2021-04-30 10:18
 * @desc:
 */
@Mapper
public interface JobMapper extends BaseMapper<Job> {

    /**
     * 获取定时任务列表
     *
     * @return 定时任务列表
     */
    List<Job> queryList();
}
