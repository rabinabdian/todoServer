package com.jb.todoServer.controllers;

import com.jb.todoServer.beans.Person;
import com.jb.todoServer.bl.PersonManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("PersonManager")
public class PersonController {

	@Autowired
	PersonManager siteManager;

	@CrossOrigin(origins = "*")
	@GetMapping("getAllPersons")
	public ResponseEntity<List<Person>> getAll()
	{
		List<Person> persons = this.siteManager.getAllPersons();		
		return new ResponseEntity<List<Person>>(persons, HttpStatus.OK);
		
	}

	@CrossOrigin(origins = "*")
	@PostMapping("addPerson")
	/**
	 * This add person to DB
	 * 
	 * @param person
	 * @return
	 */
	public ResponseEntity<?> addPerson(@RequestBody Person person)
	{
		try
		{
			this.siteManager.addPerson(person);
			return new ResponseEntity<Void>(HttpStatus.CREATED);
		}
		catch(Exception e)
		{
			return new ResponseEntity<Exception>(e,HttpStatus.FORBIDDEN);
		}
		
	}

}
