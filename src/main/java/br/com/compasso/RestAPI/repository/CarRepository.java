package br.com.compasso.RestAPI.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.compasso.RestAPI.entity.Car;

public interface CarRepository extends JpaRepository<Car, Long>{
	List<Car> findByMarca(String marca);
	List<Car> findByNome(String nome);
	List<Car> findByCor(String cor);
}
