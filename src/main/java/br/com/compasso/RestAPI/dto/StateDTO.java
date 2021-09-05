package br.com.compasso.RestAPI.dto;

import br.com.compasso.RestAPI.entity.Regiao;
import lombok.Data;

@Data
public class StateDTO {
	
	private String nome;
	
	private Regiao regiao;
	
	private Integer populacao;

	private String capital;
	
	private Integer area;
	
}
