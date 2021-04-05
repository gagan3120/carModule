package com.module.product;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import com.module.product.model.Car;
import com.module.product.repository.ICarRepository;
import com.module.product.service.ICarServiceImpl;

/**********************************************************************************
 * @author                 G Gagandeep reddy
 * Description             It is a service implementation test class that defines the methods
 *                         to test the service.
 * Version                 1.0
 * created date            24-03-2021
 *
 ****************************************************************************************/

@RunWith(MockitoJUnitRunner.class)
public class CarModuleTests {
	
	@InjectMocks
	ICarServiceImpl iCarServiceImpl;
	
	@Mock
	ICarRepository iCarRepository;
	/************************************************************************************
	 * Method                     getAllCarsTest
	 * Description                It is used to test getAllCars method 
	 * created by                 G Gagandeep reddy
	 * created date               24-03-2021
	 ***********************************************************************************/
	@Test
	public void getAllCarsTest() {
		List<Car> car_list = new ArrayList<Car>();
		LocalDate reg_date_1 = LocalDate.of(2007,12,03);
		Car car_values_1 = new Car(123L, "Tata", "Nano", "Basic", reg_date_1, "Andhra Pradesh");
		LocalDate reg_date_2 = LocalDate.of(2010,10,11);
		Car car_values_2 = new Car(8900L, "Mahindra", "XUV", "500", reg_date_2, "Telangana");
		LocalDate reg_date_3 = LocalDate.of(2015,12,28);
		Car car_values_3 = new Car(232L, "Toyata", "Innova", "Crysta", reg_date_3, "Andhra Pradesh");
		
		car_list.add(car_values_1);
		car_list.add(car_values_2);
		car_list.add(car_values_3);
		
		when(iCarRepository.findAll()).thenReturn(car_list);
		
		List<Car> check_car_list = iCarServiceImpl.getAllCars();
		
		assertEquals(3, check_car_list.size());
		verify(iCarRepository, times(1)).findAll();
		
	}
	/************************************************************************************
	 * Method                     getCarTest
	 * Description                It is used to test getCars method 
	 * created by                 G Gagandeep reddy
	 * created date               24-03-2021
	 ***********************************************************************************/
	
	@Test
	public void getCarTest() {
		LocalDate reg_date = LocalDate.of(2007,12,03);
		Optional<Car> carList = Optional.of(new Car(123L, "Tata", "Nano", "Basic", reg_date, "Andhra Pradesh"));
		when(iCarRepository.findById(123L)).thenReturn(carList);
		
		Car car_values = iCarServiceImpl.getCar(123L);
		
		assertEquals("Tata",car_values.getBrand());
		assertEquals("Nano",car_values.getModel());
		assertEquals("Basic",car_values.getVariant());
		assertEquals(reg_date,car_values.getRegistrationYear());
		assertEquals("Andhra Pradesh",car_values.getRegistrationState());
	
	}
	/************************************************************************************
	 * Method                     addCarTest
	 * Description                It is used to test addCar method 
	 * created by                 G Gagandeep reddy
	 * created date               24-03-2021
	 ***********************************************************************************/
	@Test
	public void addCarTest() {
		LocalDate reg_date = LocalDate.of(2007,12,03);
		Car car = new Car(123L, "Tata", "Nano", "Basic", reg_date, "Andhra Pradesh");
		when(iCarRepository.save(car)).thenReturn(car);
		
		Car car_values = iCarServiceImpl.addCar(car);
		
		assertEquals("Nano",car_values.getModel());
		assertEquals("Basic",car_values.getVariant());
		assertEquals(reg_date,car_values.getRegistrationYear());
		assertEquals("Andhra Pradesh",car_values.getRegistrationState());
		
	}
	/************************************************************************************
	 * Method                     removecarTest
	 * Description                It is used to test removecar method 
	 * created by                 G sai nikesh
	 * created date               24-03-2021
	 ***********************************************************************************/
	
	@Test
	public void  removeCarTest() {
		verify(iCarRepository, never()).delete(any(Car.class));
	}
	/************************************************************************************
	 * Method                     updatecarTest
	 * Description                It is used to test updatecar method 
	 * created by                 G sai nikesh
	 * created date               24-03-2021
	 ***********************************************************************************/
	
	@Test
	public void updateCarTest() {
		LocalDate reg_date = LocalDate.of(2007,12,03);
		Optional<Car> car_values = Optional.of(new Car(123L, "Tata", "Nano", "Basic", reg_date, "Andhra Pradesh"));
		
		LocalDate new_reg_date = LocalDate.of(2010,10,11);
		Car new_car_values = new Car(123L, "Mahindra", "XUV", "500", new_reg_date, "Telangana");
		
		when(iCarRepository.findById(123L)).thenReturn(car_values);
		
		iCarServiceImpl.updateCar(new_car_values, 123L);
		
		assertEquals("Mahindra",new_car_values.getBrand());
		assertEquals("XUV",new_car_values.getModel());
		assertEquals("500",new_car_values.getVariant());
		assertEquals(new_reg_date,new_car_values.getRegistrationYear());
		assertEquals("Telangana",new_car_values.getRegistrationState());
	}
	
	/************************************************************************************
	 * Method                     getCarsbyModelTest
	 * Description                It is used to test getCarsbyModel method 
	 * created by                 G Gagandeep reddy
	 * created date               24-03-2021
	 ***********************************************************************************/
	
	@Test
	public void getCarsByModelTest() {
		List<Car> car_list = new ArrayList<Car>();
		LocalDate reg_date_1 = LocalDate.of(2007,12,03);
		Car car_values_1 = new Car(123L, "Tata", "Nano", "Basic", reg_date_1, "Andhra Pradesh");
		LocalDate reg_date_2 = LocalDate.of(2010,10,11);
		Car car_values_2 = new Car(456L, "Tata", "Nano", "High", reg_date_2, "Telangana");
		LocalDate reg_date_3 = LocalDate.of(2015,12,28);
		Car car_values_3 = new Car(789L, "Tata", "Harrier", "High", reg_date_3, "Tamil Nadu");
		
		car_list.add(car_values_1);
		car_list.add(car_values_2);
		car_list.add(car_values_3);
		
		when(iCarRepository.findByModel("Nano")).thenReturn(car_list);
		
		List<Car> check_car_list = iCarServiceImpl.getCarsByModel("Nano");
		
		assertEquals(3, check_car_list.size());
		verify(iCarRepository, times(1)).findByModel("Nano");
	}
	/************************************************************************************
	 * Method                     getAllCarsbyBrandTest
	 * Description                It is used to test getAllCarsByBrand method 
	 * created by                 G Gagandeep reddy
	 * created date               24-03-2021
	 ***********************************************************************************/
	
	@Test
	public void getCarsByBrandTest() {
		List<Car> car_list = new ArrayList<Car>();
		LocalDate reg_date_1 = LocalDate.of(2007,12,03);
		Car car_values_1 = new Car(123L, "Tata", "Nano", "Basic", reg_date_1, "Andhra Pradesh");
		LocalDate reg_date_2 = LocalDate.of(2010,10,11);
		Car car_values_2 = new Car(456L, "Tata", "Nano", "High", reg_date_2, "Telangana");
		LocalDate reg_date_3 = LocalDate.of(2015,12,28);
		Car car_values_3 = new Car(789L, "Tata", "Harrier", "High", reg_date_3, "Tamil Nadu");
		
		car_list.add(car_values_1);
		car_list.add(car_values_2);
		car_list.add(car_values_3);
		
		when(iCarRepository.findByBrand("Tata")).thenReturn(car_list);
		
		List<Car> check_car_list = iCarServiceImpl.getCarsByBrand("Tata");
		
		assertEquals(3, check_car_list.size());
		verify(iCarRepository, times(1)).findByBrand("Tata");
	}
}
