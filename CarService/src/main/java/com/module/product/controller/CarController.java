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

/***********************************************************
 * @author              G Gagandeep Reddy
 * Description          It is a controller class that controls the data flow into model object 
 *                      and updates the view whenever data changes
 * Version              1.0
 * created date         24-03-2021
 ***********************************************************/
@Api(value = "Swagger2DemoRestController")
@RestController
public class CarController {

	@Autowired
	ICarServiceImpl carService;

	/*****************************************************
	 * Method              getAllCars
	 * Description         Displays all the cars
	 * @GetMapping         used to get the cars
	 * @Return             returns all the cars
	 * Created by:         G Gagandeep Reddy
	 * created date        24-03-2021
	 *****************************************************/
	@GetMapping("/cars")
	public ResponseEntity<List<Car>> getAllCars() {
		return ResponseEntity.ok().body(carService.getAllCars());
	}

	/*****************************************************
	 * Method              getCar
	 * Description         Displays all the car by car id
	 * @GetMapping         used to get the car by car id
	 * @Return             returns all the car of the user by car id
	 * Created by:         G Gagandeep Reddy
	 * created date        24-03-2021
	 *****************************************************/
	@GetMapping("/carsbyid/{carid}")
	public ResponseEntity<Car> getCar(@PathVariable("carid") long id) {
		return ResponseEntity.ok().body(carService.getCar(id));
	}

	/*****************************************************
	 * Method              getCarsByModel
	 * Description         Displays all the cars by car id
	 * @GetMapping         used to get the cars by car id
	 * @Return             returns all the cars of the user by car id
	 * Created by:         G Gagandeep Reddy
	 * created date        24-03-2021
	 *****************************************************/
	@GetMapping("/carsbymodel/{model}")
	public ResponseEntity<List<Car>> getCarsByModel(@PathVariable("model") String model) {
		return ResponseEntity.ok().body(carService.getCarsByModel(model));
	}

	/*****************************************************
	 * Method              getCarsByBrand
	 * Description         Displays all the cars by car id
	 * @GetMapping         used to get the cars by car id
	 * @Return             returns all the cars of the user by car id
	 * Created by:         G Gagandeep Reddy
	 * created date        24-03-2021
	 *****************************************************/
	@GetMapping("/carsbybrand/{brand}")
	public ResponseEntity<List<Car>> getCarsByBrand(@PathVariable("brand") String brand) {
		return ResponseEntity.ok().body(carService.getCarsByBrand(brand));
	}

	/*****************************************************
	 * Method              addCar
	 * Description         Displays the newly added car in database
	 * @PostMapping        used to add new car to database 
	 * @Return             returns newly added car details
	 * Created by:         G Gagandeep Reddy
	 * created date        24-03-2021
	 *****************************************************/
	@PostMapping("/addcar")
	public ResponseEntity<Car> addCar(@RequestBody Car car) {
		return ResponseEntity.ok().body(this.carService.addCar(car));
	}

	/*****************************************************
	 * Method              updateCar
	 * Description         Displays new car values after update
	 * @PutMapping         used to update car by id
	 * @Return             car after updating
	 * Created by:         G Gagandeep Reddy
	 * created date        24-03-2021
	 *****************************************************/
	@PutMapping("/updatecar/{carid}")
	public ResponseEntity<Car> updateCar(@RequestBody Car car, @PathVariable("carid") long id) {
		return ResponseEntity.ok().body(this.carService.updateCar(car, id));
	}

	/*****************************************************
	 * Method              removeCar
	 * Description         Displays deleted status
	 * @DeleteMapping      used to delete car by id
	 * @Return             deletion status
	 * Created by:         G Gagandeep Reddy
	 * created date        24-03-2021
	 *****************************************************/
	@DeleteMapping("/cars/{carid}")
	public HttpStatus removeCar(@PathVariable("carid") long id) {
		this.carService.removeCar(id);
		return HttpStatus.OK;
	}
}
