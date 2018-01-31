package au.com.aon.test;

import au.com.aon.domain.model.Insurer;
import au.com.aon.domain.service.Customer;
import au.com.aon.domain.service.InsurerRepository;
import au.com.aon.domain.specification.MinimumTurnoverSpecification;
import au.com.aon.domain.specification.OccupationSpecification;
import au.com.aon.domain.specification.PostcodeSpecification;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.AutoConfigureTestEntityManager;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

/**
 *
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureTestEntityManager
public class InsurerRepositoryTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private InsurerRepository insurerRepository;

    @Test
    public void testGetSatisfiedInsurersForMinimumTurnoverSpecification() {

        Customer customer = new Customer();
        customer.setAnnualTurnover(BigDecimal.valueOf(300000));
        customer.setOccupation("Builder");
        customer.setPostcode("2112");
        List<Insurer> insurers = insurerRepository.getSatisfiedInsurers(customer, new MinimumTurnoverSpecification());

        Assert.assertTrue("Test insurers for PostcodeSpecification", insurers.stream().anyMatch(insurer ->
                Arrays.asList("Insurer1", "Insurer2", "Insurer3").contains(insurer.getName())
        ));
    }

    @Test
    public void testGetSatisfiedInsurersForOccupationSpecification() {

        Customer customer = new Customer();
        customer.setAnnualTurnover(BigDecimal.valueOf(420000));
        customer.setOccupation("Builder False");
        customer.setPostcode("2112");
        List<Insurer> insurers = insurerRepository.getSatisfiedInsurers(customer, new OccupationSpecification());
        Assert.assertTrue("Test insurers for PostcodeSpecification", insurers.stream().anyMatch(insurer ->
                Arrays.asList("Insurer1", "Insurer4").contains(insurer.getName())
        ));

        customer.setOccupation("PluMber");
        insurers = insurerRepository.getSatisfiedInsurers(customer, new OccupationSpecification());
        Assert.assertTrue("Test insurers for PostcodeSpecification", insurers.stream().anyMatch(insurer ->
                Arrays.asList("Insurer1", "Insurer3").contains(insurer.getName())
        ));
    }

    @Test
    public void testGetSatisfiedInsurersForPostcodeSpecification() {

        Customer customer = new Customer();
        customer.setAnnualTurnover(BigDecimal.valueOf(420000));
        customer.setOccupation("Builder False");
        customer.setPostcode("2112");
        List<Insurer> insurers = insurerRepository.getSatisfiedInsurers(customer, new PostcodeSpecification());
        Assert.assertTrue("Test insurers for PostcodeSpecification", insurers.stream().anyMatch(insurer ->
                Arrays.asList("Insurer1", "Insurer4").contains(insurer.getName())
        ));

        customer.setPostcode("2001");
        insurers = insurerRepository.getSatisfiedInsurers(customer, new PostcodeSpecification());

        Assert.assertTrue("Test insurers for PostcodeSpecification", insurers.stream().anyMatch(insurer ->
                Arrays.asList("Insurer1", "Insurer2").contains(insurer.getName())
        ));

    }

}
