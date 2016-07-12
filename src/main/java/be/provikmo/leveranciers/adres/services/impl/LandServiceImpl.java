/**
 * (c) 2016 ADMB. All rights reserved.
 */
package be.provikmo.leveranciers.adres.services.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.JoinType;
import javax.persistence.criteria.Root;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import be.provikmo.leveranciers.adres.model.Land;
import be.provikmo.leveranciers.adres.model.Land_;
import be.provikmo.leveranciers.adres.repositories.LandRepository;
import be.provikmo.leveranciers.adres.services.api.LandService;

/**
 * @author Glenn Lefevere
 *
 */
@Repository
@Transactional(readOnly = true)
public class LandServiceImpl implements LandService {

	@PersistenceContext
	private EntityManager em;

	@Autowired
	private LandRepository landRepository;

	/** {@inheritDoc} */
	@Override
	public Land save(Land land) {
		return landRepository.save(land);
	}

	/** {@inheritDoc} */
	@Override
	public List<Land> findAll() {
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Land> cq = cb.createQuery(Land.class).distinct(true);
		Root<Land> root = cq.from(Land.class);

		root.fetch(Land_.provincies, JoinType.INNER);

		cq.select(root);

		TypedQuery<Land> query = em.createQuery(cq);

		return query.getResultList();
	}

	/** {@inheritDoc} */
	@Override
	public List<Land> findByQuery(String query) {
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Land> cq = cb.createQuery(Land.class).distinct(true);
		Root<Land> root = cq.from(Land.class);

		root.fetch(Land_.provincies, JoinType.INNER);

		cq.where(cb.like(cb.upper(root.get(Land_.naam)), "%" + query + "%"));

		TypedQuery<Land> tq = em.createQuery(cq);

		return tq.getResultList();
	}
}
