package org.litchi.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author: gaozp
 * @date: 2021-04-30 10:12
 * @desc:
 */
@Data
@TableName("t_job")
public class Job implements Serializable {

    /**
     * 任务调度参数 key
     */
    public static final String JOB_PARAM_KEY = "JOB_PARAM_KEY";
    private static final long serialVersionUID = 400066840871805700L;
    @TableId(value = "JOB_ID", type = IdType.AUTO)
    private Long jobId;
    @TableField("bean_name")
    private String beanName;
    @TableField("method_name")
    private String methodName;
    @TableField("params")
    private String params;
    @TableField("cron_expression")
    private String cronExpression;
    @TableField("status")
    private String status;
    @TableField("remark")
    private String remark;
    @TableField("create_time")
    private Date createTime;
    private transient String createTimeFrom;
    private transient String createTimeTo;

    public enum ScheduleStatus {
        /**
         * 正常
         */
        NORMAL("0"),
        /**
         * 暂停
         */
        PAUSE("1");

        private final String value;

        ScheduleStatus(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }
    }

}

