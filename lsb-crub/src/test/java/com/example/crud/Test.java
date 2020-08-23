package com.example.crud;

import org.springframework.util.StopWatch;

/**
 * @Author buerbl
 * @create 2020/8/20 15:03
 */
public class Test {
	public static void main(String[] args) throws InterruptedException {
		StopWatch sw = new StopWatch();
		sw.start("读取文件");
		Thread.sleep(1000);
		sw.stop();
		sw.start("文件删除");
		Thread.sleep(2000);
		sw.stop();
		sw.start("文件拷贝");
		Thread.sleep(3000);
		sw.stop();
		System.out.println(sw.prettyPrint());

	}
}
