package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.model.studentmodel;

public interface studentrepo extends JpaRepository<studentmodel, Integer>{

}
