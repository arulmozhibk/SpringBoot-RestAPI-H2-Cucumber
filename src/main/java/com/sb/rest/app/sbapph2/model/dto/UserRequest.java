package com.sb.rest.app.sbapph2.model.dto;


import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;
import com.sb.rest.app.sbapph2.model.User;

@JsonRootName("request")
public class UserRequest {
private static final long serialVersionUID=1L;

    @JsonProperty("clientInfo")
    public User clientInfo;
    @JsonProperty("userInfo")
    public User userInfo;

    public UserRequest() {
    }

    public User getClientInfo() {
        return clientInfo;
    }

    public void setClientInfo(User clientInfo) {
        this.clientInfo = clientInfo;
    }

    public User getUserInfo() {
        return userInfo;
    }

    public void setUserInfo(User userInfo) {
        this.userInfo = userInfo;
    }

}
