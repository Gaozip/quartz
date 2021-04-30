package org.litchi.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.litchi.entity.JobLog;

/**
 * @author: gaozp
 * @date: 2021-04-30 10:18
 * @desc:
 */

@Mapper
public interface JobLogMapper extends BaseMapper<JobLog> {
}
