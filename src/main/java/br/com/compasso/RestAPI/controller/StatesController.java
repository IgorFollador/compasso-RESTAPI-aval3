package br.com.compasso.RestAPI.controller;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.compasso.RestAPI.controller.form.StateForm;
import br.com.compasso.RestAPI.dto.StateDTO;
import br.com.compasso.RestAPI.entity.State;
import br.com.compasso.RestAPI.repository.StateRepository;
import br.com.compasso.RestAPI.service.StateService;

@RestController
@RequestMapping("/api/states")
public class StatesController {
	
	@Autowired StateService stateService;
	@Autowired StateRepository stateRepository;
	
	@PostMapping
	public ResponseEntity<StateDTO> create(@RequestBody StateForm form) {
		StateDTO stateSaved = stateService.save(form);
		return ResponseEntity.created(null).body(stateSaved);
	}
	
	@GetMapping
	public ResponseEntity<List<StateDTO>> listAll(){
		return ResponseEntity.ok(stateService.findAll());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<StateDTO> detail(@PathVariable Long id){
		Optional<State> state = stateRepository.findById(id);
		if(state.isPresent()) {
			return ResponseEntity.ok(stateService.findById(state));
		}
		return ResponseEntity.notFound().build();
	}
	
	@PutMapping("/{id}")
	@Transactional
	public ResponseEntity<StateDTO> update(@PathVariable Long id, @RequestBody StateForm form){
		Optional<State> optional = stateRepository.findById(id);
		if(optional.isPresent()) {
			StateDTO state = stateService.update(id, form);
			return ResponseEntity.ok(stateService.findById(optional));
		}
		return ResponseEntity.notFound().build();
	}
	
	@DeleteMapping("/{id}")
	@Transactional
	public ResponseEntity<?> delete(@PathVariable Long id){
		Optional<State> optional = stateRepository.findById(id);
		if(optional.isPresent()) {
			stateService.delete(id);
			return ResponseEntity.ok().build();
		}
		return ResponseEntity.notFound().build();
	}
}
