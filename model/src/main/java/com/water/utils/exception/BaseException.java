package com.water.utils.exception;

/**
 * Created by mrwater on 2017/11/16.
 */
public class BaseException extends Throwable {
    private String errCode = "";
    private String errMsg = "";

    public BaseException(){
        this.initCause((Throwable)null);
    }

    public BaseException(String errCode, String errMsg){
        super(errMsg);
        this.errMsg = errMsg;
        this.errCode = errCode;
    }

    public BaseException(Throwable throwable){
        super(throwable);
    }



    public String getErrMsg() {
        return errMsg;
    }

    public String getErrCode() {
        return errCode;
    }
}
