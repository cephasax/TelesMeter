package br.telesmeter.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;

import br.telesmeter.domain.Country;

public class CountryDao extends GenericDao {

	public Country findById(int id) {
		// CONSTRUCAO DA CONSULTA SQL
		String sql = " SELECT c FROM Country c";
		StringBuilder where = new StringBuilder();
		where.append(" WHERE c.id = :id");

		StringBuilder sqlFinal = new StringBuilder();
		sqlFinal.append(sql);
		sqlFinal.append(where.toString());
		Query query = em.createQuery(sqlFinal.toString());

		query.setParameter("id", id);

		// EXECUCAO E RETORNO
		return (Country)query.getSingleResult();
	}

	public Country findByName(String name) {
		// CONSTRUCAO DA CONSULTA SQL
		System.out.println("Tentando achar: " + name);
		String sql = " SELECT c FROM Country c";
		StringBuilder where = new StringBuilder();
		where.append(" WHERE c.name = :name");

		StringBuilder sqlFinal = new StringBuilder();
		sqlFinal.append(sql);
		sqlFinal.append(where.toString());
		Query query = em.createQuery(sqlFinal.toString());

		query.setParameter("name", name);

		// EXECUCAO E RETORNO
		return (Country)query.getSingleResult();
	}
	
	public ArrayList<Country> list() {
		Query query = em.createQuery("SELECT c FROM Country c");
		List<Country> results = new ArrayList<Country>();
		results = query.getResultList();
		return (ArrayList<Country>) results;
	}

	public ArrayList<Country> findCountryForCheck(Country country) {

		// CONSTRUCAO DA CONSULTA SQL
		String sql = "SELECT c FROM Country c";
		StringBuilder where = new StringBuilder();
		where.append(" WHERE c.name = :name");

		StringBuilder sqlFinal = new StringBuilder();
		sqlFinal.append(sql);
		sqlFinal.append(where.toString());
		Query query = em.createQuery(sqlFinal.toString());

		query.setParameter("name", country.getName());

		// EXECUCAO E RETORNO
		return (ArrayList<Country>) query.getResultList();

	}
}
