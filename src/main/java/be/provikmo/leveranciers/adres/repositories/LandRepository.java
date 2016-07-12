/**
 * (c) 2016 ADMB. All rights reserved.
 */
package be.provikmo.leveranciers.adres.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import be.provikmo.leveranciers.adres.model.Land;

/**
 * @author Glenn Lefevere
 *
 */
@Repository
public interface LandRepository extends JpaRepository<Land, Long> {

}
