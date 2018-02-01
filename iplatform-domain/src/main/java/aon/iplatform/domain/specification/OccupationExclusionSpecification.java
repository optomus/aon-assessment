package aon.iplatform.domain.specification;

import aon.iplatform.domain.model.common.Customer;
import aon.iplatform.domain.model.insurer.CriteriaCode;
import aon.iplatform.domain.model.insurer.ExclusionCriteria;
import aon.iplatform.domain.model.insurer.Insurer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class OccupationExclusionSpecification extends AbstractInsurerSpecification {
    public static final Logger logger = LoggerFactory.getLogger(OccupationExclusionSpecification.class);

    @Override
    public boolean isSatisfiedBy(Insurer insurer, Customer customer) {
        ExclusionCriteria exclusionCriteria = filter(insurer.getExclusionCriterias(), CriteriaCode.OCCUPATIONS);
        boolean satisfied = false;
        if (exclusionCriteria != null) {
            satisfied = exclusionCriteria.getCriteriaValue().toUpperCase().contains(customer.getOccupation().toUpperCase());
        }

        logger.info("Customer occupation {} {} by insurer {} occupation {}",
                customer.getOccupation(),
                satisfied ? "satisfied" : "not satisfied",
                insurer.getName(),
                exclusionCriteria == null ? "null" : exclusionCriteria.getCriteriaValue());

        return satisfied;
    }
}
