package com.jb.todoServer.beans;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import io.swagger.annotations.ApiModelProperty;

@Entity
public class Person {

	@OneToMany(mappedBy="person")
	
	private long id;
	private String name;
	private String pass;
	
	private List<Todo> todos= new ArrayList<>();
	
	 public Person() {
		// TODO Auto-generated constructor stub
	}
	 public Person(long id,String name,String pass) {
		// TODO Auto-generated constructor stub
		 this.id=id;
		 this.name=name;
		 this.pass=pass;
	}
	 
	 
		@Id
		@GeneratedValue
		
	 public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	
	@Column
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Column
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	@OneToMany(cascade=CascadeType.PERSIST,fetch=FetchType.EAGER)
	public List<Todo> getTodos() {
		return todos;
	}
	public void setTodos(List<Todo> todos) {
		this.todos = todos;
	}
	@Override
	public String toString() {
		return "Person [id=" + id + ", name=" + name + ", pass=" + pass + ", toString()=" + super.toString() + "]";
	}
	
	
	 
}
