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

import br.com.data.vo.PersonVO;
import br.com.services.PersonServices;

@RestController
@RequestMapping("/person")
public class PersonController {

	@Autowired
	private PersonServices services;

	// update person with put
	@PutMapping
	public PersonVO update(@RequestBody PersonVO person) {
		return services.update(person);
	}

	// adding person with post
	@PostMapping
	public PersonVO create(@RequestBody PersonVO person) {
		return services.create(person);
	}

	// removing user with delete
	@DeleteMapping(value = "/{id}")
	public void delete(@PathVariable("id") long id) {
		services.delete(id);
	}

	// getting user by id using get
	@GetMapping(value = "/{id}")
	public PersonVO findById(@PathVariable("id") Long id) {
		return services.findById(id);
	}

	@GetMapping
	public List<PersonVO> findAll() {
		return services.findAll();
	}

}
