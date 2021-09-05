package br.com.compasso.RestAPI.dto;

import java.math.BigDecimal;

import lombok.Data;

@Data
public class CarDTO {
	
	private String chassi;
	
	private String nome;
	
	private String marca;
	
	private String cor;
	
	private BigDecimal valor;
	
	private Integer anoFabricacao;
	
}
