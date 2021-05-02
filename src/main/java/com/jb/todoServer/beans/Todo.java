package com.jb.todoServer.beans;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import io.swagger.annotations.ApiModelProperty;

@Entity
public class Todo {

	@ManyToOne
	private Person person ;
	private long id;
	private String description;
	private boolean isCompleted;
	
	
	public long getPerson() {
		return person.getId();
	}
	public void setPerson(Person person) {
		this.person = person;
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
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	@Column
	public boolean isCompleted() {
		return isCompleted;
	}
	public void setCompleted(boolean isCompleted) {
		this.isCompleted = isCompleted;
	}
	@Override
	public String toString() {
		return "Todo [person=" + person + ", id=" + id + ", description=" + description + ", isCompleted=" + isCompleted
				+ ", toString()=" + super.toString() + "]";
	}
	
	
	
}
