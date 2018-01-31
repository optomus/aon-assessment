package aon.iplatform.domain.specification;


import aon.iplatform.domain.model.common.Customer;
import aon.iplatform.domain.model.insurer.CriteriaCode;
import aon.iplatform.domain.model.insurer.ExclusionCriteria;
import aon.iplatform.domain.model.insurer.Insurer;

import javax.persistence.criteria.*;
import java.math.BigDecimal;

public class MinimumTurnoverSpecification extends AbstractInsurerSpecification {

    @Override
    public Predicate build(Root<Insurer> insurer, Customer customer, CriteriaBuilder cb) {
        Join<ExclusionCriteria, Customer> join = insurer.join("exclusionCriterias", JoinType.LEFT);
        join.on(
                cb.equal(join.get("criteriaCode"), CriteriaCode.MIN_TURNOVER)
        );

        return cb.or(
                cb.isNull(join.get("criteriaValue")),
                cb.and(
                    cb.isNotNull(join.get("criteriaValue")),
                    cb.lessThan(join.<BigDecimal>get("criteriaValue"), customer.getAnnualTurnover())
                )
        );
    }
}
