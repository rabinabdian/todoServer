package com.jb.todoServer.bl;

import com.jb.todoServer.beans.Person;
import com.jb.todoServer.beans.Todo;
import com.jb.todoServer.repo.PersonRepository;
import com.jb.todoServer.repo.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TodoManager {
 
	@Autowired
	PersonRepository repo;

	@Autowired
	TodoRepository repoTodo;

	public void addTodo(Todo todo) throws Exception {
		// TODO Auto-generated method stub

		if (todo.getPerson() == null)
			todo.setPerson(new Person("user","user"));

		Person existingPerson = this.repo.findPersonByName(todo.getPerson().getName());
		if(existingPerson == null )
		{
			throw new Exception("Person is not exists!!!!");

		}
		todo.setPerson(existingPerson);
		this.repoTodo.save(todo);
	}

	public void deleteTodo(Todo todo) throws Exception {
		// TODO Auto-generated method stub


		Todo existingTodo = this.repoTodo.findTodoById(todo.getId());
		if(existingTodo == null)
		{
			throw new Exception(" Todo is not exists!!!!");
		}
		this.repoTodo.delete(existingTodo);
	}

	public void updateTodo(Todo todo) throws Exception {
		// TODO Auto-generated method stub

		Todo existingTodo = this.repoTodo.findTodoById(todo.getId());
		if(existingTodo == null)
		{
			throw new Exception(" Todo is not exists!!!!");
		}
		this.repoTodo.save(existingTodo);

	}

	public List<Todo> getAllTodos() {
		Iterable<Todo> itrbl = this.repoTodo.findAll();
		List<Todo> todoList = new ArrayList<Todo>();
		for (Todo todo : itrbl) {

			todoList.add(todo);
		}
		return todoList;
	}


	public List<Todo> getTodosByPersonName(String name) {
		Person person = this.repo.findPersonByName(name);
		Iterable<Todo> itrbl = this.repoTodo.findAllTodosByPersonId(person.getId());
		List<Todo> todos = new ArrayList<Todo>();
		for (Todo todo : itrbl) {

			todos.add(todo);
		}
		return todos;
	}


}
