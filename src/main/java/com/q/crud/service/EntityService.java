package com.q.crud.service;

import java.util.List;

import com.q.crud.entity.Model;

public interface EntityService {

	void delete(Long id);

	void update(Long id, Model model);

	void save(Model model);

	List<Model> getAll();

	Model get(Long id);

}
