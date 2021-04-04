package com.module.product.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.module.product.model.Car;

@Repository
public interface ICarRepository extends JpaRepository<Car, Long> {

	List<Car> findAll();

	List<Car> findByModel(String model);

	List<Car> findByBrand(String brand);

}
