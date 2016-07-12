/**
 * (c) 2016 ADMB. All rights reserved.
 */
package be.provikmo.leveranciers.adres.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import com.fasterxml.jackson.annotation.JsonManagedReference;

/**
 * @author Glenn Lefevere
 *
 */
@Entity
public class Land extends EntityObject {

	private String naam;

	@OneToMany(mappedBy = "land", orphanRemoval = true)
	@Cascade(CascadeType.ALL)
	@JsonManagedReference
	private List<Provincie> provincies = new ArrayList<>();

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
	 * @return the provincies
	 */
	public List<Provincie> getProvincies() {
		return provincies;
	}

	/**
	 * @param provincies
	 *            the provincies to set
	 */
	public void setProvincies(List<Provincie> provincies) {
		this.provincies = provincies;
	}

	public void addProvincie(Provincie provincie) {
		provincie.setLand(this);
		provincies.add(provincie);
	}

}
