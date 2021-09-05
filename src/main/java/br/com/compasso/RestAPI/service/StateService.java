package br.com.compasso.RestAPI.service;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import br.com.compasso.RestAPI.controller.form.StateForm;
import br.com.compasso.RestAPI.dto.StateDTO;
import br.com.compasso.RestAPI.entity.Regiao;
import br.com.compasso.RestAPI.entity.State;
import br.com.compasso.RestAPI.repository.StateRepository;

@Service
public class StateService {
	
	@Autowired
	private StateRepository stateRepository;
	
	@Transactional
	public StateDTO save(@RequestBody StateForm form) {
		State stateEntity = new State();
		stateEntity.setNome(form.getNome());
		stateEntity.setRegiao(form.getRegiao());
		stateEntity.setPopulacao(form.getPopulacao());
		stateEntity.setCapital(form.getCapital());
		stateEntity.setArea(form.getArea());
		stateRepository.save(stateEntity);
		return new StateDTO(stateEntity);
	}

	public Page<StateDTO> find(Pageable paginacao, String reg){
		if(reg == null) {
			Page<State> state = stateRepository.findAll(paginacao);
			Page<StateDTO> stateDTOS = state.map(StateDTO::new);
			return stateDTOS;
		} else {
			Regiao regiao = Regiao.valueOf(reg);
			Page<State> state = stateRepository.findByRegiao(paginacao, regiao);
			Page<StateDTO> stateDTOS = state.map(StateDTO::new);
			return stateDTOS;
		}
	}

	public StateDTO findById(Optional<State> state) {
		return new StateDTO(state.get());
	}

	public StateDTO update(Long id, StateForm form) {
		State state = stateRepository.getOne(id);
		if(form.getNome() != null)state.setNome(form.getNome());
		if(form.getRegiao() != null)state.setRegiao(form.getRegiao());
		if(form.getPopulacao() != null)state.setPopulacao(form.getPopulacao());
		if(form.getCapital() != null)state.setCapital(form.getCapital());
		if(form.getArea() != null)state.setArea(form.getArea());
		
		return new StateDTO(state);
	}

	public void delete(Long id) {
		stateRepository.deleteById(id);
		return;
	}
}
