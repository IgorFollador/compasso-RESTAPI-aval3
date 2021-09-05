package br.com.compasso.RestAPI.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.compasso.RestAPI.entity.State;

public interface StateRepository extends JpaRepository<State, Long>{
	
}
