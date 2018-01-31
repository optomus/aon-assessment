package au.com.aon.domain.specification;

import au.com.aon.domain.model.Insurer;
import au.com.aon.domain.service.Customer;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

/**
 *
 */
public class AndSpecification extends AbstractInsurerSpecification {
    private InsurerSpecification one;
    private InsurerSpecification two;

    public AndSpecification(InsurerSpecification one, InsurerSpecification two) {
        this.one = one;
        this.two = two;
    }

    @Override
    public Predicate build(Root<Insurer> insurer, Customer customer, CriteriaBuilder cb) {
        return cb.and(
                one.build(insurer, customer, cb),
                two.build(insurer, customer, cb)
        );
    }

}
