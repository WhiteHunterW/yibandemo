package com.you.yiban.service.impl;

import com.you.yiban.dao.MessageDao;
import com.you.yiban.entity.Message;
import com.you.yiban.service.MessageService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class MessageServiceImpl implements MessageService {

    @Autowired
    private MessageDao messageDao;
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    /**
     * 根据用户名查询用户自己的报料
     * @param username
     * @return
     */
    @Override
    public List<Message> getListByUsername(String username){
        return messageDao.queryListMessageByUsername(username);
    }

    /**
     * 查询等待处理的报料
     * @return
     */
    @Override
    public List<Message> getWaitingMessage() {
        return messageDao.getWaitDeal();
    }

    /**
     * 查询已经被处理的报料
     * @return
     */
    @Override
    @Transactional
    public List<Message> getDealtMessage() {
        return messageDao.getMessageWithAnswer();
    }

    /**
     * 根据报料id查出具体的报料
     * @param messageId
     * @return
     */
    @Override
    public Message getMessgeById(int messageId){
        return messageDao.getByMessageId(messageId);
    }

    @Override
    public List<Message> getAllMessage(){
        // 查询所有的报料
        return messageDao.getAllMessage();
    }

    /**
     * 增加报料
     * @param message
     * @return
     */
    @Override
    @Transactional
    public boolean addMessage(Message message){
        final boolean exist = message.getMessageType() != null && message.getMessage() != null
                && message.getQq() != null && message.getPhone() !=null;
        if (exist){
           SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm");
           Date date = new Date();
           String format = dateFormat.format(date);
           message.setCreateTime(format);
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

    /**
     * 报料总数
     * @return
     */
    @Override
    @Transactional
    public Integer getMessageNumber(){
        Integer number;
        List<Message> list = messageDao.getAllMessage();
        number = list.size();
        return number;
    }

    /**
     * 等待处理的报料数量
     * @return
     */
    @Override
    @Transactional
    public Integer getWaitDealNumber(){
        Integer waitNumber;
        List<Message> list = messageDao.getWaitDeal();
        waitNumber = list.size();
        return waitNumber;
    }

    /**
     * 已经被处理的报料数量
     * @return
     */
    @Override
    @Transactional
    public Integer isDealNumber(){
        Integer all,waitNumber,isDealNumber;
        List<Message> list1 = messageDao.getAllMessage();
        List<Message> list2 = messageDao.getWaitDeal();
        all = list1.size();
        waitNumber = list2.size();
        isDealNumber = all - waitNumber;
        return isDealNumber;
    }

    /**
     * 修改报料信息
     * @param id
     * @param messageAnswer
     * @param answerImage
     * @param answerUsername
     * @return
     */
    @Override
    @Transactional
    public Message modifyMessage(int id,
            String messageAnswer,String answerImage,String answerUsername){
        final boolean exist = (messageAnswer != null) 
                && (answerImage != null) && (answerUsername !=null);
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

    /**
     * 删除报料
     * @param messageId
     * @return
     */
    @Override
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

    /**
     * 根据报料部门查出报料信息
     * @param messageType
     * @return
     */
    @Override
    public List<Message> getMessageByType(String messageType) {
        return  messageDao.getMesgByType(messageType);
    }

    /**
     * 增加点赞数量
     * @param messageId
     * @return
     */
    @Override
    public int updatePraiseCount(String messageId) {
        int result = messageDao.updatePraiseCount(messageId);
        return result;
    }
}
