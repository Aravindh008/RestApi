package com.example.day5.controller;

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


import com.example.day5.model.HotelModel;
import com.example.day5.service.HotelService;

@RestController
public class HotelController {
	@Autowired
	public HotelService hserv;
	
	@PostMapping("/postHotel")
	public String postHostel(@RequestBody HotelModel hr) {
		
		hserv.saveHotel(hr);
		return "data saved";
	}
	@GetMapping("/getHotel")
	public List<HotelModel> getHotelInfo(){
		return hserv.getHotel();
	}
	@PutMapping("/updateHotel")
	public HotelModel updateHotelInfo(@RequestBody HotelModel hm) {
		return hserv.updateHotel(hm);
	}
	
	@DeleteMapping("/deleteHotelif/{id}")
	public ResponseEntity<String>deleteHotelInfo(@PathVariable int id){
		boolean deleted =hserv.deleteHotelif(id);
		if(deleted) {
			return ResponseEntity.ok("Hotel with Id "+id+" deleted successfully");
		}
		else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Hotel with ID "+  id+" not found");
		}
	}
	@GetMapping("/users/{userId}")
	public ResponseEntity<?> getUserbyId(@PathVariable int userId){
		Optional<HotelModel> hotel = hserv.getUserId(userId);
		if(hotel!=null) {
			return ResponseEntity.ok(hotel);
		}
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not available with ID ");
	}
	@DeleteMapping("/byrepparm")
	public String removedRequestParm(@RequestParam("id") int id) {
		hserv.deleteHotel(id);
		return "Hotel with Id "+id+" is deleted";

	}
}


