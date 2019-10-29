package com.q.crud.dao;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.q.crud.entity.Model;

@Repository
public class EntityDaoImpl implements EntityDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	
	@Override
	public Model get(Long id){
		Session session = sessionFactory.getCurrentSession();
		Model model = session.get(Model.class, id);
		return model;
	}
	
	@Override
	public List<Model> getAll(){
		Session session = sessionFactory.getCurrentSession();
		CriteriaBuilder cb = session.getCriteriaBuilder();
		CriteriaQuery<Model> cq = cb.createQuery(Model.class);
		Root<Model> root = cq.from(Model.class);
		cq.select(root);
		Query<Model> query = session.createQuery(cq);
		return query.getResultList();
	}
	
	@Override
	public void save(Model model){
		Session session = sessionFactory.getCurrentSession();
		session.save(model);
	}
	
	
	@Override
	public void update(Long id, Model model){
		Session session = sessionFactory.getCurrentSession();
		Model modelFormDB = session.byId(Model.class).load(id);
		modelFormDB.setName(model.getName());
		modelFormDB.setValue(model.getValue());
		modelFormDB.setCurrency(model.getCurrency());
		modelFormDB.setCost(model.getCost());
		session.flush();
	}
	
	@Override
	public void delete(Long id) {
		Session session = sessionFactory.getCurrentSession();
		Model model = session.byId(Model.class).load(id);
		session.delete(model);
	}
	
}
