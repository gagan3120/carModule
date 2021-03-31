package com.module.product.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.model.product.exception.ResourceNotFoundException;
import com.module.product.model.Car;
import com.module.product.repository.ICarRepository;


@Service
@Transactional
public class ICarServiceImpl implements ICarService{
	
	@Autowired
	private ICarRepository ICarRepository;

	@Override
	public Car addCar(Car car) {
		return ICarRepository.save(car);
	}

	@Override
	public void removeCar(long id) {
		Optional<Car> carList = this.ICarRepository.findById(id);
		
		if(carList.isPresent()) {
			this.ICarRepository.delete(carList.get());
		}
		else {
			throw new ResourceNotFoundException("Record not found with ID :" + id);
		}
	}

	@Override
	public Car updateCar(Car car, long id) {
		Optional<Car> carList = this.ICarRepository.findById(id);
		
		if(carList.isPresent()) {
			Car carUpdate = carList.get();
			carUpdate.setBrand(car.getBrand());
			carUpdate.setModel(car.getModel());
			carUpdate.setVariant(car.getVariant());
			carUpdate.setRegistrationYear(car.getRegistrationYear());
			carUpdate.setRegistrationState(car.getRegistrationState());
			
			ICarRepository.save(carUpdate);
			return carUpdate;
		}
		else {
			throw new ResourceNotFoundException("Record not found with ID :" + id);
		}
		
	}

	@Override
	public Car getCar(long id) {
		Optional<Car> carList = this.ICarRepository.findById(id);
		
		if(carList.isPresent()) {
			return carList.get();
		}
		else {
			throw new ResourceNotFoundException("Record not found with ID :" + id);
		}
	}

	@Override
	public List<Car> getAllCars() {
		return (List<Car>) ICarRepository.findAll();
	}



	@Override
	public List<Car> getCarsByModel(String model) {
		return (List<Car>) ICarRepository.findByModel(model);
	}

	@Override
	public List<Car> getCarsByBrand(String brand) {
		return (List<Car>) ICarRepository.findByBrand(brand);
	}

}
