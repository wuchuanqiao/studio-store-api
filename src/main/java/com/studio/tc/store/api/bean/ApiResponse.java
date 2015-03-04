package com.studio.tc.store.api.bean;

import java.io.Serializable;

/**
 * Created by chuanqiao.wu on 2015/3/1.
 */
public class ApiResponse<T> implements Serializable {
    private boolean ret;
    private ApiError error;
    private T data;

    public boolean isRet() {
        return ret;
    }

    public void setRet(boolean ret) {
        this.ret = ret;
    }

    public ApiError getError() {
        return error;
    }

    public void setError(ApiError error) {
        this.error = error;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }


    public static class ApiError implements Serializable {
        private String message;
        private int code;
        private Throwable throwable;

        public String getMessage() {
            return message;
        }

        public void setMessage(String message) {
            this.message = message;
        }

        public int getCode() {
            return code;
        }

        public void setCode(int code) {
            this.code = code;
        }

        public Throwable getThrowable() {
            return throwable;
        }

        public void setThrowable(Throwable throwable) {
            this.throwable = throwable;
        }
    }
}
