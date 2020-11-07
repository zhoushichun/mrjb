package com.cqmrjb.common.exception;

/**
 * @ClassName: JCException
 * @Description: <p> (自定义异常)</p>
 * @author：furao
 * @date: 2020/4/27 18:23
 * ${tags}$
 */

public class MException extends Exception {

    private static final long serialVersionUID = 1L;

    private String msg;
    private int code;

    public MException() {
        this.code = 500;
    }

    public MException(String msg, Throwable cause) {
        super(msg,cause);
        this.msg = msg;
    }

    public MException(String msg, int code) {
        super(msg);
        this.code = code;
    }

    public MException(String msg, int code, Throwable cause) {
        super(msg,cause);
        this.msg = msg;
        this.code = code;
    }

    public MException(String msg) {
        super(msg);
        this.code = 500;
        this.msg = msg;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }
}
