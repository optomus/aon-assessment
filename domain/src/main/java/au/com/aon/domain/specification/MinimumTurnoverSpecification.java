package au.com.aon.domain.specification;


import au.com.aon.domain.service.Customer;
import au.com.aon.domain.model.ExclusionCode;
import au.com.aon.domain.model.ExclusionSpecification;
import au.com.aon.domain.model.Insurer;

import java.math.BigDecimal;

import static au.com.aon.domain.Utils.isGreater;

public class MinimumTurnoverSpecification extends AbstractInsurerSpecification {
    public boolean isSatisfiedBy(Insurer insurer, Customer customer) {
        ExclusionSpecification specification = resolveExclusionSpecification(insurer.getExclusionSpecifications(), ExclusionCode.MIN_TURNOVER);
        if (specification != null) {
            return isGreater(customer.getAnnualTurnover(), new BigDecimal(specification.getValue()));
        }
        return true;
    }
}
