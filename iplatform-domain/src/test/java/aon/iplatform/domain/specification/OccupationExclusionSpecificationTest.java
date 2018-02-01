package aon.iplatform.domain.specification;

import aon.iplatform.domain.model.common.Customer;
import aon.iplatform.domain.model.insurer.CriteriaCode;
import aon.iplatform.domain.model.insurer.ExclusionCriteria;
import aon.iplatform.domain.model.insurer.Insurer;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashSet;

/**
 *
 */
@RunWith(SpringRunner.class)
public class OccupationExclusionSpecificationTest {

    private OccupationExclusionSpecification specification = new OccupationExclusionSpecification();

    @Test
    public void testIsSatisfiedBy() {

        Insurer insurer = new Insurer();
        insurer.setExclusionCriterias(new HashSet<>());
        ExclusionCriteria exclusionCriteria = new ExclusionCriteria();
        exclusionCriteria.setCriteriaCode(CriteriaCode.OCCUPATIONS);
        exclusionCriteria.setCriteriaValue("Butcher, Plumber");
        insurer.getExclusionCriterias().add(exclusionCriteria);

        Customer customer = new Customer();
        customer.setOccupation("Hair Dresser");
        Assert.assertFalse(specification.isSatisfiedBy(insurer, customer));

        customer.setOccupation("Plumber");
        Assert.assertTrue(specification.isSatisfiedBy(insurer, customer));

    }
}
