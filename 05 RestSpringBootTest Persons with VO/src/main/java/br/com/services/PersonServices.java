package br.com.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.converter.DozerConverter;
import br.com.data.model.Person;
import br.com.data.vo.PersonVO;
import br.com.exception.ResourceNotFoundException;
import br.com.repository.PersonRepository;

@Service
public class PersonServices {
	@Autowired
	PersonRepository repository;

	public PersonVO findById(Long id) {
		var entity =  repository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("No records found with this ID."));
		return DozerConverter.parseObject(entity, PersonVO.class);
	}

	public void delete(Long id) {
		Person entity = repository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("No records found with this ID."));
		repository.delete(entity);
	}

	public PersonVO create(PersonVO person) {
		var entity = DozerConverter.parseObject(person, Person.class);
		var vo = DozerConverter.parseObject(repository.save(entity), PersonVO.class);
		return vo;
	}

	public PersonVO update(PersonVO person) {
		Person entity = repository.findById(person.getID())
				.orElseThrow(() -> new ResourceNotFoundException("No records found with this ID."));

		entity.setAddress(person.getAddress());
		entity.setFirstName(person.getFirstName());
		entity.setGender(person.getGender());
		entity.setLastName(person.getLastName());

		return DozerConverter.parseObject(repository.save(entity), PersonVO.class);
	}

	public List<PersonVO> findAll() {
		return DozerConverter.parseListObjects(repository.findAll(), PersonVO.class);
	}

}
