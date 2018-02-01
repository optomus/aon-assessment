package aon.iplatform.service.domain;

import aon.iplatform.domain.model.common.Customer;
import aon.iplatform.domain.model.insurer.Insurer;
import aon.iplatform.domain.repository.InsurerRepository;
import aon.iplatform.domain.specification.InsurerSpecification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 *
 */
@Service
public class InsurerCompServiceImpl implements InsurerCompService {

    @Autowired
    private InsurerRepository insurerRepository;

    public List<Insurer> getInsurers(Customer customer, InsurerSpecification insurerSpecification) {
        return insurerRepository.getSatisfiedInsurers(customer, insurerSpecification);
    }

    @Override
    public List<Insurer> getInsurers() {
        return insurerRepository.getInsurers();
    }
}
