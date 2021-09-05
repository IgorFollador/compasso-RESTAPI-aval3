package br.com.compasso.RestAPI.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import br.com.compasso.RestAPI.entity.Regiao;
import br.com.compasso.RestAPI.entity.State;

public interface StateRepository extends JpaRepository<State, Long>{
	Page<State> findByRegiao(Pageable paginacao, Regiao regiao);
}
