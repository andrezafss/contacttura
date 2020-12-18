package com.contacttura.contacttura.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.contacttura.contacttura.model.Contacttura;
import com.contacttura.contacttura.model.ContactturaUser;
import com.contacttura.contacttura.repository.ContactturaRepository;
import com.contacttura.contacttura.repository.ContactturaRepositoryUser;

@RestController
@RequestMapping({"/user"})
public class ContactturaControllerUser {
	@Autowired
	private ContactturaRepositoryUser repository;
	
	//List All
	@GetMapping
	//http://localhost:6000/user
	public List findAll() {
		return repository.findAll();
	}

	//Find by id - busca pelo id especifico
	@GetMapping(value = "{id}")
	//http://localhost:6000/user/1
	public ResponseEntity findById(@PathVariable long id) {
		return repository.findById(id)
				.map(user -> ResponseEntity.ok().body(user))
				.orElse(ResponseEntity.notFound().build());
	}


	
	
	
	
	
}
