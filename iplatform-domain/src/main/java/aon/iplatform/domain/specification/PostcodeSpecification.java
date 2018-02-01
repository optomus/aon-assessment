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


public class PostcodeSpecification extends AbstractInsurerSpecification {

    public static final Logger logger = LoggerFactory.getLogger(PostcodeSpecification.class);

    @Override
    public Predicate build(Root<Insurer> insurer, Customer customer, CriteriaBuilder cb) {
        Join<ExclusionCriteria, Customer> join = insurer.join("exclusionCriterias");
        join.on(
                cb.equal(join.get("criteriaCode"), CriteriaCode.POST_CODES)
        );

        return cb.and(
                cb.isNotNull(join.get("criteriaValue")),
                cb.like(cb.upper(join.<String>get("criteriaValue")), "%" + customer.getPostcode() + "%").not()
        );
    }

    @Override
    public boolean isSatisfiedBy(Insurer insurer, Customer customer) {
        ExclusionCriteria exclusionCriteria = filter(insurer.getExclusionCriterias(), CriteriaCode.POST_CODES);
        boolean satisfied = false;
        if (exclusionCriteria != null) {
            satisfied = exclusionCriteria.getCriteriaValue().contains(customer.getPostcode());
        }

        logger.info("Customer postcode {} {} by insurer {} postcode {}",
                customer.getPostcode(),
                satisfied ? "satisfied" : "not satisfied",
                insurer.getName(),
                exclusionCriteria == null ? "null" : exclusionCriteria.getCriteriaValue());

        return satisfied;
    }
}
