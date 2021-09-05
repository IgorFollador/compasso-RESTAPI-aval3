package br.com.compasso.RestAPI.controller.form;

import br.com.compasso.RestAPI.entity.Regiao;
import lombok.Data;

@Data
public class StateForm {
	
	private String nome;
	private Regiao regiao;
	private Integer populacao;
	private String capital;
	private Double area;
	
}
