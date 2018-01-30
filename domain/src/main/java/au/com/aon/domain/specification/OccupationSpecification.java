package au.com.aon.domain.specification;

import au.com.aon.domain.service.Customer;
import au.com.aon.domain.model.ExclusionCode;
import au.com.aon.domain.model.ExclusionSpecification;
import au.com.aon.domain.model.Insurer;

import java.util.Arrays;


public class OccupationSpecification extends AbstractInsurerSpecification {
    public boolean isSatisfiedBy(Insurer insurer, Customer customer) {
        ExclusionSpecification specification = resolveExclusionSpecification(insurer.getExclusionSpecifications(), ExclusionCode.OCCUPATIONS);
        if (specification != null) {
            return Arrays.asList(specification.getValue().split(",")).contains(customer.getOccupation());
        }
        return true;
    }
}
