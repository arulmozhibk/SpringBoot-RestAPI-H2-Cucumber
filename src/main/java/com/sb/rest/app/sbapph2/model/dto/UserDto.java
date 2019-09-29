package com.sb.rest.app.sbapph2.model.dto;


import com.fasterxml.jackson.annotation.JsonRootName;
import com.sb.rest.app.sbapph2.model.User;

@JsonRootName("userInfo")
/*@JsonRootName("userInfo")*/
public class UserDto extends User {
    private static final long serialVersionUID=1L;
    private String appId;
    private String groupId;
    private String userId;  // PK to Alphanumeric e.g BALAGSK01, BALAGSK02
    private String name;
    private String address;
    private String country;
    private String roleId;
    private String email;
    private String password;
    private String createdDate; // Change to String
    private String modifiedDate;

    public UserDto() {
    }

    public UserDto(String appId, String groupId, String userId) {
        this.appId = appId;
        this.groupId = groupId;
        this.userId = userId;
    }

    public User UserDto(String appId, String groupId, String userId, String name, String address, String country, String roleId, String email, String password, String createdDate, String modifiedDate) {
       User user =new User();
       user.setAppId(appId);
       user.setGroupId(groupId);
       user.setUserId(userId);
       user.setName(name);
       user.setAddress(address);
       user.setCountry(country);
       user.setRoleId(roleId);
       user.setEmail(email);
       user.setPassword(password);
       user.setCreatedDate(createdDate);
       user.setModifiedDate(modifiedDate);
       return  user;
    }

    @Override
    public String getAppId() {
        return appId;
    }

    @Override
    public void setAppId(String appId) {
        this.appId = appId;
    }

    @Override
    public String getGroupId() {
        return groupId;
    }

    @Override
    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }

    @Override
    public String getUserId() {
        return userId;
    }

    @Override
    public void setUserId(String userId) {
        this.userId = userId;
    }

    @Override
    public String getName() {
        return name;
    }


    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getAddress() {
        return address;
    }

    @Override
    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String getCountry() {
        return country;
    }

    @Override
    public void setCountry(String country) {
        this.country = country;
    }

    @Override
    public String getRoleId() {
        return roleId;
    }

    @Override
    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }

    @Override
    public String getEmail() {
        return email;
    }

    @Override
    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String getCreatedDate() {
        return createdDate;
    }

    @Override
    public void setCreatedDate(String createdDate) {
        this.createdDate = createdDate;
    }

    @Override
    public String getModifiedDate() {
        return modifiedDate;
    }

    @Override
    public void setModifiedDate(String modifiedDate) {
        this.modifiedDate = modifiedDate;
    }
    @Override
    public String toString() {
        return "UserDto{" +
                "appId='" + appId + '\'' +
                ", groupId='" + groupId + '\'' +
                ", userId='" + userId + '\'' +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", country='" + country + '\'' +
                ", roleId='" + roleId + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", createdDate='" + createdDate + '\'' +
                ", modifiedDate='" + modifiedDate + '\'' +
                '}';
    }


}
