package com.module.product.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.module.product.model.Car;

/***************************************************************
 * @author              G Gagandeep Reddy
 * Description          It is a test repository interface that extends JPA repository 
 *                      that contains inbuilt methods for various CRUD operations
 * Version              1.0
 * created date         24-03-2021
 *
 ****************************************************************/
@Repository
public interface ICarRepository extends JpaRepository<Car, Long> {

	List<Car> findAll();

	List<Car> findByModel(String model);

	List<Car> findByBrand(String brand);

}
