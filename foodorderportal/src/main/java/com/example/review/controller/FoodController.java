package com.example.review.controller;



import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.review.model.FoodModel;
import com.example.review.service.FoodService;


@RestController
public class FoodController {
	@Autowired
	public FoodService hserv;
	
	@PostMapping("/postFood")
	public String postFood(@RequestBody FoodModel hr) {
		
		hserv.saveFood(hr);
		return "data saved";
	}
	@GetMapping("/getFood")
	public List<FoodModel> getHotelInfo(){
		return hserv.getFood();
	}
	@PutMapping("/updateFood")
	public FoodModel updateFoodInfo(@RequestBody FoodModel hm) {
		return hserv.updateFood(hm);
	}
	
	@DeleteMapping("/deleteFoodif/{id}")
	public ResponseEntity<String>deleteFoodInfo(@PathVariable int id){
		boolean deleted =hserv.deleteFoodif(id);
		if(deleted) {
			return ResponseEntity.ok("Food with Id "+id+" deleted successfully");
		}
		else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Food with ID "+  id+" not found");
		}
	}
	@GetMapping("/users/{userId}")
	public ResponseEntity<?> getUserbyId(@PathVariable int userId){
		Optional<FoodModel> hotel = hserv.getUserId(userId);
		if(hotel!=null) {
			return ResponseEntity.ok(hotel);
		}
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not available with ID ");
	}
	@DeleteMapping("/reparm/{id}")
	public String removedRequestParm(@RequestParam("id") int id) {
		hserv.deleteFood(id);
		return "Hotel with Id "+id+" is deleted";
	

	}
}

