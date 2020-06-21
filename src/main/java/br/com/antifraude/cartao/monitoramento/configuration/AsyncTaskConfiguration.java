package br.com.antifraude.cartao.monitoramento.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.task.TaskExecutor;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

@Configuration
public class AsyncTaskConfiguration {
	
	private static final int CORE_POOL_SIZE = 20;
	private static final int MAX_POOL_SIZE = 1000;

	@Bean("threadPoolTaskExecutor")
	public TaskExecutor asyncExecutor() {
		ThreadPoolTaskExecutor exec = new ThreadPoolTaskExecutor();
		exec.setCorePoolSize(CORE_POOL_SIZE);
		exec.setMaxPoolSize(MAX_POOL_SIZE);
		exec.setWaitForTasksToCompleteOnShutdown(Boolean.TRUE);
		exec.setThreadNamePrefix("ASYNC-SEND-SMS - ");
		return exec;
	}
}
