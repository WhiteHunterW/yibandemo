package com.you.yiban.service.impl;

import com.you.yiban.dao.MessageDao;
import com.you.yiban.entity.Message;
import com.you.yiban.service.MessageService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


/**
 * @author w.z
 * @date 2019/8/11 22:59
 */

@RunWith(SpringRunner.class)
@SpringBootTest
public class MessageServiceImplTest {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    
    @Resource
    private MessageService messageService;
    @Test
    public void getListByUsername() {
        
        List<Message> list = messageService.getListByUsername("test1");
        logger.info("messagelist={}",list);
    }

    @Test
    public void addMessage() {
        
        Message message = new Message();
        message.setMessage("hello");// 爆料内容
        message.setMessageType("tttt");
        message.setQq("18699344@qq.com");
        message.setPhone("181998333");
        message.setUsername("test1");
        boolean count = messageService.addMessage(message);
        logger.info("count={}",count);
    }

    @Test
    public void getAllMessage() {
        List<Message> list = messageService.getAllMessage();
        logger.info("list={}",list);
        
    }

    @Test
    public void getMessageNumber() {
        int count = messageService.getMessageNumber();
        logger.info("count={}",count);
    }

    @Test
    public void getWaitDealNumber() {
        int count = messageService.getWaitDealNumber();
        logger.info("count={}",count);
    }

    @Test
    public void isDealNumber() {
        int count = messageService.isDealNumber();
        logger.info("count={}",count);
    }

    @Test
    public void modifyMessage() {
        Message message = messageService.modifyMessage(6,"answer","image/teat2.jpg","user1");
        logger.info("message={}",message);
    }

    @Test
    public void deleteMessage() {
        messageService.deleteMessage(5);
    }
    @Test
    public void getMessageById(){
        Message message = messageService.getMessgeById(2);
        logger.info("message={}",message);
    }
    @Test
    public void getWaitingMessage(){
        List<Message> list = messageService.getWaitingMessage();
        logger.info("list={}",list);
    }
    @Test
    public void getDealtgMessage(){
        List<Message> list = messageService.getDealtMessage();
        logger.info("list={}",list);
    }
}