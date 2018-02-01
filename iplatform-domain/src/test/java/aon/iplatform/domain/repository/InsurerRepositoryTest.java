package aon.iplatform.domain.repository;

import aon.iplatform.domain.model.insurer.Insurer;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.AutoConfigureTestEntityManager;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

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
    public void testInsurers() {

        List<Insurer> insurers = insurerRepository.getInsurers();

        Assert.assertTrue("Test insurers", insurers.size() == 4);
    }


}
