package aon.iplatform.domain.specification;


import aon.iplatform.domain.model.common.Customer;
import aon.iplatform.domain.model.insurer.CriteriaCode;
import aon.iplatform.domain.model.insurer.ExclusionCriteria;
import aon.iplatform.domain.model.insurer.Insurer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.math.BigDecimal;

public class MinimumTurnoverSpecification extends AbstractInsurerSpecification {

    public static final Logger logger = LoggerFactory.getLogger(MinimumTurnoverSpecification.class);

    @Override
    public Predicate build(Root<Insurer> insurer, Customer customer, CriteriaBuilder cb) {
        Join<ExclusionCriteria, Customer> join = insurer.join("exclusionCriterias");
        join.on(
                cb.equal(join.get("criteriaCode"), CriteriaCode.MIN_TURNOVER)
        );
        return cb.and(
                cb.isNotNull(join.get("criteriaValue")),
                cb.lessThan(cb.toBigDecimal(join.get("criteriaValue")), customer.getAnnualTurnover())
        );
    }

    @Override
    public boolean isSatisfiedBy(Insurer insurer, Customer customer) {
        ExclusionCriteria exclusionCriteria = filter(insurer.getExclusionCriterias(), CriteriaCode.MIN_TURNOVER);
        boolean satisfied = false;
        if (exclusionCriteria != null) {
            satisfied = customer.getAnnualTurnover().compareTo(new BigDecimal(exclusionCriteria.getCriteriaValue())) == -1;
        }

        logger.info("Customer turnover {} {} by insurer {} turnover {}",
                customer.getAnnualTurnover(),
                satisfied ? "satisfied" : "not satisfied",
                insurer.getName(),
                exclusionCriteria == null ? "null" : exclusionCriteria.getCriteriaValue());

        return satisfied;
    }
}
