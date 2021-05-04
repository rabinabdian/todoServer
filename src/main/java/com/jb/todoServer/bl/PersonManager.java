package com.jb.todoServer.bl;

import com.jb.todoServer.beans.Person;

import com.jb.todoServer.repo.PersonRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PersonManager {
 
	@Autowired
	PersonRepository repo;

	
	public List<Person> getAllPersons()
	{
		Iterable<Person> itrbl = this.repo.findAll();
		List<Person> persons = new ArrayList<Person>();
	    for (Person p : itrbl) {
	    	persons.add(p);
	    }
		return persons;
	}
	
	public void addPerson(Person person) throws Exception {
		// TODO Auto-generated method stub
		Person existingPerson = this.repo.findPersonByName(person.getName());
		if(existingPerson != null )
		{
			throw new Exception("Person "+ person.getName() +" alread exists");
		}
		this.repo.save(person);
	}
	
	public Person getPerson(long id) throws Exception {
		// TODO Auto-generated method stub

		Person existingPerson = this.repo.getPersonById(id);
		if(existingPerson !=null)
		{
			return existingPerson;
		}
		throw new Exception("Person "+ id +" not exists!!!!");		
	}

	public Person findPersonByName(String userName) throws UsernameNotFoundException {

		Person user = repo.findPersonByName(userName);
		if(user != null) {

			return user;
		} else {
			throw new UsernameNotFoundException("username not found");
		}
	}


	public Person loadUserByUsername(String userName) throws UsernameNotFoundException {

		Person user = repo.findPersonByName(userName);
		if(user != null) {

			return user;
		} else {
			throw new UsernameNotFoundException("username not found");
		}
	}

}
