package com.example.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.ResortModel;
import com.example.service.ResortService;


@RestController
public class ResortController {
	@Autowired
	public ResortService hserv;
	
	@PostMapping("/postportal")
	public String postportal(@RequestBody ResortModel hr) {
		
		hserv.saveportal(hr);
		return "data saved";
	}
	@GetMapping("/sort/{name}")
	public List<ResortModel> sortdsc(@PathVariable("name")String name)
	{
		return hserv.sortByAsc(name);
	}
	//Pagination
		@GetMapping("/pagination/{num}/{size}")
		public List<ResortModel> paginationEx(@PathVariable("num") int num,@PathVariable("size") int size)
		{
			return hserv.pagination(num,size);
		}
		//pagination and sorting
		@GetMapping("/paginationAndSort/{num}/{size}/{name}")
		public List<ResortModel> paginationAndSort(@PathVariable("num") int num,@PathVariable("size") int size,@PathVariable("name")  String name)
		{
			return hserv.paginationAndSorting(num,size,name);
		}
	}
	

