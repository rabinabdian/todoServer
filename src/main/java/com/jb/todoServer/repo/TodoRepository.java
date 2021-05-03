package com.jb.todoServer.repo;

import com.jb.todoServer.beans.Person;
import com.jb.todoServer.beans.Todo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TodoRepository extends JpaRepository<Todo,Long> {

    List<Todo> findTodoByPersonName(String name);


    Iterable<Todo> findAllTodosByPersonId(long id);

    Todo findTodoById(long id);
}
