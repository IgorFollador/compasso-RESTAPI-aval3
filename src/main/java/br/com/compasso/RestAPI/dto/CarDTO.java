package br.com.compasso.RestAPI.dto;

import java.math.BigDecimal;

import br.com.compasso.RestAPI.entity.Car;
import lombok.Data;

@Data
public class CarDTO {	
	
	public CarDTO() {
	}

	public CarDTO(Car car) {
		this.chassi = car.getChassi();
		this.nome = car.getNome();
		this.marca = car.getMarca();
		this.cor = car.getCor();
		this.valor = car.getValor();
		this.anoFabricacao = car.getAnoFabricacao();
	}

	private String chassi;
	
	private String nome;
	
	private String marca;
	
	private String cor;
	
	private BigDecimal valor;
	
	private Integer anoFabricacao;
	
}
