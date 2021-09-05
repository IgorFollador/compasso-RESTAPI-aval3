package br.com.compasso.RestAPI.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import br.com.compasso.RestAPI.dto.StateDTO;
import br.com.compasso.RestAPI.entity.State;
import br.com.compasso.RestAPI.repository.StateRepository;

@Service
public class StateService {
	
	@Autowired
	private StateRepository stateRepository;
	
	public void save(@RequestBody StateDTO stateDTO) {
		State stateEntity = new State();
		stateEntity.setNome(stateDTO.getNome());
		stateEntity.setRegiao(stateDTO.getRegiao());
		stateEntity.setPopulacao(stateDTO.getPopulacao());
		stateEntity.setCapital(stateDTO.getCapital());
		stateEntity.setArea(stateDTO.getArea());
		stateRepository.save(stateEntity);
	}

	public List<StateDTO> findAll(){
		List<StateDTO> stateDTOS = new ArrayList<>();
		List<State> stateEntities = stateRepository.findAll();
		stateEntities.stream().forEach(object -> {
			StateDTO stateDTO = new StateDTO();
			stateDTO.setNome(object.getNome());
			stateDTO.setRegiao(object.getRegiao());
			stateDTO.setPopulacao(object.getPopulacao());
			stateDTO.setCapital(object.getCapital());
			stateDTO.setArea(object.getArea());
			stateDTOS.add(stateDTO);
		});
		return stateDTOS;
	}
}
