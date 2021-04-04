package com.module.product.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.module.product.model.Car;
import com.module.product.service.ICarServiceImpl;

import io.swagger.annotations.Api;

@Api(value = "Swagger2DemoRestController")
@RestController
public class CarController {

	@Autowired
	ICarServiceImpl carService;

	@GetMapping("/cars")
	public ResponseEntity<List<Car>> getAllCars() {
		return ResponseEntity.ok().body(carService.getAllCars());
	}

	@GetMapping("/carsbyid/{carid}")
	public ResponseEntity<Car> getCar(@PathVariable("carid") long id) {
		return ResponseEntity.ok().body(carService.getCar(id));
	}

	@GetMapping("/carsbymodel/{model}")
	public ResponseEntity<List<Car>> getCarsByModel(@PathVariable("model") String model) {
		return ResponseEntity.ok().body(carService.getCarsByModel(model));
	}

	@GetMapping("/carsbybrand/{brand}")
	public ResponseEntity<List<Car>> getCarsByBrand(@PathVariable("brand") String brand) {
		return ResponseEntity.ok().body(carService.getCarsByBrand(brand));
	}

	@PostMapping("/addcar")
	public ResponseEntity<Car> addCar(@RequestBody Car car) {
		return ResponseEntity.ok().body(this.carService.addCar(car));
	}

	@PutMapping("/updatecar/{carid}")
	public ResponseEntity<Car> updateCar(@RequestBody Car car, @PathVariable("carid") long id) {
		return ResponseEntity.ok().body(this.carService.updateCar(car, id));
	}

	@DeleteMapping("/cars/{carid}")
	public HttpStatus removeCar(@PathVariable("carid") long id) {
		this.carService.removeCar(id);
		return HttpStatus.OK;
	}
}
