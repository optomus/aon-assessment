package au.com.aon.domain.specification;

import au.com.aon.domain.model.ExclusionCriteria;
import au.com.aon.domain.model.CriteriaCode;
import au.com.aon.domain.model.Insurer;
import au.com.aon.domain.service.Customer;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;


public class PostcodeSpecification extends AbstractInsurerSpecification {

    @Override
    public Predicate build(Root<Insurer> insurer, Customer customer, CriteriaBuilder cb) {
        Join<ExclusionCriteria, Customer> join = insurer.join("exclusions");
        join.on(
                cb.and(
                        cb.equal(join.get("exclusionCode"), CriteriaCode.POST_CODES)
                )
        );

        return cb.and(
                cb.isNotNull(join.get("value")),
                cb.like(join.<String>get("value"), customer.getPostcode())
        );
    }
}
