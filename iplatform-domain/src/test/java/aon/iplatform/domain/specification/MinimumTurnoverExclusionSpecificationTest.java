package aon.iplatform.domain.specification;

import aon.iplatform.domain.model.common.Customer;
import aon.iplatform.domain.model.insurer.CriteriaCode;
import aon.iplatform.domain.model.insurer.ExclusionCriteria;
import aon.iplatform.domain.model.insurer.Insurer;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.HashSet;

/**
 *
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class MinimumTurnoverExclusionSpecificationTest {

    private MinimumTurnoverExclusionSpecification minimumTurnoverExclusionSpecification = new MinimumTurnoverExclusionSpecification();

    @Test
    public void testIsSatisfiedBy() {

        Insurer insurer = new Insurer();
        insurer.setExclusionCriterias(new HashSet<>());
        ExclusionCriteria exclusionCriteria = new ExclusionCriteria();
        exclusionCriteria.setCriteriaCode(CriteriaCode.MIN_TURNOVER);
        exclusionCriteria.setCriteriaValue("400000");
        insurer.getExclusionCriterias().add(exclusionCriteria);

        Customer customer = new Customer();
        customer.setAnnualTurnover(new BigDecimal("500000"));
        Assert.assertFalse(minimumTurnoverExclusionSpecification.isSatisfiedBy(insurer, customer));

        customer.setAnnualTurnover(new BigDecimal("350000"));
        Assert.assertTrue(minimumTurnoverExclusionSpecification.isSatisfiedBy(insurer, customer));

    }
}
