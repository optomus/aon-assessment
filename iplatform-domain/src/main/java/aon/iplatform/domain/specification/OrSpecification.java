package aon.iplatform.domain.specification;


import aon.iplatform.domain.model.common.Customer;
import aon.iplatform.domain.model.insurer.Insurer;

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
    public boolean isSatisfiedBy(Insurer insurer, Customer customer) {
        return one.isSatisfiedBy(insurer, customer) | two.isSatisfiedBy(insurer, customer);
    }

    @Override
    public Predicate build(Root<Insurer> insurer, Customer customer, CriteriaBuilder cb) {
        return cb.or(
                one.build(insurer, customer, cb),
                two.build(insurer, customer, cb)
        );
    }
}
