package br.com.compasso.RestAPI.dto;

import br.com.compasso.RestAPI.entity.Regiao;
import br.com.compasso.RestAPI.entity.State;
import lombok.Data;

@Data
public class StateDTO {
	
	public StateDTO() {
	}

	public StateDTO(State state) {
		this.id = state.getId();
		this.nome = state.getNome();
		this.regiao = state.getRegiao();
		this.populacao = state.getPopulacao();
		this.capital = state.getCapital();
		this.area = state.getArea();
	}
	
	private Long id;
	
	private String nome;
	
	private Regiao regiao;
	
	private Integer populacao;

	private String capital;
	
	private Double area;
	
}
