package br.com.alura.microservice.loja.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TestKafkaDTO {

	private Long identifier;
	private String consumer;
	private double value;
}
