package au.com.aon.domain.service;

import au.com.aon.domain.model.Insurer;
import au.com.aon.domain.specification.InsurerSpecification;

import java.util.List;

/**
 *
 */
public class InsurerCompServiceImpl implements InsurerCompService {

    private InsurerRepository insurerRepository;

    public List<Insurer> getInsurers(InsurerSpecification insurerSpecification) {
        return insurerRepository.getSatisfiedInsurers(insurerSpecification);
    }
}
