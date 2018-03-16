package com.firstapp.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.firstapp.model.Person;
import com.firstapp.util.ApiError;

import lombok.extern.log4j.Log4j2;

@Service
@Log4j2
public class PersonService {
	Map<String, Person> persons = new HashMap<String, Person>();

	public ResponseEntity<Object> getPerson(String id) {
		try {
			if(persons == null || persons.size() == 0) {
				return new ResponseEntity<>(new ApiError("Error in getting person"), HttpStatus.NO_CONTENT);
			}else {
				return new ResponseEntity<>(persons.get(id), HttpStatus.OK);
			}	
		} catch (Exception e) {
			return new ResponseEntity<>(new ApiError("Error in getting dishes"), HttpStatus.BAD_REQUEST);
		}
	}

	public ResponseEntity<Object> getAllPersons() {
		try {
			if(persons == null || persons.size() == 0) {
				return new ResponseEntity<>(new ApiError("Error in getting persons"), HttpStatus.NO_CONTENT);
			}else {
				return new ResponseEntity<>(persons, HttpStatus.OK);
			}
		} catch (Exception e) {
			return new ResponseEntity<>(new ApiError("Error in getting persons"), HttpStatus.BAD_REQUEST);
		}
	}

	public ResponseEntity<Object> postPerson(Person person) {
		try {
			log.info("Adding Person");
			Person p1 = new Person(person.getId(), person.getFirstName(), person.getLastName(), person.getAge());
			persons.put(p1.getId(), p1);
			log.info("Person " + p1.getId() + " successfully");
			return new ResponseEntity<>(p1, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(new ApiError("Error in saving person"), HttpStatus.BAD_REQUEST);
		}
	}

	public ResponseEntity<Object> updatePerson(String id,Person person) {
		try {
			log.info("Updating Person");
			if(persons == null || persons.size() == 0) {
				return new ResponseEntity<>(new ApiError("Error in getting person"), HttpStatus.NO_CONTENT);
			}else {
				Person updatedPerson = persons.get(id);
				updatedPerson.setId(person.getId());
				updatedPerson.setFirstName(person.getFirstName());
				updatedPerson.setLastName(person.getLastName());
				updatedPerson.setAge(person.getAge());
				log.info("Person " + updatedPerson.getId() + "updated successfully");
				return new ResponseEntity<>(updatedPerson, HttpStatus.OK);
			}	
		} catch (Exception e) {
			return new ResponseEntity<>(new ApiError("Error in updating person"), HttpStatus.BAD_REQUEST);
		}
	}
}
