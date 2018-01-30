package au.com.aon.domain.specification;

import au.com.aon.domain.service.Customer;
import au.com.aon.domain.model.ExclusionCode;
import au.com.aon.domain.model.ExclusionSpecification;
import au.com.aon.domain.model.Insurer;

import java.util.Arrays;


public class PostcodeSpecification extends AbstractInsurerSpecification {
    public boolean isSatisfiedBy(Insurer insurer, Customer customer) {
        ExclusionSpecification specification =
                resolveExclusionSpecification(insurer.getExclusionSpecifications(), ExclusionCode.POST_CODES);
        if (specification != null) {
            return Arrays.asList(specification.getValue().split(",")).contains(customer.getPostcode());
        }
        return true;
    }
}
