package br.telesmeter.domain;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity
@SequenceGenerator(name = "SEQ_SHEET_LOG", initialValue = 1, allocationSize = 1, sequenceName = "seq_sheet_log")
public class SheetLog {

	@Id
	// GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_SHEET_LOG")
	private int Id;

	private String fileName;
	private Date date;
	private String columnsNames;
	private double timeToInsertInMinutes;
	private String entityType;

	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public Date getDate() {
		return date;
	}

	public void setData(Date date) {
		this.date = date;
	}

	public String getColumnsNames() {
		return columnsNames;
	}

	public void setColumnsNames(String columnsNames) {
		this.columnsNames = columnsNames;
	}

	public double getTimeToInsertInMinutes() {
		return timeToInsertInMinutes;
	}

	public void setTimeToInsertInMinutes(double timeToInsertInMinutes) {
		this.timeToInsertInMinutes = timeToInsertInMinutes;
	}

	public String getEntityType() {
		return entityType;
	}

	public void setEntityType(String entityType) {
		this.entityType = entityType;
	}

}
