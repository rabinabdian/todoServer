package com.jb.todoServer.controllers;

import com.jb.todoServer.beans.Person;
import com.jb.todoServer.beans.Todo;
import com.jb.todoServer.bl.PersonManager;
import com.jb.todoServer.bl.TodoManager;
import com.jb.todoServer.repo.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RestController
@RequestMapping("PersonManager")
public class PersonController {

	@Autowired
	PersonManager siteManager;
	@Autowired
	TodoRepository repoTodo;
	@Autowired
	TodoManager todoManager;

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


//	@RequestMapping(value = "/login", method = RequestMethod.GET)
//	public ModelAndView login() {
//		ModelAndView modelAndView = new ModelAndView();
//		modelAndView.setViewName("login");
//		return modelAndView;
//	}

	@CrossOrigin(origins = "*")
	@PostMapping("/login")
	/**
	 * This add person to DB
	 *
	 * @param person
	 * @return
	 */
	public ResponseEntity<?> login(@RequestBody Person person)
	{
		try
		{
			Person searchedPerson = siteManager.findPersonByName(person.getName());
			if(searchedPerson != null)
				if(searchedPerson.getPass()==person.getPass())
				{	List<Todo> todoList = todoManager.getTodosByPersonName(searchedPerson.getName());
			return new ResponseEntity<List<Todo>>(todoList, HttpStatus.OK);}
			return null;
		}
		catch(Exception e)
		{
			return new ResponseEntity<Exception>(e,HttpStatus.FORBIDDEN);
		}

	}


}
