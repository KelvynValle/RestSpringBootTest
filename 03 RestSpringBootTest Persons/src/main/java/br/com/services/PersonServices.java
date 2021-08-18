package br.com.services;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.stereotype.Service;

import br.com.model.Person;

@Service
public class PersonServices {

	private final AtomicLong counter = new AtomicLong();
	public Person findById(String id) {
		Person person = new Person();
		person.setID(counter.incrementAndGet());
		person.setFirstName("Kelvyn");
		person.setLastName("Valle");
		person.setAddress("São Paulo, São Paulo - Brazil");
		person.setGender("Male");
		return person;
	}
	
	public void delete(String id) {

	}
	
	public Person create(Person person) {
		return person;
	}
	
	public Person update(Person person) {
		return person;
	}
	
	public List<Person> findAll(){
		List<Person> persons = new ArrayList<Person>();
		for(int i = 0; i < 10; i++) {
			Person person = mockPerson(i);
			persons.add(person);
		}
		return persons;
	}

	private Person mockPerson(int i) {
		Person person = new Person();
		person.setID(counter.incrementAndGet());
		person.setFirstName("Kelvyn" + i);
		person.setLastName("Valle" + i);
		person.setAddress("São Paulo, São Paulo - Brazil");
		person.setGender("Male");
		return person;
	}
	
}
