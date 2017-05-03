package br.telesmeter.dao;

import javax.persistence.EntityManager;

public class GenericDao {

	public EntityManager em;
	
	public void insert(Object obj){
		em = getEntityManager();
		em.getTransaction().begin();
		em.persist(obj);
		em.getTransaction().commit();
	}
	
	public void delete(Object obj){
		em = getEntityManager();
		em.getTransaction().begin();
		em.remove(obj);
		em.getTransaction().commit();
	}
	
	public void update(Object obj){
		em = getEntityManager();
		em.getTransaction().begin();
		em.merge(obj);
		em.getTransaction().commit();
	}
	
	public Object findById(Class<?> cls , long id){
		em = getEntityManager();
		return em.find(cls, id);
	}

	private EntityManager getEntityManager(){
		return DataBase.getInstance().getEntityManager();
	}
}
