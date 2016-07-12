/**
 * (c) 2016 ADMB. All rights reserved.
 */
package be.provikmo.leveranciers.adres.services.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import be.provikmo.leveranciers.adres.repositories.GemeenteRepository;
import be.provikmo.leveranciers.adres.services.api.GemeenteService;

/**
 * @author Glenn Lefevere
 *
 */
@Repository
@Transactional(readOnly = true)
public class GemeenteServiceImpl implements GemeenteService {

	@PersistenceContext
	private EntityManager em;

	@Autowired
	private GemeenteRepository gemeenteRepository;
}
