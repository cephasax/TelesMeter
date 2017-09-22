package br.telesmeter.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

/**
 * @author Cephas
 *
 */
@Entity
@SequenceGenerator(name = "SEQ_STATION", initialValue = 1, allocationSize = 1, sequenceName = "seq_station")
public class Station extends AbstractData implements Serializable{

	private static final long serialVersionUID = 3654603550097362494L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_STATION")
	private int id;
	
	private String codename;
	
	private double latitude;
	private double longitude;
	private double altitude;
	
	//Can be separated in future
	private String cityName;
	private String basin;
	private String subBasin;
	private String river;
	
	private int stateCode;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCodename() {
		return codename;
	}

	public void setCodename(String codename) {
		this.codename = codename;
	}

	public double getLatitude() {
		return latitude;
	}

	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}

	public double getLongitude() {
		return longitude;
	}

	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}

	public double getAltitude() {
		return altitude;
	}

	public void setAltitude(double altitude) {
		this.altitude = altitude;
	}

	public String getCityName() {
		return cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	public String getBasin() {
		return basin;
	}

	public void setBasin(String basin) {
		this.basin = basin;
	}

	public String getSubBasin() {
		return subBasin;
	}

	public void setSubBasin(String subBasin) {
		this.subBasin = subBasin;
	}

	public String getRiver() {
		return river;
	}

	public void setRiver(String river) {
		this.river = river;
	}

	public int getStateCode() {
		return stateCode;
	}

	public void setStateCode(int stateCode) {
		this.stateCode = stateCode;
	}

	@Override
	public String toString() {
		return "Station [codename=" + codename + ", latitude=" + latitude + ", longitude=" + longitude + ", basin="
				+ basin + "]";
	}
		
}
