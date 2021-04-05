package com.module.product.service;

import java.util.List;

import org.springframework.data.jpa.repository.Query;

import com.module.product.model.Car;

/****************************************************************************
 * @author               G Gagandeep Reddy
 * Description           It is a user service interface that describes the abstract methods
 *                       used in its implementation class.
 * version               1.0
 * created date          24-03-2021
 *
 ****************************************************************************/
public interface ICarService {
	public Car addCar(Car car);

	public void removeCar(long id);

	public Car updateCar(Car car, long id);

	public Car getCar(long id);

	public List<Car> getAllCars();

	public List<Car> getCarsByModel(String model);

	public List<Car> getCarsByBrand(String brand);
}
