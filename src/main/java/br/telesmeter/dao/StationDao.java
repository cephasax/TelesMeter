package br.telesmeter.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;

import br.telesmeter.domain.Station;

public class StationDao extends GenericDao {

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
		where.append(" WHERE s.name = :name");

		StringBuilder sqlFinal = new StringBuilder();
		sqlFinal.append(sql);
		sqlFinal.append(where.toString());
		Query query = em.createQuery(sqlFinal.toString());

		query.setParameter("name", station.getCodename());

		// EXECUCAO E RETORNO
		return (ArrayList<Station>) query.getResultList();

	}
	
}
