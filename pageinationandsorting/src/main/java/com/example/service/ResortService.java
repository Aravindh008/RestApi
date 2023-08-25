package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.model.ResortModel;
import com.example.repository.ResortRepo;


@Service
public class ResortService {
	@Autowired
	public ResortRepo srepo;
	public String saveportal(ResortModel h) {
		srepo.save(h);
		return "Data is saved to database";
	}
	public List<ResortModel> sortByAsc(String name)
	{
		//return srepo.findAll(Sort.by(name).descending());
		return srepo.findAll(Sort.by(name).ascending());
		
	}
	public List<ResortModel> pagination(int pageNo,int pageSize){
		  Page<ResortModel> cont=srepo.findAll(PageRequest.of(pageNo,pageSize));
		  return cont.getContent();
	  }
	//and sorting
	  public List<ResortModel> paginationAndSorting(int pageNo,int pageSize,String name)
	  {
		  Page<ResortModel> cont1=srepo.findAll(PageRequest.of(pageNo, pageSize,Sort.by(name)));
		  return cont1.getContent();
	  }
	

}
