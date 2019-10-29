package com.q.crud.dao;

import java.util.List;

import com.q.crud.entity.Model;

public interface EntityDao {

	void delete(Long id);

	void update(Long id, Model model);

	void save(Model model);

	List<Model> getAll();

	Model get(Long id);

}
