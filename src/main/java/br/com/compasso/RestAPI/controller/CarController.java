package br.com.compasso.RestAPI.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.compasso.RestAPI.controller.form.CarForm;
import br.com.compasso.RestAPI.dto.CarDTO;
import br.com.compasso.RestAPI.service.CarService;

@RestController
@RequestMapping("/api/cars")
public class CarController {
	
	@Autowired CarService carService;
	
	@PostMapping
	public ResponseEntity<CarDTO> create(@RequestBody CarForm form) {
		CarDTO carSaved = carService.save(form);
		return ResponseEntity.created(null).body(carSaved);
	}
	
	@GetMapping
	public ResponseEntity<Page<CarDTO>> list(@RequestParam(required = false) String marca,
			@RequestParam(required = false) String nome,
			@RequestParam(required = false) String cor,
			@PageableDefault(sort = "id", direction = Direction.ASC) Pageable paginacao){
		return ResponseEntity.ok(carService.find(paginacao, marca, nome, cor));
	}
	
}
