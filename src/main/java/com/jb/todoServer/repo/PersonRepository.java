package com.jb.todoServer.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jb.todoServer.beans.Person;

public interface PersonRepository extends JpaRepository<Person,Long>{

	Person findPersonByName(String name);
	Person getPersoneById(long id);
}
