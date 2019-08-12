package com.you.yiban.service.impl;

import com.you.yiban.dao.UserDao;
import com.you.yiban.entity.User;
import com.you.yiban.service.UserService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.mock;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

/**
 * @author w.z
 * @date 2019/8/11 23:07
 */

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserServiceImplTest {

    @Resource
    private UserService userService;
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Test
    public void checkLogin() {
       User user = new User();
       user = userService.checkLogin("test1","12345");
        logger.info("uer={}",user);
    }

    @Test
    public void getUserInformation() {
       
        String type = userService.getUserInformation("test1");
        logger.info("type={}",type);
    }
    
}