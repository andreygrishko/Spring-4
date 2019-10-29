package com.q.crud.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.q.crud.dao.EntityDao;
import com.q.crud.entity.Model;

@Service
@Transactional(readOnly = true)
public class EntityServiceImpl implements EntityService {

	
	@Autowired
	private EntityDao entityDao;
	
	@Override
	public Model get(Long id){
		Model model = entityDao.get(id);
		return model;
	}
	
	@Override
	public List<Model> getAll(){
		List<Model> list = entityDao.getAll();
		return list;
	}
	
	@Override
	@Transactional
	public void save(Model model){
		entityDao.save(model);
	}
	
	@Override
	@Transactional
	public void update(Long id, Model model){
		entityDao.update(id, model);
	}
	
	@Override
	@Transactional
	public void delete(Long id){
		entityDao.delete(id);
	}
}
