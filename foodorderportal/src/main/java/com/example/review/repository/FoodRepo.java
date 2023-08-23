package com.example.review.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.review.model.FoodModel;

public interface FoodRepo extends JpaRepository<FoodModel, Integer> {

}
