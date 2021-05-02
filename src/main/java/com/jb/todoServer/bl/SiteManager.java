package com.jb.todoServer.bl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jb.todoServer.beans.Person;
import com.jb.todoServer.repo.PersonRepository;

@Service
public class SiteManager {
 
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
			throw new Exception("Employee "+ person.getName() +" alread exists");
		}
		this.repo.save(person);
	}
	
	
	public Employee getEmployee(long id) throws Exception {
		// TODO Auto-generated method stub

		Employee existingEmployee = this.repo.getEmployeeById(id);
		if(existingEmployee !=null)
		{
			return existingEmployee;
		}
		throw new Exception("Employee "+ id +" not exists!!!!");		
	}
	
}
