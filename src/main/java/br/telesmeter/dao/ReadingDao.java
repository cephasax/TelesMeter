package br.telesmeter.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;

import br.telesmeter.domain.Reading;

public class ReadingDao extends GenericDao {

	public ArrayList<Reading> findReadingFilter(String nomeUsuario, int idUnidade, int idSetor) {

		// CONSTRUCAO DA CONSULTA SQL
		String sql = " Select r FROM Reading r" + 
					 " JOIN r.station station";
		StringBuilder where = new StringBuilder();
		where.append(" WHERE 1 = 1 ");

		if (idUnidade > 0) {
			where.append(" and unidade.idUnidade = :idUnidade");
		}
		if (idSetor > 0) {
			where.append(" and setor.idSetor = :idSetor");
		}
		if (!nomeUsuario.equals("")) {
			where.append(" and lower(p.vinculo.usuario.nome) like lower(:nome) ");
		}
		StringBuilder sqlFinal = new StringBuilder();
		sqlFinal.append(sql);
		sqlFinal.append(where.toString());
		Query query = em.createQuery(sqlFinal.toString());

		// DEFINICAO DOS PARAMETROS DA CONSULTA
		if (idUnidade > 0) {
			query.setParameter("idUnidade", idUnidade);
		}
		if (idSetor > 0) {
			query.setParameter("idSetor", idSetor);
		}
		if (!nomeUsuario.equals("")) {
			query.setParameter("nome", "%" + nomeUsuario + "%");
		}

		// EXECUCAO E RETORNO
		return (ArrayList<Reading>) query.getResultList();
	}

	public ArrayList<Reading> list() {
		Query query = em.createQuery("Select r from Reading r");
		List<Reading> results = new ArrayList<Reading>();
		results = query.getResultList();
		return (ArrayList<Reading>) results;
	}

}
