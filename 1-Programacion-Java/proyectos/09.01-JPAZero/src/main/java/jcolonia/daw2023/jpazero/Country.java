package jcolonia.daw2023.jpazero;

import java.io.Serializable;
import jakarta.persistence.*;


/**
 * The persistent class for the "Country" database table.
 * 
 */
@Entity
@Table(name="\"Country\"")
@NamedQuery(name="Country.findAll", query="SELECT c FROM Country c")
public class Country implements Serializable {
	private static final long serialVersionUID = 1L;

	@Column(name="\"Capital\"")
	private String capital;

	@Column(name="\"Language\"")
	private String language;

	@Column(name="\"Name\"")
	private String name;

	public Country() {
	}

	public String getCapital() {
		return this.capital;
	}

	public void setCapital(String capital) {
		this.capital = capital;
	}

	public String getLanguage() {
		return this.language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

}