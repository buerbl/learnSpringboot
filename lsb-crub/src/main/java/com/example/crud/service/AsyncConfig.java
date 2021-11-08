package com.example.crud.service;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.task.AsyncTaskExecutor;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

/**
 * @Author buerbl
 * @create 2020/9/10 14:22
 */
@Configuration
public class AsyncConfig {
	private static final int MAX_POOL_SIZE = 50;

	private static final int CORE_POOL_SIZE = 20;

	@Bean("asyncTaskExecutor")
	public AsyncTaskExecutor asyncTaskExecutor() {
		ThreadPoolTaskExecutor asyncTaskExecutor = new ThreadPoolTaskExecutor();
		asyncTaskExecutor.setMaxPoolSize(MAX_POOL_SIZE);
		asyncTaskExecutor.setCorePoolSize(CORE_POOL_SIZE);
		asyncTaskExecutor.setThreadNamePrefix("task1-thread-");
		asyncTaskExecutor.initialize();
		return asyncTaskExecutor;
	}
}
