package com.example.demo.Day7.Model;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="modelclass")

public class Model {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(name="name")
	private String name;
	private int rollNum;
	private String characterName;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getRollnum() {
		return rollNum;
	}
	public void setRollnum(int rollnum) {
		this.rollNum = rollnum;
	}
	public String getCharacter() {
		return characterName;
	}
	public void setCharacter(String character) {
		this.characterName = character;
	}

		

}
