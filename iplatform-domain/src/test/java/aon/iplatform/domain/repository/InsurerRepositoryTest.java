package aon.iplatform.domain.repository;

import aon.iplatform.domain.model.common.Customer;
import aon.iplatform.domain.model.insurer.Insurer;
import aon.iplatform.domain.specification.*;
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

    @Test
    public void testGetSatisfiedInsurersForMinimumTurnoverSpecificationOrOccupationSpecificationAndPostcodeSpecification() {

        Customer customer = new Customer();
        customer.setAnnualTurnover(BigDecimal.valueOf(600000));
        customer.setOccupation("Builder");
        customer.setPostcode("2000");

        InsurerSpecification specification = new MinimumTurnoverSpecification().or(
                new AndSpecification(new OccupationSpecification(), new PostcodeSpecification()));

        List<Insurer> insurers = insurerRepository.getSatisfiedInsurers(customer, specification);
        Assert.assertTrue("Test insurers for Platform", insurers.stream().anyMatch(insurer ->
                Arrays.asList("Insurer1", "Insurer2", "Insurer3", "Insurer4").contains(insurer.getName())
        ));

        customer.setAnnualTurnover(BigDecimal.valueOf(100000));
        insurers = insurerRepository.getSatisfiedInsurers(customer, specification);
        Assert.assertTrue("Test insurers for Platform", insurers.stream().anyMatch(insurer ->
                Arrays.asList("Insurer1", "Insurer2").contains(insurer.getName())
        ));

        customer.setOccupation("Plumber");
        customer.setAnnualTurnover(BigDecimal.valueOf(600000));
        insurers = insurerRepository.getSatisfiedInsurers(customer, specification);
        Assert.assertTrue("Test insurers for Platform", insurers.stream().anyMatch(insurer ->
                Arrays.asList("Insurer1", "Insurer2", "Insurer4").contains(insurer.getName())
        ));


        customer.setPostcode("2001");
        customer.setOccupation("Butcher");
        customer.setAnnualTurnover(BigDecimal.valueOf(300000));
        insurers = insurerRepository.getSatisfiedInsurers(customer, specification);
        Assert.assertTrue("Test insurers for Platform", insurers.stream().anyMatch(insurer ->
                Arrays.asList("Insurer1", "Insurer3").contains(insurer.getName())
        ));

    }

}
