package aon.iplatform.domain.specification;


import aon.iplatform.domain.model.common.Customer;
import aon.iplatform.domain.model.insurer.CriteriaCode;
import aon.iplatform.domain.model.insurer.ExclusionCriteria;
import aon.iplatform.domain.model.insurer.Insurer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.math.BigDecimal;

public class MinimumTurnoverExclusionSpecification extends AbstractInsurerSpecification {

    public static final Logger logger = LoggerFactory.getLogger(MinimumTurnoverExclusionSpecification.class);


    @Override
    public boolean isSatisfiedBy(Insurer insurer, Customer customer) {
        ExclusionCriteria exclusionCriteria = filter(insurer.getExclusionCriterias(), CriteriaCode.MIN_TURNOVER);
        boolean satisfied = false;
        if (exclusionCriteria != null) {
            satisfied = customer.getAnnualTurnover().compareTo(new BigDecimal(exclusionCriteria.getCriteriaValue())) == -1;
        }

        logger.info("Customer turnover {} {} by insurer {} turnover {}",
                customer.getAnnualTurnover(),
                satisfied ? "satisfied" : "not satisfied",
                insurer.getName(),
                exclusionCriteria == null ? "null" : exclusionCriteria.getCriteriaValue());

        return satisfied;
    }
}
