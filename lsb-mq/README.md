# SpringBoot基础架构篇4（SpringBoot与 RabbitMQ）

## 应用场景

- 异步（下单后返回排队，减少数据库压力）

- 延迟消费（订单过期）
RabbitMQ 不支持定时消费
  
## rockertmq(docker)

### 状态检查

```java
docker ps -a
```
### 启动Namestr

```java
docker run -d -p 9876:9876 -v /tmp/data/rocketmq/namesrv/logs:/root/rocketmq-all-4.6.0-bin-release/log -v /tmp/data/rocketmq/namesrv/store:/root/rocketmq-all-4.6.0-bin-release/data --name rmqnamesrv -e "MAX_POSSIBLE_HEAP=100000000" rocketmqinc/rocketmq sh mqnamesrv
```
### 启动Broker

```java
docker run -d -p 10911:10911 -p 10909:10909 -v  /tmp/data/rocketmq/broker/logs:/root/rocketmq-all-4.6.0-bin-release/log -v  /tmp/data/rocketmq/broker/store:/root/rocketmq-all-4.6.0-bin-release/data -v  /tmp/etc/rocketmq/broker/broker.conf:/root/rocketmq-all-4.6.0-bin-release/conf/broker.conf --name rmqbroker --link rmqnamesrv:namesrv -e "NAMESRV_ADDR=namesrv:9876" -e "MAX_POSSIBLE_HEAP=200000000" rocketmqinc/rocketmq sh mqbroker -c /opt/rocketmq/conf/broker.conf
```

### 杀死进程

```java
lsof -i:10909
kill -9 10909
```
### 启动项目

![](https://bu.dusays.com/2022/03/27/47925f49cf46e.png)