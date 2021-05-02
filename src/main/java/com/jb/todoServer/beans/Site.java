package com.jb.todoServer.beans;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.jb.todoServer.repo.PersonRepository;
import com.jb.todoServer.repo.TodoRepository;


@Component
@Scope("prototype")
public class Site {

	@Autowired
	private PersonRepository persRepo;
	@Autowired
	private TodoRepository todoRepo;
	
	
	
}
