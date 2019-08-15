package com.you.yiban.service;

import com.mchange.util.MEnumeration;
import com.you.yiban.entity.Message;

import java.util.Date;
import java.util.List;

public interface MessageService {

    /**
     * 用户查看自己提供的报料
     * @param username
     * @return
     */
    public List<Message> getListByUsername(String username);

    /**
     * 发布报料
     * @param message
     * @return
     */
    public boolean addMessage(Message message);

    /**
     * 获取所有的报料信息列表
     * @return
     */
    public List<Message> getAllMessage();

    /**
     * 获取报料总数
     * @return
     */
    public Integer getMessageNumber();

    /**
     * 获取未处理的报料数量
     * @return
     */
    public Integer getWaitDealNumber();

    /**
     * 获取已经处理报料的数量
     * @return
     */
    public Integer isDealNumber();

    /**
     * 获取等待处理的报料信息
     * @return
     */
    public List<Message> getWaitingMessage();

    /**
     * 获取已经被官方回复了的报料信息
     * @return
     */
    public List<Message> getDealtMessage();
    
    /**
     * 管理员回复报料信息
     * @param id
     * @param messageAnswer
     * @param answerImage
     * @param answerUsername
     * @return
     */
    public Message modifyMessage(int id,
            String messageAnswer, String answerImage, String answerUsername);


    /**
     * 删除报料
     * @param messageId
     * @return
     */
    public boolean deleteMessage(Integer messageId);
    
    /**
     * 根据报料id查出具体的报料
     * @param messageId
     * @return
     */
    public Message getMessgeById(int messageId);

    /**
     * 根据报料部门返回报料信息
     */
    public List<Message> getMessageByType(String messageType);

    /**
     * 增加点赞数量
     * @param messageId
     * @return
     */
    public int updatePraiseCount(String messageId);
}
