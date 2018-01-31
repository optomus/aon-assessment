package au.com.aon.domain.service;

import au.com.aon.domain.model.Insurer;
import au.com.aon.domain.specification.InsurerSpecification;
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
}
