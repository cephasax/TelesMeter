package br.telesmeter.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;

import br.telesmeter.domain.Reading;

public class ReadingDao extends GenericDao {

	public Reading findById(int id) {
		// CONSTRUCAO DA CONSULTA SQL
		String sql = " SELECT r FROM Reading r";
		StringBuilder where = new StringBuilder();
		where.append(" WHERE r.id = :id");

		StringBuilder sqlFinal = new StringBuilder();
		sqlFinal.append(sql);
		sqlFinal.append(where.toString());
		Query query = em.createQuery(sqlFinal.toString());

		query.setParameter("id", id);

		// EXECUCAO E RETORNO
		return (Reading)query.getSingleResult();
	}

	@SuppressWarnings("unchecked")
	public ArrayList<Reading> list() {
		Query query = em.createQuery("SELECT r FROM Reading r");
		List<Reading> results = new ArrayList<Reading>();
		results = query.getResultList();
		return (ArrayList<Reading>) results;
	}

	@SuppressWarnings("unchecked")
	public ArrayList<Reading> findReadingForCheck(Reading reading) {

		// CONSTRUCAO DA CONSULTA SQL
		String sql = " SELECT r FROM Reading r";
		StringBuilder where = new StringBuilder();
		where.append(" WHERE r.date = :date");
		where.append(" AND r.station.id = :idStation");

		StringBuilder sqlFinal = new StringBuilder();
		sqlFinal.append(sql);
		sqlFinal.append(where.toString());
		Query query = em.createQuery(sqlFinal.toString());

		query.setParameter("date", reading.getDate());
		query.setParameter("idStation", reading.getStation().getId());

		// EXECUCAO E RETORNO
		return (ArrayList<Reading>) query.getResultList();

	}

}
