package br.com.alura.microservice.loja.service;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public class KafkaDispatcher<T> {

	@Value("${order.topic}")
	private String orderTopic;

	private final KafkaTemplate kafkaTemplate;

	public KafkaDispatcher(final KafkaTemplate kafkaTemplate) {
		this.kafkaTemplate = kafkaTemplate;
	}

	public void send(T objeto) {
		final String mensageKey = UUID.randomUUID().toString();
		kafkaTemplate.send(orderTopic, mensageKey, objeto);
	}
}
