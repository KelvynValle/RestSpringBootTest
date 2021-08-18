package br.com.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.exception.ResourceNotFoundException;
import br.com.model.Person;
import br.com.repository.PersonRepository;

@Service
public class PersonServices {
	@Autowired
	PersonRepository repository;

	public Person findById(Long id) {
		return repository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("No records found with this ID."));
	}

	public void delete(Long id) {
		Person entity = repository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("No records found with this ID."));
		repository.delete(entity);
	}

	public Person create(Person person) {
		return repository.save(person);
	}

	public Person update(Person person) {
		Person entity = repository.findById(person.getID())
				.orElseThrow(() -> new ResourceNotFoundException("No records found with this ID."));

		entity.setAddress(person.getAddress());
		entity.setFirstName(person.getFirstName());
		entity.setGender(person.getGender());
		entity.setLastName(person.getLastName());

		return repository.save(entity);
	}

	public List<Person> findAll() {
		return repository.findAll();
	}

}
