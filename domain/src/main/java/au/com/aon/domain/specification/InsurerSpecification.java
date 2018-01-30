package au.com.aon.domain.specification;

import au.com.aon.domain.service.Customer;
import au.com.aon.domain.model.Insurer;

/**
 *
 */
public interface InsurerSpecification {
    boolean isSatisfiedBy(Insurer insurer, Customer customer);

    InsurerSpecification and(InsurerSpecification other);

    InsurerSpecification or(InsurerSpecification other);
}
