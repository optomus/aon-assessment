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
    Predicate build(Root<Insurer> insurer, Customer customer, CriteriaBuilder cb);

    InsurerSpecification and(InsurerSpecification other);

    InsurerSpecification or(InsurerSpecification other);
}
