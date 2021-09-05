package br.com.compasso.RestAPI.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import br.com.compasso.RestAPI.entity.Car;

public interface CarRepository extends JpaRepository<Car, Long>{
	Page<Car> findByMarca(Pageable paginacao, String marca);
	Page<Car> findByNome(Pageable paginacao, String nome);
	Page<Car> findByCor(Pageable paginacao, String cor);
}
