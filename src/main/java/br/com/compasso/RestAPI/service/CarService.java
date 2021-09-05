package br.com.compasso.RestAPI.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import br.com.compasso.RestAPI.controller.form.CarForm;
import br.com.compasso.RestAPI.dto.CarDTO;
import br.com.compasso.RestAPI.entity.Car;
import br.com.compasso.RestAPI.repository.CarRepository;

@Service
public class CarService{
	
	@Autowired
	private CarRepository carRepository;
	
	public CarDTO save(@RequestBody CarForm form) {
		Car carEntity = new Car();
		carEntity.setChassi(form.getChassi());
		carEntity.setNome(form.getNome());
		carEntity.setMarca(form.getMarca());
		carEntity.setCor(form.getCor());
		carEntity.setValor(form.getValor());
		carEntity.setAnoFabricacao(form.getAnoFabricacao());
		carRepository.save(carEntity);
		return new CarDTO(carEntity);
	}
	
	public Page<CarDTO> find(Pageable paginacao, String marca, 
			String nome, String cor){
		if(marca != null) {
			Page<Car> car = carRepository.findByMarca(paginacao, marca);
			Page<CarDTO> carDTOS = car.map(CarDTO::new);
			return carDTOS;
		} else if(nome!=null) {
			Page<Car> car = carRepository.findByNome(paginacao, nome);
			Page<CarDTO> carDTOS = car.map(CarDTO::new);
			return carDTOS;
		} else if(cor!=null) {
			Page<Car> car = carRepository.findByCor(paginacao, cor);
			Page<CarDTO> carDTOS = car.map(CarDTO::new);
			return carDTOS;
		} else {
			Page<Car> car = carRepository.findAll(paginacao);
			Page<CarDTO> carDTOS = car.map(CarDTO::new);
			return carDTOS;
		}
	}
	
}
