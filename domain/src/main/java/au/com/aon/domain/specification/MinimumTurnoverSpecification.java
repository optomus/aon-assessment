package au.com.aon.domain.specification;


import au.com.aon.domain.model.ExclusionCriteria;
import au.com.aon.domain.model.CriteriaCode;
import au.com.aon.domain.model.Insurer;
import au.com.aon.domain.service.Customer;

import javax.persistence.criteria.*;
import java.math.BigDecimal;

public class MinimumTurnoverSpecification extends AbstractInsurerSpecification {

    @Override
    public Predicate build(Root<Insurer> insurer, Customer customer, CriteriaBuilder cb) {
        Join<ExclusionCriteria, Customer> join = insurer.join("exclusionCriterias", JoinType.LEFT);
        join.on(
                cb.and(
                        cb.equal(join.get("criteriaCode"), CriteriaCode.MIN_TURNOVER)
                )
        );

        return cb.or(
                cb.isNull(join.get("criteriaValue")),
                cb.lessThan(join.<BigDecimal>get("criteriaValue"), customer.getAnnualTurnover())
        );
    }
}
