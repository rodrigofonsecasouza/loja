package br.com.alura.microservice.loja.jobs;

import org.quartz.DisallowConcurrentExecution;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.scheduling.quartz.QuartzJobBean;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@DisallowConcurrentExecution
public class ScheduleB extends QuartzJobBean{@Override
	protected void executeInternal(JobExecutionContext context) throws JobExecutionException {
		// TODO Auto-generated method stub
	log.info("Entrou no job quartz sem cron");
	}

}
