package com.jb.todoServer.controllers;

import com.jb.todoServer.beans.PayloadTodo;
import com.jb.todoServer.beans.Person;
import com.jb.todoServer.beans.PriorityTodo;
import com.jb.todoServer.beans.Todo;
import com.jb.todoServer.bl.TodoManager;
import com.jb.todoServer.repo.PersonRepository;
import com.jb.todoServer.repo.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.config.ConfigDataResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@RestController
@RequestMapping("TodoManager")
public class TodoController {

	@Autowired
	TodoManager todoManager;
	
	@Autowired
	PersonRepository repo;

	@Autowired
	TodoRepository repoTodo;

	@CrossOrigin(origins = "*")
	@GetMapping("getAllTodos")
	public ResponseEntity<List<Todo>> getAllTodos()
	{
		List<Todo> todos = this.todoManager.getAllTodos();
		return new ResponseEntity<List<Todo>>(todos, HttpStatus.OK);

	}

	@CrossOrigin(origins = "*")
	@PostMapping("addTodo")
	/**
	 * This add employee to DB
	 *
	 * @param employee
	 * @return
	 */
	public ResponseEntity<?> addTodo(@RequestBody Todo todo)
	{
		try
		{
			this.todoManager.addTodo(todo);
			return new ResponseEntity<Void>(HttpStatus.CREATED);
		}
		catch(Exception e)
		{
			return new ResponseEntity<Exception>(e,HttpStatus.FORBIDDEN);
		}

	}



	@GetMapping("getAllTodos/{username}")
	public ResponseEntity<?> getEmployee(@PathVariable("username") String username)
	{
		try {

			if (this.todoManager.getTodosByPersonName(username) != null) {

				List<Todo> todoList = this.todoManager.getTodosByPersonName(username);
				return new ResponseEntity<List<Todo>>(todoList, HttpStatus.OK);}
			return new ResponseEntity<EntityNotFoundException>(HttpStatus.NOT_FOUND);
		}

		catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<Exception>(e,HttpStatus.EXPECTATION_FAILED);
		}
	}


	@CrossOrigin
	@DeleteMapping("deleteTodo/{todoId}")
	/**
	 * This delete todo from DB
	 *
	 * @param todo
	 * @return
	 */
	public ResponseEntity<?> deleteTodo(@PathVariable(value = "todoId") int todoId)
	{
		try
		{
			Todo todo = repoTodo.findTodoById(todoId);
			this.todoManager.deleteTodo(todo);
			return new ResponseEntity<Void>(HttpStatus.ACCEPTED);
		}
		catch(Exception e)
		{
			return new ResponseEntity<Exception>(e,HttpStatus.NOT_FOUND);
		}

	}

	@CrossOrigin
	@PutMapping("updateTodo/{todoId}")
	/**
	 * This update
	 *
	 * @param todo
	 * @return
	 */
	public ResponseEntity<Todo> updateTodo(@PathVariable(value = "todoId") int todoId, @RequestBody Todo payload)
	{
		Todo todBeforeUpdate = repoTodo.findTodoById(todoId);
		if (payload.getTitle()==null)
			todBeforeUpdate.setTitle("missing data");
		if (!todBeforeUpdate.getTitle().equalsIgnoreCase(payload.getTitle()))
			todBeforeUpdate.setTitle(payload.getTitle());
		if (payload.getDescription()==null)
			todBeforeUpdate.setDescription("missing data");
		if (!todBeforeUpdate.getDescription().equalsIgnoreCase(payload.getDescription()))
			todBeforeUpdate.setDescription(payload.getDescription());
		if ( todBeforeUpdate.isCompleted() != payload.isCompleted())
			todBeforeUpdate.setCompleted(payload.isCompleted());
		if ( payload.getColor()==null )
			todBeforeUpdate.setColor("white");
		if ( todBeforeUpdate.getColor() != payload.getColor() )
			todBeforeUpdate.setColor(payload.getColor());
		if ( payload.getPriorityTodo()==null )
			todBeforeUpdate.setPriorityTodo(PriorityTodo.DEFAULT);
		if ( todBeforeUpdate.getPriorityTodo() != payload.getPriorityTodo() )
			todBeforeUpdate.setColor(payload.getColor());

		final Todo updatedTodo = repoTodo.save(todBeforeUpdate);
		//this.productManager.updateProduct(updatedProduct);
		return  ResponseEntity.ok(updatedTodo);

	}




}
