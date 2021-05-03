package com.jb.todoServer.beans;


import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.swagger.annotations.ApiModelProperty;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

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

	public Todo(long id, String description, boolean completed) {
		this.id=id;
		this.description=description;
		this.isCompleted=completed;
	}

	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@ApiModelProperty(hidden = true)
	@Column
	private long id;

	@Column
	private String description;

	@Column
	private boolean isCompleted;


	public Todo() {	}
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

	@Override
	public String toString() {
		return "Todo{" +
				"person=" + person +
				", description='" + description + '\'' +
				", isCompleted=" + isCompleted +
				'}';
	}
}
