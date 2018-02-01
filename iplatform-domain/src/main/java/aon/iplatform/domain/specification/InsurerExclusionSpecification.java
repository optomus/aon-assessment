package aon.iplatform.domain.specification;

import aon.iplatform.domain.model.common.Customer;
import aon.iplatform.domain.model.insurer.Insurer;

/**
 *
 */
public interface InsurerExclusionSpecification {
    boolean isSatisfiedBy(Insurer insurer, Customer customer);

    InsurerExclusionSpecification and(InsurerExclusionSpecification other);

    InsurerExclusionSpecification or(InsurerExclusionSpecification other);
}
