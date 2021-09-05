package br.com.compasso.RestAPI.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import br.com.compasso.RestAPI.dto.CarDTO;
import br.com.compasso.RestAPI.entity.Car;
import br.com.compasso.RestAPI.repository.CarRepository;

@Service
public class CarService {
	
	@Autowired
	private CarRepository carRepository;
	
	public void createCar(@RequestBody CarDTO carDTO) {
		Car carEntity = new Car();
		carEntity.setChassi(carDTO.getChassi());
		carEntity.setNome(carDTO.getNome());
		carEntity.setMarca(carDTO.getMarca());
		carEntity.setCor(carDTO.getCor());
		carEntity.setValor(carDTO.getValor());
		carEntity.setAnoFabricacao(carDTO.getAnoFabricacao());
		carRepository.save(carEntity);
	}
	
	public List<CarDTO> listAll(){
		List<CarDTO> carDTOS = new ArrayList<>();
		List<Car> carEntities = carRepository.findAll();
		carEntities.stream().forEach(object -> {
			CarDTO carDTO = new CarDTO();
			carDTO.setChassi(object.getChassi());
			carDTO.setNome(object.getNome());
			carDTO.setMarca(object.getMarca());
			carDTO.setCor(object.getCor());
			carDTO.setValor(object.getValor());
			carDTO.setAnoFabricacao(object.getAnoFabricacao());
			carDTOS.add(carDTO);
		});
		return carDTOS;
	}
	
}
