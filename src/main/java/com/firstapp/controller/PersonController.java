package com.firstapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.firstapp.model.Person;
import com.firstapp.service.PersonService;

import io.swagger.annotations.ApiOperation;

@RestController
@CrossOrigin
@RequestMapping(value="/person",produces= MediaType.APPLICATION_JSON_VALUE)
public class PersonController {
	
	@Autowired
	PersonService ps;
	
	@ApiOperation(value = "Find Person By ID", notes = "Find Person By ID")
	@RequestMapping(value="/findPerson/{id}",method = RequestMethod.GET,headers="Accept=application/json")
	public ResponseEntity<Object> getPerson(@PathVariable("id") String id) {
		return ps.getPerson(id);
	}
	
	@ApiOperation(value = "Find All Persons", notes = "Find All Persons")
	@RequestMapping(value="/findAllPersons",method = RequestMethod.GET,headers="Accept=application/json")
	public ResponseEntity<Object> getAllPerson(){
		return ps.getAllPersons();
	}
	
	@ApiOperation(value = "Add Person", notes = "Add Person")
	@RequestMapping(value="/add",method = RequestMethod.POST,headers="Accept=application/json")
	public ResponseEntity<Object> postPerson(@RequestBody Person person){
		return ps.postPerson(person);
	}
	
	@ApiOperation(value = "Update Person", notes = "Update Person")
	@RequestMapping(value="/update/{id}",method = RequestMethod.PUT,headers="Accept=application/json")
	public ResponseEntity<Object> updatePerson(@PathVariable("id") String id,@RequestBody Person person){
		return ps.updatePerson(id,person);
	}
}
