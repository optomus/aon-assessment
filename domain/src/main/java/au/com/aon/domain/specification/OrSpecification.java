package au.com.aon.domain.specification;

import au.com.aon.domain.model.Insurer;
import au.com.aon.domain.service.Customer;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

/**
 *
 */
public class OrSpecification extends AbstractInsurerSpecification {
    private InsurerSpecification one;
    private InsurerSpecification two;

    public OrSpecification(InsurerSpecification one, InsurerSpecification two) {
        this.one = one;
        this.two = two;
    }

    @Override
    public Predicate build(Root<Insurer> insurer, Customer customer, CriteriaBuilder cb) {
        return cb.or(
                one.build(insurer, customer, cb),
                two.build(insurer, customer, cb)
        );
    }
}
