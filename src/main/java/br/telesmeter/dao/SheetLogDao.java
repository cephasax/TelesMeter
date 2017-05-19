package br.telesmeter.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;

import br.telesmeter.domain.SheetLog;
import br.telesmeter.domain.Station;

public class SheetLogDao extends GenericDao {
	
	public SheetLog findById( int id ){
		// CONSTRUCAO DA CONSULTA SQL
		String sql = " SELECT s FROM SheetLog s";
		StringBuilder where = new StringBuilder();
		where.append(" WHERE s.id = :id");

		StringBuilder sqlFinal = new StringBuilder();
		sqlFinal.append(sql);
		sqlFinal.append(where.toString());
		Query query = em.createQuery(sqlFinal.toString());

		query.setParameter("id", id);

		// EXECUCAO E RETORNO
		return (SheetLog)query.getSingleResult();
	}
	
	public SheetLog findByFilename( String filename ){
		// CONSTRUCAO DA CONSULTA SQL
		System.out.println("Tentando achar: " + filename);
		String sql = " SELECT s FROM SheetLog s";
		StringBuilder where = new StringBuilder();
		where.append(" WHERE s.filename LIKE ':filename'");

		StringBuilder sqlFinal = new StringBuilder();
		sqlFinal.append(sql);
		sqlFinal.append(where.toString());
		Query query = em.createQuery(sqlFinal.toString());

		query.setParameter("filename", filename);

		// EXECUCAO E RETORNO
		return (SheetLog)query.getSingleResult();
	}
	
	public ArrayList<SheetLog> list(){
		Query query = em.createQuery("SELECT s FROM SheetLog s");
		List<SheetLog> results = new ArrayList<SheetLog>();
		results = query.getResultList();
		return (ArrayList<SheetLog>) results;
	}
	
	public SheetLog findSheetLogForCheck( SheetLog sheetLog ){
		// CONSTRUCAO DA CONSULTA SQL
		String sql = " SELECT s FROM SheetLog s";
		StringBuilder where = new StringBuilder();
		where.append(" WHERE s.filename LIKE ':filename'");

		StringBuilder sqlFinal = new StringBuilder();
		sqlFinal.append(sql);
		sqlFinal.append(where.toString());
		Query query = em.createQuery(sqlFinal.toString());

		query.setParameter("filename", sheetLog.getFileName() );

		// EXECUCAO E RETORNO
		return (SheetLog)query.getSingleResult();
	}

}
