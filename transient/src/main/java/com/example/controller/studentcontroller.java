package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


import com.example.model.studentmodel;

import com.example.service.studentservice;

public class studentcontroller {

	@Autowired
	public studentservice hserv;
	//post
	@PostMapping("/poststudent")
	public String postportal(@RequestBody studentmodel hr) {
		
		hserv.saveportal(hr);
		return "data saved";
	}
	@GetMapping("/getstudent")
	public List<studentmodel> getstudentInfo(){
		return hserv.getstudent();
	}
}
