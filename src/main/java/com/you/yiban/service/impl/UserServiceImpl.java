package com.you.yiban.service.impl;

import com.you.yiban.dao.UserDao;
import com.you.yiban.entity.User;
import com.you.yiban.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    @Transactional
    public User checkLogin(String username,String password){
        User user = userDao.queryByUsername(username);
        if (user != null && user.getPassword().equals(password)){
            return user;
        }else {
            logger.info("账号或密码错误");
            return null;
        }
    }

    @Override
    @Transactional
    public String getUserInformation(String username){
        User user = userDao.queryByUsername(username);
        Integer type = user.getUserType();
        if (type == 1){
            return "管理员";
        }else {
            return "普通用户";
        }

    }
    
}
