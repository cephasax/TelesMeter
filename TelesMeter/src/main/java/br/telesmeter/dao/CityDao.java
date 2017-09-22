package br.telesmeter.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;

import br.telesmeter.domain.City;

public class CityDao extends GenericDao{
	
	public City findById(int id) {
		// CONSTRUCAO DA CONSULTA SQL
		String sql = " SELECT c FROM City c";
		StringBuilder where = new StringBuilder();
		where.append(" WHERE c.id = :id");

		StringBuilder sqlFinal = new StringBuilder();
		sqlFinal.append(sql);
		sqlFinal.append(where.toString());
		Query query = em.createQuery(sqlFinal.toString());

		query.setParameter("id", id);

		// EXECUCAO E RETORNO
		return (City)query.getSingleResult();
	}

	public City findByName(String name) {
		// CONSTRUCAO DA CONSULTA SQL
		System.out.println("Tentando achar: " + name);
		String sql = " SELECT c FROM City c";
		StringBuilder where = new StringBuilder();
		where.append(" WHERE c.name = :name");

		StringBuilder sqlFinal = new StringBuilder();
		sqlFinal.append(sql);
		sqlFinal.append(where.toString());
		Query query = em.createQuery(sqlFinal.toString());

		query.setParameter("name", name);

		// EXECUCAO E RETORNO
		return (City)query.getSingleResult();
	}
	
	@SuppressWarnings("unchecked")
	public ArrayList<City> list() {
		Query query = em.createQuery("SELECT c FROM City c");
		List<City> results = new ArrayList<City>();
		results = (List<City>)query.getResultList();
		return (ArrayList<City>) results;
	}

	@SuppressWarnings("unchecked")
	public ArrayList<City> findCityForCheck(City city) {

		// CONSTRUCAO DA CONSULTA SQL
		String sql = "SELECT c FROM City c";
		StringBuilder where = new StringBuilder();
		where.append(" WHERE c.name = :name");

		StringBuilder sqlFinal = new StringBuilder();
		sqlFinal.append(sql);
		sqlFinal.append(where.toString());
		Query query = em.createQuery(sqlFinal.toString());

		query.setParameter("name", city.getName());

		// EXECUCAO E RETORNO
		return (ArrayList<City>) query.getResultList();
	}
	
}
