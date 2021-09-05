package br.com.compasso.RestAPI.controller.form;

import java.math.BigDecimal;

import lombok.Data;

@Data
public class CarForm {
	
	private String chassi;
	private String nome;
	private String marca;
	private String cor;
	private BigDecimal valor;
	private Integer anoFabricacao;
	
}
