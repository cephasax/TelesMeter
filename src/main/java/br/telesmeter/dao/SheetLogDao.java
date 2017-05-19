package br.telesmeter.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Query;

import br.telesmeter.domain.Reading;
import br.telesmeter.domain.SheetLog;

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
	
	public ArrayList<SheetLog> findSheetLogForCheck( SheetLog sheetLog ){
		// CONSTRUCAO DA CONSULTA SQL
		String sql = " SELECT s FROM SheetLog s";
		StringBuilder where = new StringBuilder();
		where.append(" WHERE s.filename LIKE ':filename'");
		where.append(" AND s.id = :id");
		where.append(" AND s.date = :date");
		where.append(" AND s.columnsNames LIKE ':columnsNames'");
		where.append(" AND s.timeToInsertInMinutes = :timeToInsertInMinutes");
		where.append(" AND s.entityType LIKE ':entityType'");

		StringBuilder sqlFinal = new StringBuilder();
		sqlFinal.append(sql);
		sqlFinal.append(where.toString());
		Query query = em.createQuery(sqlFinal.toString());

		query.setParameter("filename", sheetLog.getFileName() );
		query.setParameter("id", sheetLog.getId() );
		query.setParameter("date", sheetLog.getDate() );
		query.setParameter("columnsNames", sheetLog.getColumnsNames() );
		query.setParameter("timeToInsertInMinutes", sheetLog.getTimeToInsertInMinutes() );
		query.setParameter("entityType", sheetLog.getEntityType() );

		// EXECUCAO E RETORNO
		return (ArrayList<SheetLog>) query.getResultList();
	}
	
	/*
	private String fileName;
	private Date date;
	private String columnsNames;
	private double timeToInsertInMinutes;
	private String entityType;
	*/
}
