#用户
#### 一 用户登录

##### * 请求方式：GET

##### * 请求url:
`/yiban/user/login`
##### * 参数：
```java
username[String]:用户名，必填
password[String]:登录密码，必填
```
##### * 返回值


    "code": 1,
    "msg": "请求成功",
    "data": {
            "username": "test1",
            "password": "12345",
            "userImage": "image/test1.jpg",
            "userType": 1,
            "userEducation": "benke"
        }
####  二 用户角色
#####  * 请求方式：GET
##### * URL:
`/yiban/user/userInformation`
##### * 参数：
```java
username[String]
```
##### * 返回值

    {
        "code": 1,
        "msg": "请求成功",
        "data": "管理员"
    }
# 报料模块
####  一 根据用户名查询该用户所有的报料信息
##### * 请求方式：GET
##### * URL:
`/yiban/message/getUserMessage`
##### * 参数：
```java
username[String]
```
##### * 返回值


     "code": 1,
        "msg": "请求成功",
        "data": [
            {
                "username": null,
                "messageId": 0,
                "messageType": "保卫处",
                "message": "content",
                "qq": null,
                "phone": null,
                "messageAnswer": "ttttt",
                "messageState": 1,
                "createTime": "2019-08-12T09:55:58.000+0000",
                "answerImage": "",
                "answerUsername": null
            }
        ]
#### 二 添加报料
##### * 请求方式：POST
##### * URL:
`/yiban/message/addMessage`
##### * 参数：
```java
username[String]:已经登录用户的用户名
messageType[String]：报料部门
qq[String]:qq
phone[String]:电话
content[String]：报料内容
```
##### * 返回值


     "code": 1,
        "msg": "请求成功",
        "data": {
            "username": "test2",
            "messageId": 0,
            "messageType": "学生会",
            "message": "我要报料",
            "qq": "88883@qq.com",
            "phone": "1893483257",
            "messageAnswer": null,
            "messageState": null,
            "createTime": "2019-08-13T02:07:34.316+0000",
            "answerImage": null,
            "answerUsername": null
        }
#### 三 获取所有的报料
##### * 请求方式：GET
##### * URL:
`/yiban/message/getAllMessage`
##### * 参数：
无
##### * 返回值


    "code": 1,
        "msg": "请求成功",
        "data": [
            {
                "username": "test1",
                "messageId": 1,
                "messageType": "保卫处",
                "message": "content",
                "qq": null,
                "phone": null,
                "messageAnswer": "ttttt",
                "messageState": null,
                "createTime": "2019-08-12T09:55:58.000+0000",
                "answerImage": null,
                "answerUsername": null
            },
            {
                "username": "test2",
                "messageId": 2,
                "messageType": "xxxxx",
                "message": "baoliao",
                "qq": null,
                "phone": null,
                "messageAnswer": "回复",
                "messageState": null,
                "createTime": "2019-08-12T02:44:32.000+0000",
                "answerImage": null,
                "answerUsername": null
            },
            {
                "username": "test2",
                "messageId": 6,
                "messageType": "后勤处",
                "message": "内容",
                "qq": null,
                "phone": null,
                "messageAnswer": "同意",
                "messageState": null,
                "createTime": "2019-08-07T17:44:07.000+0000",
                "answerImage": null,
                "answerUsername": null
            },
            {
                "username": "test2",
                "messageId": 8,
                "messageType": "学生会",
                "message": "我要报料",
                "qq": null,
                "phone": null,
                "messageAnswer": "",
                "messageState": null,
                "createTime": "2019-08-13T02:07:34.000+0000",
                "answerImage": null,
                "answerUsername": null
            }
        ]
#### 四 获取等待处理的报料信息
##### * 请求方式：GET
##### * URL:
`/yiban/message/getWaitingMessage`
##### * 参数：
无
##### * 返回值


     "code": 1,
        "msg": "请求成功",
        "data": [
            {
                "username": "test2",
                "messageId": 0,
                "messageType": "学生会",
                "message": "我要报料",
                "qq": null,
                "phone": null,
                "messageAnswer": null,
                "messageState": null,
                "createTime": "2019-08-13T02:07:34.000+0000",
                "answerImage": null,
                "answerUsername": null
            }
        ]
五 获取已经处理的报料信息
##### * 请求方式：GET
##### * URL:
`/yiban/message/getDealMessage`
##### * 参数：
无
##### * 返回值


     "code": 1,
        "msg": "请求成功",
        "data": [
            {
                "username": "test1",
                "messageId": 0,
                "messageType": "保卫处",
                "message": "content",
                "qq": null,
                "phone": null,
                "messageAnswer": null,
                "messageState": null,
                "createTime": "2019-08-12T09:55:58.000+0000",
                "answerImage": null,
                "answerUsername": null
            },
            {
                "username": "test2",
                "messageId": 0,
                "messageType": "xxxxx",
                "message": "baoliao",
                "qq": null,
                "phone": null,
                "messageAnswer": null,
                "messageState": null,
                "createTime": "2019-08-12T02:44:32.000+0000",
                "answerImage": null,
                "answerUsername": null
            },
            {
                "username": "test2",
                "messageId": 0,
                "messageType": "后勤处",
                "message": "内容",
                "qq": null,
                "phone": null,
                "messageAnswer": null,
                "messageState": null,
                "createTime": "2019-08-07T17:44:07.000+0000",
                "answerImage": null,
                "answerUsername": null
            }
        ]
#### 六 获取报料总数
##### * 请求方式：GET
##### * URL:
`/yiban/message/getAllCount`
##### * 参数：
无
##### * 返回值


    {
        "code": 1,
        "msg": "请求成功",
        "data": 4
    }
#### 七 获取等待处理的报料条数
##### * 请求方式：GET
##### * URL:
`/yiban/message/WaitMessageNumber`
##### * 参数：
无
##### * 返回值


    {
        "code": 1,
        "msg": "请求成功",
        "data": 1
    }
八 获取已经被处理的报料条数
##### * 请求方式：GET
##### * URL:
`/yiban/message/dealtMessageNumber`
##### * 参数：
无
##### * 返回值


    {
        "code": 1,
        "msg": "请求成功",
        "data": 3
    }
#### 九 更新报料
##### * 请求方式：PUT
##### * URL:
`/yiban/message/update`
##### * 参数：
```java
messageId[int]:报料id，要获取该条报料的id
messageAnswer[String]:回复内容
answerImage[String]:回复人的头像
answerUsername[String]:回复人的用户名
```
##### * 返回值


    "code": 1,
    "msg": "请求成功",
    "data": {
        "username": "test2",
        "messageId": 8,
        "messageType": "学生会",
        "message": "我要报料",
        "qq": "88883@qq.com",
        "phone": "1893483257",
        "messageAnswer": "xsfdsafsf",
        "messageState": 1,
        "createTime": "2019-08-13T02:07:34.000+0000",
        "answerImage": "image/test1.jpg",
        "answerUsername": "user3"
    }
    
#### 十 删除报料
##### * 请求方式：DELETE
##### * URL:
`/yiban/message/delete`
##### * 参数：
```java
messageId[int]:要获取该条报料的id传入
```
##### * 返回值


    {
            "code": 1,
            "msg": "请求成功",
            "data": null
        }