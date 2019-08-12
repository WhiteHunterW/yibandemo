package com.you.yiban.service.impl;

import com.you.yiban.dao.MessageDao;
import com.you.yiban.entity.Message;
import com.you.yiban.service.MessageService;
import org.omg.PortableInterceptor.INACTIVE;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

// 添加注解service
@Service
public class MessageServiceImpl implements MessageService {

    @Autowired
    private MessageDao messageDao;
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    
    @Override
    public List<Message> getListByUsername(String username){
        // 根据用户名查询用户自己的报料
        return messageDao.queryListMessageByUsername(username);
    }

    @Override
    public List<Message> getWaitingMessage() {
        // 查询等待处理的报料
        return messageDao.getWaitDeal();
    }
    
    @Override
    @Transactional
    public List<Message> getDealtMessage() {
        // 查询已经被处理的报料
        return messageDao.getMessageWithAnswer();
    }
    
    public Message getMessgeById(int messageId){
        // 根据报料id查出具体的报料
        return messageDao.getByMessageId(messageId);
    }

    @Override
    public List<Message> getAllMessage(){
        // 查询所有的报料
        return messageDao.getAllMessage();
    }
    
    @Override
    @Transactional
    public boolean addMessage(Message message){
        // 增加报料
        final boolean exist = message.getMessageType() != null && message.getMessage() != null
                && message.getQq() != null && message.getPhone() !=null;
        if (exist){
            message.setCreateTime(new Date());
            try {
                Integer effectNum = messageDao.insertMessage(message);
                if (effectNum > 0) {
                    return true;
                }else {
                    logger.info("发布报料失败");
                    return false;
                }
            } catch (Exception e){
                logger.info("发布报料失败"+e.toString());
                return false;
            }

        } else {
            logger.info("请完善报料信息");
            return false;
        }
    }

    
    @Override
    @Transactional
    public Integer getMessageNumber(){
        // 报料总数
        Integer number;
        List<Message> list = messageDao.getAllMessage();
        number = list.size();
        return number;
    }

    @Override
    @Transactional
    public Integer getWaitDealNumber(){
        // 等待处理的报料数量
        Integer waitNumber;
        List<Message> list = messageDao.getWaitDeal();
        waitNumber = list.size();
        return waitNumber;
    }

    @Override
    @Transactional
    public Integer isDealNumber(){
        // 已经被处理的报料数量
        Integer all,waitNumber,isDealNumber;
        List<Message> list1 = messageDao.getAllMessage();
        List<Message> list2 = messageDao.getWaitDeal();
        all = list1.size();
        waitNumber = list2.size();
        isDealNumber = all - waitNumber;
        return isDealNumber;
    }
    
    @Override
    @Transactional
    public Message modifyMessage(int id,
            String messageAnswer,String answerImage,String answerUsername){
        final boolean exist = messageAnswer != null 
                && answerImage != null && answerUsername !=null;
        if (exist) {
            try {
                messageDao.dealMessage(id,messageAnswer,answerImage,answerUsername);
                Message message = messageDao.getByMessageId(id);
                return message;
            }catch (Exception e) {
                logger.info("回复失败"+toString());
                return null;
            }
        } else {
            logger.info("请输入回复内容");
            return null;
        }
    }
    
    @Override
    @Transactional
    public boolean deleteMessage(Integer messageId){
        Boolean flag;
        if(messageId != null){
            try {
               flag = messageDao.delete(messageId);
               return true;
            } catch (Exception e){
                logger.info("删除失败"+toString());
                return false;
            }
        } else {
            logger.info("信息缺失删除失败");
            return  false;
        }
    }

   

}
