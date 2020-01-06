## 引入

用 SpringBoot （2.1.10.RELEASE） 写出第一行代码

##  核心代码

```java
@SpringBootApplication
@RestController
public class Demo2Application {

	public static void main(String[] args) {
		SpringApplication.run(Demo2Application.class, args);
	}

	@RequestMapping
	public String test(){
		return "hello,springboot2!";
	}
}
```

##  输出
输出  hello, springboot2!
