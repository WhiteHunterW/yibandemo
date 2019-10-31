package com.you.yiban.entity;


public class Message {
    /**
     * 发布用户的用户名
     */
    private String username;
    /**
     * 报料id
     */
    private int messageId;

    /**
     * 报料对应部门
     */
    private String messageType;

    /**
     * 报料内容
     */
    private String message;

    /**
     * 报料人qq
     */
    private String qq;

    /**
     * 报料人电话
     */
    private String phone;

    /**
     * 报料官方回复
     */
    private String messageAnswer;

    /**
     * 报料回复状态
     */
    private Integer messageState;

    /**
     * 报料创建时间
     */
    private String createTime;

    /**
     * 回复人头像
     */
    private String answerImage;

    /**
     * 回复人用户名
     */
    private String answerUsername;

    /**
     * 创建报料用户的头像
     */
    private String userImage;

    /**
     * 点赞数量
     */
    private int praiseCount;

    public String getUserImage() {
        return userImage;
    }

    public void setUserImage(String userImage) {
        this.userImage = userImage;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getMessageId() {
        return messageId;
    }

    public void setMessageId(int messageId) {
        this.messageId = messageId;
    }

    public String getAnswerImage() {
        return answerImage;
    }

    public String getMessageType() {
        return messageType;
    }

    public void setMessageType(String messageType) {
        this.messageType = messageType;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getQq() {
        return qq;
    }

    public void setQq(String qq) {
        this.qq = qq;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getMessageAnswer() {
        return messageAnswer;
    }

    public void setMessageAnswer(String messageAnswer) {
        this.messageAnswer = messageAnswer;
    }

    public Integer getMessageState() {
        return messageState;
    }

    public void setMessageState(Integer messageState) {
        this.messageState = messageState;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public void setAnswerImage(String answerImage) {
        this.answerImage = answerImage;
    }

    public String getAnswerUsername() {
        return answerUsername;
    }

    public void setAnswerUsername(String answerUsername) {
        this.answerUsername = answerUsername;
    }

    public int getPraiseCount() {
        return praiseCount;
    }

    public void setPraiseCount(int praiseCount) {
        this.praiseCount = praiseCount;
    }

    @Override
    public String toString() {
        return "Message{" +
                "username='" + username + '\'' +
                ", messageId=" + messageId +
                ", messageType='" + messageType + '\'' +
                ", message='" + message + '\'' +
                ", qq='" + qq + '\'' +
                ", phone='" + phone + '\'' +
                ", messageAnswer='" + messageAnswer + '\'' +
                ", messageState=" + messageState +
                ", createTime='" + createTime + '\'' +
                ", answerImage='" + answerImage + '\'' +
                ", answerUsername='" + answerUsername + '\'' +
                ", userImage='" + userImage + '\'' +
                ", praiseCount=" + praiseCount +
                '}';
    }
}
