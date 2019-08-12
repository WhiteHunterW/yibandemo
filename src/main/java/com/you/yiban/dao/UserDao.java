package com.you.yiban.dao;

import com.you.yiban.entity.User;

public interface UserDao {
    /**
     * 按id查找用户信息
     * @param username
     * @return
     */
    User queryByUsername(String username);
}
