package org.litchi.core;

/**
 * @author: gaozp
 * @date: 2021-04-30 10:21
 * @desc:
 */
public enum ResultCode {

    /**
     * 成功
     */
    SUCCESS(200),
    /**
     * 失败
     */
    FAIL(400),
    /**
     * 未认证（签名错误）
     */
    UNAUTHORIZED(401),
    /**
     * 接口不存在
     */
    NOT_FOUND(404),
    /**
     * 服务器内部错误
     */
    INTERNAL_SERVER_ERROR(500),
    /**
     * 无session
     */
    NO_SESSION(600),
    /**
     * session 过期
     */
    SESSION_TIME_OUT(601);


    private final int code;

    ResultCode(int code) {
        this.code = code;
    }

    public int code() {
        return code;
    }
}

