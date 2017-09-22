package br.telesmeter.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class DataBase {

	private static DataBase singleton = new DataBase();
	private static EntityManager em;

	private DataBase() {
		EntityManagerFactory entityManagerFactory = Persistence
				.createEntityManagerFactory("teste");
		em = entityManagerFactory.createEntityManager();
	}

	public static DataBase getInstance() {
		return singleton;
	}

	public EntityManager getEntityManager() {
		return em;
	}

}
