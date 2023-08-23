package com.example.review.service;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.review.model.FoodModel;
import com.example.review.repository.FoodRepo;


@Service
public class FoodService {
	@Autowired
	public FoodRepo hrepo;
	
	public String saveFood(FoodModel h) {
		hrepo.save(h);
		return "Data is saved to database";
	}
	public List<FoodModel> getFood(){
		return hrepo.findAll();
	}
	public FoodModel updateFood(FoodModel hm) {
		return hrepo.saveAndFlush(hm);
	}
	public void deleteFood(int food_id) {
		System.out.println("Deleted");
		hrepo.deleteById(food_id);
	}
	// delete if id is present
	public boolean deleteFoodif(int foodId) {
		if(hrepo.existsById(foodId)) {
			hrepo.deleteById(foodId);
			return true;
		}
		return false;
	}
	public Optional<FoodModel> getUserId(int userId){
		  Optional <FoodModel> food=hrepo.findById(userId);
		  if(food.isPresent()) {
			  return food;
		  }
		  return null;
		  
	  }
	

}

