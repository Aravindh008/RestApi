package com.example.demo.Day7.Repo;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.Day7.Model.*;

import jakarta.transaction.Transactional;

public interface Repo extends JpaRepository<Model, Integer>{
	
	@Query(value="select * from general3",nativeQuery=true)
	public List<Model> getAllRows();

	@Query(value="select*from general3 where place=:d and age=:p",nativeQuery=true )
	public List<Model> getSpecRows(@Param("d")String d,@Param("p")String p);
	
	@Query(value="select*from general3 where general3 like %?1",nativeQuery=true )
	public List<Model> getbyname(@Param("d")String d);
	
	//delete using native query
	@Modifying
	@Transactional
	@Query(value="DELETE FROM general3 WHERE id=?1",nativeQuery=true)
	public int deleted(@Param("id")int id);
	
	//update the query
	@Modifying
	@Transactional
	@Query(value="update general3 set place=:d where id=:id",nativeQuery=true)
	public Integer updateById(@Param("d")String d,@Param("id")int id);

	@Modifying
	@Transactional
	@Query("delete from Model h where h.id=:id")
	public int nav(@Param("id") int id);
}