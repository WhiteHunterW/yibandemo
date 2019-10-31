package com.you.yiban.controller;

import com.you.yiban.entity.Message;
import com.you.yiban.service.MessageService;
import com.you.yiban.util.ResultUtil;
import com.you.yiban.vo.ResultVo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author w.z
 * @date 2019/8/12 15:50
 */
@CrossOrigin
@Controller
@RequestMapping("/message")
public class MessageController {

    @Resource
    private MessageService messageService;

    /**
     * 根据用户名查询该用户所有的报料,
     * 返回报料的创建时间,内容,状态,报料部门
     *
     * @param username
     * @return
     */
    @RequestMapping(value = "/getUserMessage", method = RequestMethod.GET)
    @ResponseBody
    public ResultVo getUerAllMessages(String username) {
        List<Message> list = messageService.getListByUsername(username);
        return ResultUtil.success(list);
    }

    /**
     * 增加报料
     * 报料类型,内容,联系方式(qq,电话)
     * 返回内容包括创建时间
     *
     * @param username
     * @param messageType
     * @param qq
     * @param phone
     * @param content
     * @return
     */
    @RequestMapping(value = "/addMessage", method = RequestMethod.POST)
    @ResponseBody
    public ResultVo addMessage(String username, String messageType, String qq, String phone, String content) {
        Message message = new Message();
        message.setUsername(username);
        message.setPhone(phone);
        message.setQq(qq);
        message.setMessage(content);
        message.setMessageType(messageType);
        boolean result = messageService.addMessage(message);
        if (result) {
            return ResultUtil.success(message);
        } else {
            return ResultUtil.error("添加报料失败");
        }
    }

    /**
     * 获取所有的报料
     * 返回的每条报料信息包括....
     *
     * @return
     */
    @RequestMapping(value = "/getAllMessage", method = RequestMethod.GET)
    @ResponseBody
    public ResultVo getAllMessage() {

        List<Message> list = messageService.getAllMessage();
        return ResultUtil.success(list);
    }

    /**
     * 获取等待处理的报料信息显示
     *
     * @return
     */
    @RequestMapping(value = "/getWaitingMessage", method = RequestMethod.GET)
    @ResponseBody
    public ResultVo getWaitingMessages() {
        List<Message> list = messageService.getWaitingMessage();
        return ResultUtil.success(list);
    }

    /**
     * 获取已经被处理了的报料信息显示
     *
     * @return
     */
    @RequestMapping(value = "/getDealMessage", method = RequestMethod.GET)
    @ResponseBody
    public ResultVo getDealtMessages() {
        List<Message> list = messageService.getDealtMessage();
        return ResultUtil.success(list);
    }

    /**
     * 根据报料部门返回报料信息
     *
     * @param messageType
     * @return
     */
    @RequestMapping(value = "/getmsgbytype", method = RequestMethod.GET)
    @ResponseBody
    public ResultVo getMessageByType(String messageType) {
        List<Message> list = messageService.getMessageByType(messageType);
        return ResultUtil.success(list);
    }

    /**
     * 获取所有的报料条数
     *
     * @return
     */
    @RequestMapping(value = "/getAllCount", method = RequestMethod.GET)
    @ResponseBody
    public ResultVo getAllCount() {
        int messageCount = messageService.getMessageNumber();
        return ResultUtil.success(messageCount);
    }

    /**
     * 获取待处理的报料数量
     *
     * @return
     */
    @RequestMapping(value = "/WaitMessageNumber", method = RequestMethod.GET)
    @ResponseBody
    public ResultVo getWaitingNumber() {
        int waitingNumber = messageService.getWaitDealNumber();
        return ResultUtil.success(waitingNumber);
    }

    /**
     * 获取已处理的报料条数
     *
     * @return
     */
    @RequestMapping(value = "/dealtMessageNumber", method = RequestMethod.GET)
    @ResponseBody
    public ResultVo getDealtNumber() {
        int dealtNumber = messageService.isDealNumber();
        return ResultUtil.success(dealtNumber);
    }

    /**
     * 根据报料id查出报料信息,再进行修改
     *
     * @param messageId
     * @param messageAnswer
     * @param answerImage
     * @param answerUsername
     * @return
     */
    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    @ResponseBody
    public ResultVo updateMessage(int messageId, String messageAnswer, String answerImage, String answerUsername) {
        Message message = messageService.modifyMessage(messageId, messageAnswer, answerImage, answerUsername);
        return ResultUtil.success(message);
    }

    /**
     * 删除报料
     *
     * @param messageId
     * @return
     */
    @RequestMapping(value = "/delete", method = RequestMethod.DELETE)
    @ResponseBody
    public ResultVo deleteMessage(int messageId) {
        messageService.deleteMessage(messageId);
        return ResultUtil.success();
    }

    /**
     * 记录点赞数
     *
     * @param messageId
     * @return
     */
    @RequestMapping(value = "/addpraisecount", method = RequestMethod.PUT)
    @ResponseBody
    public ResultVo addPraiseCount(String messageId) {
        int result = messageService.updatePraiseCount(messageId);
        if (result > 0) {
            return ResultUtil.success();
        } else {
            return ResultUtil.error("更新点赞失败");
        }
    }
}
