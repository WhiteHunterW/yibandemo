package com.you.yiban.dao;

import com.you.yiban.entity.Message;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;

/**
 * @author w.z
 * @date 2019/8/12 10:00
 */

@RunWith(SpringRunner.class)
@SpringBootTest
public class MessageDaoTest {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private MessageDao messageDao;
    @Test
    public void insertMessage() {
        Message message = new Message();
        message.setMessageType("后勤处");
        message.setUsername("test2");
        message.setMessage("内容");
        message.setQq("289300@qq.com");
        message.setPhone("8949832482");
        messageDao.insertMessage(message);
    }

    @Test
    public void queryListMessageByUsername() {
        Message message = new Message();
        
        message.setUsername("test3");
        message.setMessageAnswer("agree");
        message.setMessage("baoliao");
       // message.setCreateTime();
        message.setMessageState(2);
        message.setQq("88888");
        message.setPhone("19800303");
        message.setMessageType("xxxxx");
        
        messageDao.insertMessage(message);
        logger.info("message={}",message);
        
    }

    @Test
    public void getAllMessage() {
        List<Message> list = messageDao.getAllMessage();
        logger.info("list={}",list);
    }

    @Test
    public void getMessageWithAnswer() {
        List<Message> list = messageDao.getMessageWithAnswer();
        logger.info("answerlist={}",list);
        System.out.println(list);
        
    }

    @Test
    public void getWaitDeal() {
        List<Message> list = messageDao.getWaitDeal();
        logger.info("wailist={}",list);
        
    }

    @Test
    public void dealMessage() {
        
        int result = messageDao.dealMessage(2,"回复","imge/test3.jpg","user3");
        logger.info("result={}",result);
        
    }

    @Test
    public void delete() {
        boolean result = messageDao.delete(3);
        logger.info("result={}",result);
    }
    
    @Test
    public void getByMessageId(){
        Message message = messageDao.getByMessageId(2);
        logger.info("message={}",message);
    }
}