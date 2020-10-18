package br.com.alura.microservice.loja.service;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;

import br.com.alura.microservice.loja.dto.TestKafkaDTO;
import lombok.extern.slf4j.Slf4j;

@Aspect
@Component
@EnableAspectJAutoProxy
@Slf4j
public class SpringAspect {

	@Before("execution(* br.com.alura.microservice.loja.controller.CompraController.getCor())")
	public void audit() {
		log.info("execution getCor");
		// log.info(bean.toString());
	}

	@Before("execution(* br.com.alura.microservice.loja.controller.CompraController.realizaCompraKafka(..)) && args(compra,..)")
	public void beforeCompra(TestKafkaDTO compra) {
		log.info("execution compraKafka");
		log.info("Consumer:" + compra.getConsumer());
		// log.info(bean.toString());
	}
}
