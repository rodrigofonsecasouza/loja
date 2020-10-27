package br.com.alura.microservice.loja.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.quartz.QuartzProperties;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;

import br.com.alura.microservice.loja.scheduler.SchedulerJobFactory;

@Configuration
public class QuartzConfiguration {

	@Autowired
	private DataSource dataSource;

	@Autowired
	private ApplicationContext applicationContext;

	@Autowired
	private QuartzProperties quartzProperties;

	/**
	 * create scheduler factory
	 */
	@Bean
	public SchedulerFactoryBean schedulerFactoryBean() {

		SchedulerJobFactory jobFactory = new SchedulerJobFactory();
		jobFactory.setApplicationContext(applicationContext);

		Properties properties = new Properties();
		properties.putAll(quartzProperties.getProperties());

		SchedulerFactoryBean factory = new SchedulerFactoryBean();
		factory.setOverwriteExistingJobs(true);
		factory.setDataSource(dataSource);
		factory.setQuartzProperties(properties);
		factory.setJobFactory(jobFactory);
		return factory;
	}

}
