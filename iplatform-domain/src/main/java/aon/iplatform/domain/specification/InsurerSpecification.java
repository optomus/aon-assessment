package aon.iplatform.domain.specification;

import aon.iplatform.domain.model.common.Customer;
import aon.iplatform.domain.model.insurer.Insurer;

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
