package br.telesmeter.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;

import br.telesmeter.domain.Station;

public class StationDao extends GenericDao {

	public Station findById(int id) {
		// CONSTRUCAO DA CONSULTA SQL
		String sql = " SELECT s FROM Station s";
		StringBuilder where = new StringBuilder();
		where.append(" WHERE s.id = :id");

		StringBuilder sqlFinal = new StringBuilder();
		sqlFinal.append(sql);
		sqlFinal.append(where.toString());
		Query query = em.createQuery(sqlFinal.toString());

		query.setParameter("id", id);

		// EXECUCAO E RETORNO
		return (Station)query.getSingleResult();
	}

	public Station findByCodename(String codename) {
		// CONSTRUCAO DA CONSULTA SQL
		System.out.println("Tentando achar: " + codename);
		String sql = " SELECT s FROM Station s";
		StringBuilder where = new StringBuilder();
		where.append(" WHERE s.codename = :codename");

		StringBuilder sqlFinal = new StringBuilder();
		sqlFinal.append(sql);
		sqlFinal.append(where.toString());
		Query query = em.createQuery(sqlFinal.toString());

		query.setParameter("codename", codename);

		// EXECUCAO E RETORNO
		return (Station)query.getSingleResult();
	}
	
	public ArrayList<Station> list() {
		Query query = em.createQuery("SELECT s FROM Station s");
		List<Station> results = new ArrayList<Station>();
		results = query.getResultList();
		return (ArrayList<Station>) results;
	}

	public ArrayList<Station> findStationForCheck(Station station) {

		// CONSTRUCAO DA CONSULTA SQL
		String sql = "SELECT s FROM Station s";
		StringBuilder where = new StringBuilder();
		where.append(" WHERE s.codename = :codename");

		StringBuilder sqlFinal = new StringBuilder();
		sqlFinal.append(sql);
		sqlFinal.append(where.toString());
		Query query = em.createQuery(sqlFinal.toString());

		query.setParameter("codename", station.getCodename());

		// EXECUCAO E RETORNO
		return (ArrayList<Station>) query.getResultList();

	}
	
}
