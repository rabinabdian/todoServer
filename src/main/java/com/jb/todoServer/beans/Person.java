package com.jb.todoServer.beans;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.swagger.annotations.ApiModelProperty;

@Entity
@Table
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Person {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	@ApiModelProperty(hidden = true)
	private long id;

	@Column
	private String name;

	@Column
	private String pass;


	 public Person() {
		// TODO Auto-generated constructor stub
	}


	public Person( String name, String pass) {
		super();

		this.name = name;
		this.pass = pass;

	}

	@ApiModelProperty(hidden = true)
	 public long getId() {
		return id;
	}
	@ApiModelProperty(hidden = true)
	public void setId(long id) {
		this.id = id;
	}
	

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}


	@Override
	public String toString() {
		return "Person{" +
				"name='" + name + '\'' +
				", pass='" + pass + '\'' +
				'}';
	}
}
