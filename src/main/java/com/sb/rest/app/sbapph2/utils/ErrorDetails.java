package com.sb.rest.app.sbapph2.utils;

import java.util.Date;



public class ErrorDetails {
    String errMsg;
    String statuscode;
    String details;


    Date timestamp;
    public String getErrMsg() {
        return errMsg;
    }

    public void setErrMsg(String errMsg) {
        this.errMsg = errMsg;
    }

    public String getStatuscode() {
        return statuscode;
    }

    public void setStatuscode(String statuscode) {
        this.statuscode = statuscode;
    }
    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }


    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }
    public ErrorDetails(String errMsg, String statuscode, Date timestamp, String details) {
        this.errMsg = errMsg;
        this.statuscode = statuscode;
        this.timestamp = timestamp;
        this.details = details;
    }

    @Override
    public String toString() {
        return "ErrorDetails :[errMsg= "+errMsg+",statuscode ="+statuscode+",timestamp="+timestamp+",details="+details+" ] ";
    }
}
