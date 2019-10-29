package com.q.crud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.q.crud.entity.Model;
import com.q.crud.service.EntityService;

@RestController
public class EntityController {

	@Autowired
	private EntityService entityService;

	@GetMapping(value = "/entity/{id}")
	public ResponseEntity<Model> get(@PathVariable("id") Long id) {
		Model model = entityService.get(id);
		return ResponseEntity.ok().body(model);
	}

	@GetMapping(value = "/entity")
	public ResponseEntity<List<Model>> getAll() {
		List<Model> models = entityService.getAll();
		return ResponseEntity.ok().body(models);
	}

	@PostMapping(value = "/entity")
	public ResponseEntity<?> save(@RequestBody Model model) {
		entityService.save(model);
		return ResponseEntity.ok().build();
	}

	@PutMapping(value = "/entity/{id}")
	public ResponseEntity<?> update(@PathVariable("id") Long id, @RequestBody Model model) {
		entityService.update(id, model);
		return ResponseEntity.ok().build();
	}

	@DeleteMapping(value = "/entity/{id}")
	public ResponseEntity<?> delete(@PathVariable("id") Long id) {
		entityService.delete(id);
		return ResponseEntity.ok().build();
	}
}
