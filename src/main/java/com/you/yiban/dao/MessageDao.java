package com.you.yiban.dao;

import com.you.yiban.entity.Message;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface MessageDao {

    /**
     * 创建报料
     * @param
     * @return
     */
    Integer insertMessage(Message message);

    /**
     * 根据用户名查询该用户所有报料
     * @param username
     * @return
     */
    List<Message> queryListMessageByUsername(String username);


    /**
     * 获得所有的报料信息
     * @return
     */
    List<Message> getAllMessage();


    /**
     * 获得已处理的报料信息
     * @param
     * @return
     */
    List<Message> getMessageWithAnswer();

    /**
     * 获得未处理的报料信息
     * @return
     */
    List<Message> getWaitDeal();

    /**
     * 根据报料部门查询对应部门的报料信息
     * @param messageType
     * @return
     */
    List<Message> getMesgByType(String messageType);

    /**
     * 官方处理报料,设置回复
     * @param 
     * @return
     */
    int dealMessage(@Param("messageId") int messageId,
                    @Param("messageAnswer") String messageAnswer,
                    @Param("answerImage") String answerImage,
                    @Param("answerUsername") String answerUsername);

    /**
     * 根据id删除报料信息
     * @param messageId
     * @return
     */
    boolean delete(Integer messageId);

    /**
     * 根据id查询每条报料
     * @param messageId
     * @return
     */
    Message getByMessageId(int messageId);

    /**
     * 增加点赞数量
     * @param messageId
     * @return
     */
    int updatePraiseCount(String messageId);
    
}

  
