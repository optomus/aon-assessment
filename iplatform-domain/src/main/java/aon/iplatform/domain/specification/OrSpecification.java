package aon.iplatform.domain.specification;


import aon.iplatform.domain.model.common.Customer;
import aon.iplatform.domain.model.insurer.Insurer;

/**
 *
 */
public class OrSpecification extends AbstractInsurerSpecification {
    private InsurerExclusionSpecification one;
    private InsurerExclusionSpecification two;

    public OrSpecification(InsurerExclusionSpecification one, InsurerExclusionSpecification two) {
        this.one = one;
        this.two = two;
    }

    @Override
    public boolean isSatisfiedBy(Insurer insurer, Customer customer) {
        return one.isSatisfiedBy(insurer, customer) | two.isSatisfiedBy(insurer, customer);
    }

}
