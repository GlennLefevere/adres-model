/**
 * (c) 2016 ADMB. All rights reserved.
 */
package be.provikmo.leveranciers.adres.services.api;

import java.util.List;

import org.springframework.stereotype.Service;

import be.provikmo.leveranciers.adres.model.Land;

/**
 * @author Glenn Lefevere
 *
 */
@Service
public interface LandService {

	Land save(Land land);

	List<Land> findAll();

	List<Land> findByQuery(String query);
}
