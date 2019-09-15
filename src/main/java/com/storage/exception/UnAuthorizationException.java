package com.storage.exception;

/**
 * @author zhangyq
 * @create 2019-09-12 19:18
 */
public class UnAuthorizationException extends RuntimeException {

    public UnAuthorizationException() {
        super();
    }
    public UnAuthorizationException(String message) {
        super(message);
    }
    public UnAuthorizationException(String message, Throwable cause) {
        super(message, cause);
    }
    public UnAuthorizationException(Throwable cause) {
        super(cause);
    }
    protected UnAuthorizationException(String message, Throwable cause,
                                       boolean enableSuppression,
                                       boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
