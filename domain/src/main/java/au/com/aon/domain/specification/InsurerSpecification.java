package au.com.aon.domain.specification;

import au.com.aon.domain.service.Customer;
import au.com.aon.domain.model.Insurer;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

/**
 *
 */
public interface InsurerSpecification {
    Predicate buildSpecification(CriteriaBuilder criteriaBuilder, Root<Insurer> insurer, Customer customer);

    InsurerSpecification and(InsurerSpecification other);

    InsurerSpecification or(InsurerSpecification other);
}
