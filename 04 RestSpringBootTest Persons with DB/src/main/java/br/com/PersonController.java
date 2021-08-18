package br.com;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.model.Person;
import br.com.services.PersonServices;

@RestController
@RequestMapping("/person")
public class PersonController {

	@Autowired
	private PersonServices services;

	//update person with put
	@PutMapping
	public Person update(@RequestBody Person person) {
		return services.update(person);
	}
	
	//adding person with post
	@PostMapping
	public Person create(@RequestBody Person person) {
		return services.create(person);
	}
	
	//removing user with delete
	@DeleteMapping(value = "/{id}")
	public void delete(@PathVariable("id") long id) {
		services.delete(id);
	}
	
	//getting user by id using get
	@GetMapping(value = "/{id}")
	public Person findById(@PathVariable("id") Long id) {
		return services.findById(id);
	}

	@GetMapping
	public List<Person> findAll() {
		return services.findAll();
	}
	
	
}
