package com.jb.todoServer.beans;


import javax.persistence.*;
import javax.swing.*;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.swagger.annotations.ApiModelProperty;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.awt.*;

@Entity
@Table
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Todo {

	//@ManyToOne(targetEntity = Person.class,cascade=CascadeType.REMOVE)
	//@ManyToOne(cascade=CascadeType.ALL)
	@ManyToOne( fetch = FetchType.LAZY, optional = false)
	@OnDelete(action = OnDeleteAction.CASCADE)
	@JoinColumn(name="person_id", nullable = false)
	private Person person;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@ApiModelProperty(hidden = true)
	@Column
	private long id;

	@Column
	private String title;

	@Column
	private String description;

	@Enumerated(EnumType.STRING)
	@Column
	@ApiModelProperty
	private PriorityTodo priorityTodo;

	@Column
	private boolean isCompleted;

	@Column
	private String color;

	@Column
	private String icon;



	public Todo() {	}

	public Todo(Person person, String title, String description, PriorityTodo priorityTodo, boolean isCompleted, String color, String icon) {
		this.person = person;
		this.title = title;
		this.description = description;
		this.priorityTodo = priorityTodo;
		this.isCompleted = isCompleted;
		this.color = color;
		this.icon = icon;
	}

	//	public Todo(long id, String description, boolean completed) {
//		this.id=id;
//		this.description=description;
//		this.isCompleted=completed;
//	}
	public Todo(String description, boolean isCompleted) {
		super();
		this.description = description;
		this.isCompleted = isCompleted;
	}
	public Todo(String description, boolean isCompleted,Person p) {
		super();
		this.description = description;
		this.isCompleted = isCompleted;
		this.person=p;

	}

	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}

	public boolean isCompleted() {
		return isCompleted;
	}
	public void setCompleted(boolean isCompleted) {
		this.isCompleted = isCompleted;
	}
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public PriorityTodo getPriorityTodo() {
		return priorityTodo;
	}

	public void setPriorityTodo(PriorityTodo priorityTodo) {
		this.priorityTodo = priorityTodo;
	}


	public String getIcon() {
		return icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}
	@Override
	public String toString() {
		return "Todo{" +
				"person=" + person +
				", description='" + description + '\'' +
				", isCompleted=" + isCompleted +
				'}';
	}
}
