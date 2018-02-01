package aon.iplatform.domain.specification;

import aon.iplatform.domain.model.common.Customer;
import aon.iplatform.domain.model.insurer.CriteriaCode;
import aon.iplatform.domain.model.insurer.ExclusionCriteria;
import aon.iplatform.domain.model.insurer.Insurer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.criteria.*;


public class OccupationSpecification extends AbstractInsurerSpecification {
    public static final Logger logger = LoggerFactory.getLogger(OccupationSpecification.class);

    @Override
    public Predicate build(Root<Insurer> insurer, Customer customer, CriteriaBuilder cb) {
        Join<ExclusionCriteria, Customer> join = insurer.join("exclusionCriterias", JoinType.LEFT);
        join.on(
                cb.equal(join.get("criteriaCode"), CriteriaCode.OCCUPATIONS)
        );

        return cb.and(
                cb.isNotNull(join.get("criteriaValue")),
                cb.like(cb.upper(join.<String>get("criteriaValue")), "%" + customer.getOccupation().toUpperCase() + "%").not()
        );
    }

    @Override
    public boolean isSatisfiedBy(Insurer insurer, Customer customer) {
        ExclusionCriteria exclusionCriteria = filter(insurer.getExclusionCriterias(), CriteriaCode.OCCUPATIONS);
        boolean satisfied = false;
        if (exclusionCriteria != null) {
            satisfied = exclusionCriteria.getCriteriaValue().toUpperCase().contains(customer.getOccupation().toUpperCase());
        }

        logger.info("Customer occupation {} {} by insurer {} occupation {}",
                customer.getOccupation(),
                satisfied ? "satisfied" : "not satisfied",
                insurer.getName(),
                exclusionCriteria == null ? "null" : exclusionCriteria.getCriteriaValue());

        return satisfied;
    }
}
