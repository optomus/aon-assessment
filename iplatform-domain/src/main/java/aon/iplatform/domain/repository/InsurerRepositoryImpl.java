package aon.iplatform.domain.repository;

import aon.iplatform.domain.model.common.Customer;
import aon.iplatform.domain.model.insurer.Insurer;
import aon.iplatform.domain.specification.InsurerSpecification;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

/**
 *
 */
@Repository
public class InsurerRepositoryImpl implements InsurerRepository {

    @PersistenceContext
    private EntityManager em;

    @Override
    public List<Insurer> getInsurers() {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Insurer> query = cb.createQuery(Insurer.class);
        Root<Insurer> root = query.from(Insurer.class);
        return em.createQuery(query.select(root)).getResultList();
    }

    @Override
    public List<Insurer> getSatisfiedInsurers(Customer customer, InsurerSpecification insurerSpecification) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Insurer> query = cb.createQuery(Insurer.class);
        Root<Insurer> root = query.from(Insurer.class);
        query.where(insurerSpecification.build(root, customer, cb));
        return em.createQuery(query.select(root)).getResultList();
    }

}
