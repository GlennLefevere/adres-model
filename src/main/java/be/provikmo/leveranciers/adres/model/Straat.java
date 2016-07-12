/**
 * (c) 2016 ADMB. All rights reserved.
 */
package be.provikmo.leveranciers.adres.model;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;

/**
 * @author Glenn Lefevere
 *
 */
@Entity
public class Straat extends EntityObject {

	private String naam;

	@ManyToOne
	@JoinColumn(name = "GEMEENTE_ID")
	@JsonBackReference
	private Gemeente gemeente;

	/**
	 * @return the naam
	 */
	public String getNaam() {
		return naam;
	}

	/**
	 * @param naam
	 *            the naam to set
	 */
	public void setNaam(String naam) {
		this.naam = naam;
	}

	/**
	 * @return the gemeente
	 */
	public Gemeente getGemeente() {
		return gemeente;
	}

	/**
	 * @param gemeente
	 *            the gemeente to set
	 */
	public void setGemeente(Gemeente gemeente) {
		this.gemeente = gemeente;
	}

}
