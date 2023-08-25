package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.model.studentmodel;

import com.example.repository.studentrepo;
@Service
public class studentservice {
	@Autowired
	public studentrepo srepo;
	public String saveportal(studentmodel h) {
		srepo.save(h);
		return "Data is saved to database";
	}
	public List<studentmodel> getstudent(){
		return srepo.findAll();
	}

}
