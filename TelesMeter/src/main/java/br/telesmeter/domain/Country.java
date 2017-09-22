package br.telesmeter.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity
@SequenceGenerator(name = "SEQ_COUNTRY", initialValue = 1, allocationSize = 1, sequenceName = "seq_country")
public class Country {
	
	@Id
	//@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = SEQ_COUNTRY)
	private int id;
	
	String name;

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
	
}
