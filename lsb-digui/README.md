>喜欢就点个赞呗!  
>GitHub项目[JavaHouse](https://github.com/buerbl/JavaHouse)同步收录


### 引入  

当我看到一些评论时，例如下面的样子。我挺好奇这个功能是怎么样做出来的。进过查阅资料，发现这其实是 MySQL 的递归操作。下面就让我操作一下怎么实现 MySQL 的递归查询。

![](http://javahouse.xyz/20191215163035.png)


### 设计数据库

观察这种数据库设计，你会发现他都有一个父节点，一直到根节点，所以我们设计数据库的时候，应该设置一个 parentid 字段。所以，我们可以得到以下的数据库。

![](http://javahouse.xyz/20191215172843.png)

sql 脚本如下

```sql
CREATE TABLE digui(
	id INT(11) NOT null auto_increment,
	msg VARCHAR(255) not NULL COMMENT '评论的内容',
	parentid int(11) not null COMMENT '上一条',
	PRIMARY KEY(id)
)ENGINE=INNODB auto_increment = 100 DEFAULT CHARSET=utf8mb4;

INSERT into `digui`(msg, parentid) VALUES ('A', 0);
INSERT into `digui`(msg, parentid) VALUES('B', 1);
INSERT into `digui`(msg, parentid) VALUES('D', 3);
INSERT into `digui`(msg, parentid) VALUES('C', 2);
```


其实实现 MySQL 的递归查询方法有很多
1. 使用 MySQL 存储过程
2. 应用层代码递归
3. MyBatis 的 collection 标签


### 结果

```json
{
    "code": 200,
    "msg": "正确返回",
    "date": [
        {
            "id": 100,
            "msg": "A",
            "parentid": 0,
            "diguiList": [
                {
                    "id": 101,
                    "msg": "B",
                    "parentid": 100,
                    "diguiList": [
                        {
                            "id": 103,
                            "msg": "C",
                            "parentid": 101,
                            "diguiList": [
                                {
                                    "id": 102,
                                    "msg": "D",
                                    "parentid": 103,
                                    "diguiList": []
                                }
                            ]
                        }
                    ]
                }
            ]
        }
    ]
}
```

### 参考  
- https://blog.rxliuli.com/p/5830226b/
- https://juejin.im/entry/59be34fe5188257e8b36a303
- https://blog.csdn.net/u014079773/article/details/53338116



### 关注微信公众号，随时移动端阅读

![公众号.jpg](http://javahouse.xyz/20191212204326.png)



