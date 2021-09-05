package br.com.compasso.RestAPI.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.compasso.RestAPI.dto.StateDTO;
import br.com.compasso.RestAPI.service.StateService;

@RestController
public class StatesController {
	
	@Autowired StateService stateService;
	
	@PostMapping("/api/states/")
	public ResponseEntity<Void> createState(@RequestBody StateDTO state) {
		stateService.save(state);
		return ResponseEntity.created(null).build();
	}
	
	@GetMapping("/api/states/")
	public ResponseEntity<List<StateDTO>> listAll(){
		return ResponseEntity.ok(stateService.findAll());
	}
}
