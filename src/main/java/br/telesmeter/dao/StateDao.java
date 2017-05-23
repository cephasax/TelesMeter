package br.telesmeter.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;

import br.telesmeter.domain.State;

public class StateDao extends GenericDao{
	
	public State findById(int id) {
		// CONSTRUCAO DA CONSULTA SQL
		String sql = " SELECT s FROM State s";
		StringBuilder where = new StringBuilder();
		where.append(" WHERE s.id = :id");

		StringBuilder sqlFinal = new StringBuilder();
		sqlFinal.append(sql);
		sqlFinal.append(where.toString());
		Query query = em.createQuery(sqlFinal.toString());

		query.setParameter("id", id);

		// EXECUCAO E RETORNO
		return (State)query.getSingleResult();
	}

	public State findByName(String name) {
		// CONSTRUCAO DA CONSULTA SQL
		System.out.println("Tentando achar: " + name);
		String sql = " SELECT s FROM State s";
		StringBuilder where = new StringBuilder();
		where.append(" WHERE s.name = :name");

		StringBuilder sqlFinal = new StringBuilder();
		sqlFinal.append(sql);
		sqlFinal.append(where.toString());
		Query query = em.createQuery(sqlFinal.toString());

		query.setParameter("name", name);

		// EXECUCAO E RETORNO
		return (State)query.getSingleResult();
	}
	
	public ArrayList<State> list() {
		Query query = em.createQuery("SELECT s FROM State s");
		List<State> results = new ArrayList<State>();
		results = query.getResultList();
		return (ArrayList<State>) results;
	}

	public ArrayList<State> findStateForCheck(State state) {

		// CONSTRUCAO DA CONSULTA SQL
		String sql = "SELECT s FROM State s";
		StringBuilder where = new StringBuilder();
		where.append(" WHERE s.name = :name");

		StringBuilder sqlFinal = new StringBuilder();
		sqlFinal.append(sql);
		sqlFinal.append(where.toString());
		Query query = em.createQuery(sqlFinal.toString());

		query.setParameter("name", state.getName());

		// EXECUCAO E RETORNO
		return (ArrayList<State>) query.getResultList();
	}
	
}
