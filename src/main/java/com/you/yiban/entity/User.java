package com.you.yiban.entity;

import java.util.Arrays;

public class User {

    // 用户名
    private String username;
    // 用户密码
    private String password;
    // 用户头像
    private String userImage;
    // 用户类型
    private Integer userType;
    // 用户学历
    private String userEducation;


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserImage() {
        return userImage;
    }

    public void setUserImage(String userImage) {
        this.userImage = userImage;
    }

    public Integer getUserType() {
        return userType;
    }

    public void setUserType(Integer userType) {
        this.userType = userType;
    }

    public String getUserEducation() {
        return userEducation;
    }

    public void setUserEducation(String userEducation) {
        this.userEducation = userEducation;
    }

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", userImage='" + userImage + '\'' +
                ", userType=" + userType +
                ", userEducation='" + userEducation + '\'' +
                '}';
    }
}
