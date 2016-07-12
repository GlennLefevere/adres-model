/**
 * (c) 2016 ADMB. All rights reserved.
 */
package be.provikmo.leveranciers.adres.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

/**
 * @author Glenn Lefevere
 *
 */
@Entity
public class Provincie extends EntityObject {

	private String naam;

	@ManyToOne
	@JoinColumn(name = "LAND_ID")
	@JsonBackReference
	private Land land;

	@OneToMany(mappedBy = "provincie", orphanRemoval = true)
	@Cascade(CascadeType.ALL)
	@JsonManagedReference
	private List<Gemeente> gemeentes = new ArrayList<>();

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
	 * @return the land
	 */
	public Land getLand() {
		return land;
	}

	/**
	 * @param land
	 *            the land to set
	 */
	public void setLand(Land land) {
		this.land = land;
	}

	/**
	 * @return the gemeentes
	 */
	public List<Gemeente> getGemeentes() {
		return gemeentes;
	}

	/**
	 * @param gemeentes
	 *            the gemeentes to set
	 */
	public void setGemeentes(List<Gemeente> gemeentes) {
		this.gemeentes = gemeentes;
	}

	public void addGemeente(Gemeente gemeente) {
		gemeente.setProvincie(this);
		gemeentes.add(gemeente);
	}

}
