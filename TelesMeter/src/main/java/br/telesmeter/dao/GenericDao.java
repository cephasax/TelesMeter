package br.telesmeter.dao;

import javax.persistence.EntityManager;

public abstract class GenericDao {

	public EntityManager em;

	public GenericDao(){
		this.em = getEntityManager();
	}
	
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

	private EntityManager getEntityManager(){
		return DataBase.getInstance().getEntityManager();
	}
}
