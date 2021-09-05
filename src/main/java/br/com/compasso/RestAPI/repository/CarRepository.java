package br.com.compasso.RestAPI.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.compasso.RestAPI.entity.Car;

public interface CarRepository extends JpaRepository<Car, Long>{
	
}
