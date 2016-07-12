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
public class Gemeente extends EntityObject {

	private String naam;
	private Integer postcode;

	@ManyToOne
	@JoinColumn(name = "PROVINCIE_ID")
	@JsonBackReference
	private Provincie provincie;

	@OneToMany(mappedBy = "gemeente", orphanRemoval = true)
	@Cascade(CascadeType.ALL)
	@JsonManagedReference
	private List<Straat> straten = new ArrayList<>();

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
	 * @return the postcode
	 */
	public Integer getPostcode() {
		return postcode;
	}

	/**
	 * @param postcode
	 *            the postcode to set
	 */
	public void setPostcode(Integer postcode) {
		this.postcode = postcode;
	}

	/**
	 * @return the provincie
	 */
	public Provincie getProvincie() {
		return provincie;
	}

	/**
	 * @param provincie
	 *            the provincie to set
	 */
	public void setProvincie(Provincie provincie) {
		this.provincie = provincie;
	}

	/**
	 * @return the straten
	 */
	public List<Straat> getStraten() {
		return straten;
	}

	/**
	 * @param straten
	 *            the straten to set
	 */
	public void setStraten(List<Straat> straten) {
		this.straten = straten;
	}

	public void addStraat(Straat straat) {
		straat.setGemeente(this);
		this.straten.add(straat);
	}

}
