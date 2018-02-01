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
public class PostcodeExclusionSpecificationTest {

    private PostcodeExclusionSpecification specification = new PostcodeExclusionSpecification();

    @Test
    public void testIsSatisfiedBy() {

        Insurer insurer = new Insurer();
        insurer.setExclusionCriterias(new HashSet<>());
        ExclusionCriteria exclusionCriteria = new ExclusionCriteria();
        exclusionCriteria.setCriteriaCode(CriteriaCode.POST_CODES);
        exclusionCriteria.setCriteriaValue("2000, 2001");
        insurer.getExclusionCriterias().add(exclusionCriteria);

        Customer customer = new Customer();
        customer.setPostcode("2112");
        Assert.assertFalse(specification.isSatisfiedBy(insurer, customer));

        customer.setPostcode("2001");
        Assert.assertTrue(specification.isSatisfiedBy(insurer, customer));

    }
}
