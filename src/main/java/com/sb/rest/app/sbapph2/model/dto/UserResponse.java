package com.sb.rest.app.sbapph2.model.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;
import com.sb.rest.app.sbapph2.model.User;
import com.sb.rest.app.sbapph2.utils.StatusCode;

@JsonRootName("response")
public class UserResponse {

    @JsonProperty("statusCode")
    public  StatusCode statusCode;

    @JsonProperty("userInfo")
    public  User userInfo;

    public UserResponse() {
    }


    public StatusCode getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(StatusCode statusCode) {
        this.statusCode = statusCode;
    }

    public User getUserInfo() {
        return userInfo;
    }

    public void setUserInfo(User userInfo) {
        this.userInfo = userInfo;
    }

    @Override
    public String toString() {
        return "UserResponse{" +
                "statusCode=" + statusCode +
                ", userInfo=" + userInfo +
                '}';
    }
}
