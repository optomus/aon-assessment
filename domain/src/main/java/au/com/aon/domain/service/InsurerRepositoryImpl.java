package au.com.aon.domain.service;

import au.com.aon.domain.model.Insurer;
import au.com.aon.domain.specification.InsurerSpecification;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import java.util.List;

/**
 *
 */
@Repository
public class InsurerRepositoryImpl implements InsurerRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Insurer> getSatisfiedInsurers(InsurerSpecification insurerSpecification) {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Insurer> criteriaQuery = criteriaBuilder.createQuery(Insurer.class);
        criteriaQuery.where();

        return entityManager.createQuery(criteriaQuery).getResultList();
    }

}
