package com.you.yiban.dao;

import com.you.yiban.entity.User;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * @author w.z
 * @date 2019/8/11 21:18
 */

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserDaoTest {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());
   @Autowired
    private UserDao userDao;
    @Test
    public void queryByUsername() {
        User user = new User();
        user = userDao.queryByUsername("test1");
        logger.info("user{}",user);
    }
}