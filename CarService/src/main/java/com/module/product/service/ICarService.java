package com.module.product.service;

import java.util.List;

import org.springframework.data.jpa.repository.Query;

import com.module.product.model.Car;


public interface ICarService {
	public Car addCar(Car car);
	public void removeCar(long id);
	public Car updateCar(Car car, long id);
	public Car getCar(long id);
	public List<Car> getAllCars();
	public List<Car> getCarsByModel(String model);
	public List<Car> getCarsByBrand(String brand);
}
