package com.kelver.services.impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import com.kelver.models.Pessoa;
import com.kelver.services.interfaces.CrudService;
import com.kelver.utils.JPAUtils;

public class PessoaService implements CrudService<Pessoa, Integer> {

	@Override
	public List<Pessoa> all() {
		List<Pessoa> p = new ArrayList<Pessoa>();
		EntityManager em = null;
		try {
			em = JPAUtils.getEntityManager();
			p = em.createQuery("from Pessoa", Pessoa.class).getResultList();
			return p;
		} finally {
			if (em != null) {
				em.close();
			}
		}
	}

	@Override
	public Pessoa byId(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Pessoa insert(Pessoa entity) {
		EntityManager em = null;
		try {
			em = JPAUtils.getEntityManager();
			em.getTransaction().begin();
			em.persist(entity);
			em.getTransaction().commit();
			return entity;
		} finally {
			if (em != null) {
				em.close();
			}
		}
	}

	@Override
	public Pessoa update(Pessoa entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(Pessoa entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteById(Integer id) {
		// TODO Auto-generated method stub
		
	}

	
}
