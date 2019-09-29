package com.sb.rest.app.sbapph2.model.dto;

import com.fasterxml.jackson.annotation.JsonRootName;
import com.sb.rest.app.sbapph2.model.User;

@JsonRootName("request")
public class MultiUserRequest {


    public User user;

    public MultiUserRequest() {
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "MultiUserRequest{" +
                "user=" + user +
                '}';
    }
    /*    public UserDto getUserroot() {
        return userroot;
    }

    public void setUserroot(UserDto userroot) {
        this.userroot = userroot;
    }

    private UserDto userroot;

    @Override
    public String toString() {
        return "MultiUserRequest{" +
                "userroot=" + userroot +
                '}';
    }*/
}
