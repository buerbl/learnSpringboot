
>show me the code and talk to me,做的出来更要说的明白  
>我是布尔bl，你的支持是我分享的动力！

## 1 引入

数据库达到瓶颈，有什么解决方法。 Redis 可以很好解决这个问题。那让我们来学习如何在 SpringBoot 使用 Redis。
## 2 确保 redis 开启
安装步骤省略。。。具体可以参考网上教程。
### 2.1 测试
```java
 telnet IP地址 端口（默认6379）
```
### 2.2 开启方法

如果上面方法没有返回，需要手动开启

1. 找到 redis.conf 文件，配置允许访问的ip
```java
find / -name redis.conf
```

2. 打开 redis.conf 

```java
找到 bind 127.0.0.1
改为 #bind 127.0.0.1

找到 protected-mode yes 
改为 protected-mode no(redis3.2版本以后)

找到daemonize yes
改为 daemonize no
```


3.保存退出 

```java
:wq
```

4 . 设置本地防火墙

如果有防火墙： iptables（Linux上常用的防火墙软件）

```java
iptables -I INPUT 4 -p tcp -m state --state NEW -m tcp --dport  6379 -j ACCEPT

service iptables save #保存iptables规则
```
5 . 阿里云云主机

如果redis放在了阿里云，需要添加安全组规则，自行百度
 
6. 最后测试

```java
 telnet IP地址 端口（默认6379）
```

成功得到返回

## 3 redis 作用

我们知道 redis 可以辅助 mysql，那我们应该怎样使用这个辅助呢？我这里说的是常见的情况。当我们的数据库达到瓶颈了，这个是前提。同时是读多于写的情况，我们就可以使用 redis 了。

如今前后端交互通过 JSON 交流。基于这点，我们一般把数据转成 json ，然后再转成字符的数据格式存在 redis 里面。这里 json 是不能直接存在 redis 里面的。 因为 redis 没有 json 的数据结构。 

当我们取出数据的时候，数据是一堆 json 的字符串，因此我们需要将数据转成对象，然后通 过springboot 转成 json 。

## 4 redis常用命令

redis 有五种数据结构

- String 字符串
- List 集合
- Set 集合
- Hash 集合
- SortedSet 集合

常见的 String 字符串使用(增查改删)
```java
set a 'a' 
get a
set a 'b'
del a
```

4 搭建环境

### 4.1 项目结构

```java
├─java
│  └─com
│      └─example
│          └─lsbredistest
│              └─controller
│                  └─entity
└─resources
    ├─static
    └─templates
```
### 4.2 application.yml
首先我们需要配置 redis 连接的用户名密码
```java
### redis 缓存配置
spring:
  redis:
    database: 0
    host: ip
    port: 6379
    password: 123456
```

### 4.3 RedisController
核心代码

```java
@RestController
@RequestMapping("/lsbredis")
public class RedisController {

    @Resource
    private StringRedisTemplate stringRedisTemplate;

    @RequestMapping("/test")
    public void test(){

        // key : a value: a
        // 增
        stringRedisTemplate.opsForValue().set("a","a");
        // 查
        String a = stringRedisTemplate.opsForValue().get("a");
        System.out.println("a的值:"+a);
        // 改
        stringRedisTemplate.opsForValue().set("a","b");

        // 缓存一个对象
        List<User> list = new ArrayList<>();
        list.add(new User(1l, "c1",1, "s1"));
        list.add(new User(2l, "c2",2, "s2"));
        list.add(new User(3l, "c3",3, "s3"));
        Gson gson = new Gson();
        String toJson = gson.toJson(list);
        stringRedisTemplate.opsForValue().set("user",toJson);
    }

}
```
###  注入配置
不知有没有发现我们没有配置 redis 的注入。究竟 redis 的如何自动注入的？通过查找代码，我们可以发现 redis 已经通过 Springboot 自己在内部设置了。  
```java
@Configuration(proxyBeanMethods = false)
@ConditionalOnClass(RedisOperations.class)
@EnableConfigurationProperties(RedisProperties.class)
@Import({ LettuceConnectionConfiguration.class, JedisConnectionConfiguration.class })
public class RedisAutoConfiguration {

	@Bean
	@ConditionalOnMissingBean(name = "redisTemplate")
	public RedisTemplate<Object, Object> redisTemplate(RedisConnectionFactory redisConnectionFactory)
			throws UnknownHostException {
		RedisTemplate<Object, Object> template = new RedisTemplate<>();
		template.setConnectionFactory(redisConnectionFactory);
		return template;
	}

	@Bean
	@ConditionalOnMissingBean
	public StringRedisTemplate stringRedisTemplate(RedisConnectionFactory redisConnectionFactory)
			throws UnknownHostException {
		StringRedisTemplate template = new StringRedisTemplate();
		template.setConnectionFactory(redisConnectionFactory);
		return template;
	}

}
```
上面的代码就是 Redis 的注入配置。省去了我们再去编写代码。赞！

## 5 源码

https://github.com/buerbl/learnSpringboot/tree/master/lsb-redistest

## 6 深入一层

redis 缓存可以减轻数据库压力，有什么方法可以减轻 redis 压力呢？

答案是当然有。我们可以使用 Guava做本地缓存，减轻 redis 压力，同时加快反问速度。

当然加本地缓存也情况。单机环境下，加本地缓存比较简单，但是分布式环境下，加本地缓存，当我们的缓存更新的时候，我们需要额外处理其他机器的本地缓存，不然数据就一致了。我们利用 redis的pub/sub 机制，对其他机器的本地缓存进行删除。