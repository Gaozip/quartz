package org.litchi.core;

/**
 * @author: gaozp
 * @date: 2021-04-30 10:21
 * @desc: 响应结果生成工具
 */
public class ResultGenerator {
    private static final String DEFAULT_SUCCESS_MESSAGE = "SUCCESS";

    /**
     * 成功，无数据返回
     * @return
     */
    public static Result genSuccessResult() {
        return new Result()
                .setCode(ResultCode.SUCCESS)
                .setMessage(DEFAULT_SUCCESS_MESSAGE);
    }

    /**
     * 成功，带返回去数据
     * @param data
     * @return
     */
    public static Result genSuccessResult(Object data) {
        return new Result()
                .setCode(ResultCode.SUCCESS)
                .setMessage(DEFAULT_SUCCESS_MESSAGE)
                .setData(data);
    }

    /**
     * 失败
     * @param message
     * @return
     */
    public static Result genFailResult(String message) {
        return new Result()
                .setCode(ResultCode.FAIL)
                .setMessage(message);
    }

    /**
     * 无session
     * @return
     */
    public static Result genNoSessionResult(){
        return new Result()
                .setCode(ResultCode.NO_SESSION)
                .setMessage("无session");
    }

    /**
     * session过期
     * @return
     */
    public static Result genSessionTimeOutResult(){
        return new Result()
                .setCode(ResultCode.SESSION_TIME_OUT)
                .setMessage("session 已过期");
    }
}
