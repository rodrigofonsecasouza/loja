package br.com.alura.microservice.loja.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.alura.microservice.loja.dto.CompraDTO;
import br.com.alura.microservice.loja.dto.TestKafkaDTO;
import br.com.alura.microservice.loja.model.Compra;
import br.com.alura.microservice.loja.service.CompraService;
import br.com.alura.microservice.loja.service.KafkaDispatcher;

@RestController
@RequestMapping("/compra")
public class CompraController {

	@Autowired
	private CompraService compraService;

	@Autowired
	private KafkaDispatcher kafkaDispatcher;

	@Value("${cor}")
	private String cor;

	@PostMapping
	public Compra realizaCompra(@RequestBody CompraDTO compra) {
		return compraService.realizaCompra(compra);
	}

	@GetMapping("/{id}")
	public Compra getById(@PathVariable Long id) {
		return compraService.getById(id);
	}

	@PostMapping(value = "/kafka")
	public void realizaCompraKafka(@RequestBody TestKafkaDTO compra) {
		//kafkaDispatcher.send(compra);
	}

	@GetMapping(value = "/cor")
	public String getCor() {
		return cor;
	}
}
