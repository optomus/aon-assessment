package au.com.aon.domain.specification;

import au.com.aon.domain.service.Customer;
import au.com.aon.domain.model.Insurer;

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

    public boolean isSatisfiedBy(Insurer insurer, Customer customer) {
        return one.isSatisfiedBy(insurer, customer) || two.isSatisfiedBy(insurer, customer);
    }
}
