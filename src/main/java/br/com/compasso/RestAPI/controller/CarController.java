package br.com.compasso.RestAPI.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.compasso.RestAPI.dto.CarDTO;
import br.com.compasso.RestAPI.service.CarService;

@RestController
public class CarController {
	
	@Autowired CarService carService;
	
	@PostMapping("/api/cars/")
	public ResponseEntity<Void> createCar(@RequestBody CarDTO car) {
		carService.createCar(car);
		return ResponseEntity.created(null).build();
	}
	
	@GetMapping("/api/cars/")
	public ResponseEntity<List<CarDTO>> listAll(){
		return ResponseEntity.ok(carService.listAll());
	}
	
}
