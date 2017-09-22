package br.telesmeter.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

@Entity
@SequenceGenerator(name = "SEQ_STATE", initialValue = 1, allocationSize = 1, sequenceName = "seq_state")
public class State {

	@Id
	//@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = SEQ_STATE)
	private int id;
	
	@ManyToOne
	@JoinColumn(name = "idCountry")
	private Country country;
	
	String name;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Country getCountry() {
		return country;
	}

	public void setCountry(Country country) {
		this.country = country;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}
