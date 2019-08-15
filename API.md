#�û�
#### һ �û���¼

##### * ����ʽ��GET

##### * ����url:
`/yiban/user/login`
##### * ������
```java
username[String]:�û���������
password[String]:��¼���룬����
```
##### * ����ֵ


    "code": 1,
    "msg": "����ɹ�",
    "data": {
            "username": "test1",
            "password": "12345",
            "userImage": "image/test1.jpg",
            "userType": 1,
            "userEducation": "benke"
        }
####  �� �û���ɫ
#####  * ����ʽ��GET
##### * URL:
`/yiban/user/userInformation`
##### * ������
```java
username[String]
```
##### * ����ֵ

    {
        "code": 1,
        "msg": "����ɹ�",
        "data": "����Ա"
    }
# ����ģ��
####  һ �����û�����ѯ���û����еı�����Ϣ
##### * ����ʽ��GET
##### * URL:
`/yiban/message/getUserMessage`
##### * ������
```java
username[String]
```
##### * ����ֵ


     "code": 1,
        "msg": "����ɹ�",
        "data": [
            {
                "username": null,
                "messageId": 0,
                "messageType": "������",
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
#### �� ��ӱ���
##### * ����ʽ��POST
##### * URL:
`/yiban/message/addMessage`
##### * ������
```java
username[String]:�Ѿ���¼�û����û���
messageType[String]�����ϲ���
qq[String]:qq
phone[String]:�绰
content[String]����������
```
##### * ����ֵ


     "code": 1,
        "msg": "����ɹ�",
        "data": {
            "username": "test2",
            "messageId": 0,
            "messageType": "ѧ����",
            "message": "��Ҫ����",
            "qq": "88883@qq.com",
            "phone": "1893483257",
            "messageAnswer": null,
            "messageState": null,
            "createTime": "2019-08-13T02:07:34.316+0000",
            "answerImage": null,
            "answerUsername": null
        }
#### �� ��ȡ���еı���
##### * ����ʽ��GET
##### * URL:
`/yiban/message/getAllMessage`
##### * ������
��
##### * ����ֵ


    "code": 1,
        "msg": "����ɹ�",
        "data": [
            {
                "username": "test1",
                "messageId": 1,
                "messageType": "������",
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
                "messageAnswer": "�ظ�",
                "messageState": null,
                "createTime": "2019-08-12T02:44:32.000+0000",
                "answerImage": null,
                "answerUsername": null
            },
            {
                "username": "test2",
                "messageId": 6,
                "messageType": "���ڴ�",
                "message": "����",
                "qq": null,
                "phone": null,
                "messageAnswer": "ͬ��",
                "messageState": null,
                "createTime": "2019-08-07T17:44:07.000+0000",
                "answerImage": null,
                "answerUsername": null
            },
            {
                "username": "test2",
                "messageId": 8,
                "messageType": "ѧ����",
                "message": "��Ҫ����",
                "qq": null,
                "phone": null,
                "messageAnswer": "",
                "messageState": null,
                "createTime": "2019-08-13T02:07:34.000+0000",
                "answerImage": null,
                "answerUsername": null
            }
        ]
#### �� ��ȡ�ȴ�����ı�����Ϣ
##### * ����ʽ��GET
##### * URL:
`/yiban/message/getWaitingMessage`
##### * ������
��
##### * ����ֵ


     "code": 1,
        "msg": "����ɹ�",
        "data": [
            {
                "username": "test2",
                "messageId": 0,
                "messageType": "ѧ����",
                "message": "��Ҫ����",
                "qq": null,
                "phone": null,
                "messageAnswer": null,
                "messageState": null,
                "createTime": "2019-08-13T02:07:34.000+0000",
                "answerImage": null,
                "answerUsername": null
            }
        ]
�� ��ȡ�Ѿ�����ı�����Ϣ
##### * ����ʽ��GET
##### * URL:
`/yiban/message/getDealMessage`
##### * ������
��
##### * ����ֵ


     "code": 1,
        "msg": "����ɹ�",
        "data": [
            {
                "username": "test1",
                "messageId": 0,
                "messageType": "������",
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
                "messageType": "���ڴ�",
                "message": "����",
                "qq": null,
                "phone": null,
                "messageAnswer": null,
                "messageState": null,
                "createTime": "2019-08-07T17:44:07.000+0000",
                "answerImage": null,
                "answerUsername": null
            }
        ]
#### �� ��ȡ��������
##### * ����ʽ��GET
##### * URL:
`/yiban/message/getAllCount`
##### * ������
��
##### * ����ֵ


    {
        "code": 1,
        "msg": "����ɹ�",
        "data": 4
    }
#### �� ��ȡ�ȴ�����ı�������
##### * ����ʽ��GET
##### * URL:
`/yiban/message/WaitMessageNumber`
##### * ������
��
##### * ����ֵ


    {
        "code": 1,
        "msg": "����ɹ�",
        "data": 1
    }
�� ��ȡ�Ѿ�������ı�������
##### * ����ʽ��GET
##### * URL:
`/yiban/message/dealtMessageNumber`
##### * ������
��
##### * ����ֵ


    {
        "code": 1,
        "msg": "����ɹ�",
        "data": 3
    }
#### �� ���±���
##### * ����ʽ��PUT
##### * URL:
`/yiban/message/update`
##### * ������
```java
messageId[int]:����id��Ҫ��ȡ�������ϵ�id
messageAnswer[String]:�ظ�����
answerImage[String]:�ظ��˵�ͷ��
answerUsername[String]:�ظ��˵��û���
```
##### * ����ֵ


    "code": 1,
    "msg": "����ɹ�",
    "data": {
        "username": "test2",
        "messageId": 8,
        "messageType": "ѧ����",
        "message": "��Ҫ����",
        "qq": "88883@qq.com",
        "phone": "1893483257",
        "messageAnswer": "xsfdsafsf",
        "messageState": 1,
        "createTime": "2019-08-13T02:07:34.000+0000",
        "answerImage": "image/test1.jpg",
        "answerUsername": "user3"
    }
    
#### ʮ ɾ������
##### * ����ʽ��DELETE
##### * URL:
`/yiban/message/delete`
##### * ������
```java
messageId[int]:Ҫ��ȡ�������ϵ�id����
```
##### * ����ֵ


    {
            "code": 1,
            "msg": "����ɹ�",
            "data": null
        }