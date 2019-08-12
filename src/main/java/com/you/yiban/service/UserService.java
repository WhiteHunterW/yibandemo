package com.you.yiban.service;

import com.you.yiban.entity.User;

public interface UserService {

    /**
     * 检验用户登录
     * @param username
     * @param password
     * @return
     */
    public User checkLogin(String username,String password);

    /**
     * 查看用户权限
     * @param username
     * @return
     */
    public String getUserInformation(String username);

}
