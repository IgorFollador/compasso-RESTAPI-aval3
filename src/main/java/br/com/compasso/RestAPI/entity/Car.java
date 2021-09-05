package br.com.compasso.RestAPI.entity;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class Car implements Serializable{
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(unique=true)
	private String chassi;
	
	private String nome;
	
	private String marca;
	
	private String cor;
	
	private BigDecimal valor;
	
	private Integer anoFabricacao;
}
