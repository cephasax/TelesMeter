package br.telesmeter.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity
@SequenceGenerator(name = "SEQ_STATION", initialValue = 1, allocationSize = 1, sequenceName = "seq_station")
public class Station implements Serializable{

	
	private static final long serialVersionUID = 3654603550097362494L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_STATION")
	private int id;
	
	private String name;
	
	private long latitude;
	private long longitude;
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public long getLatitude() {
		return latitude;
	}
	
	public void setLatitude(long latitude) {
		this.latitude = latitude;
	}
	
	public long getLongitude() {
		return longitude;
	}
	
	public void setLongitude(long longitude) {
		this.longitude = longitude;
	}
	
	
		
}
