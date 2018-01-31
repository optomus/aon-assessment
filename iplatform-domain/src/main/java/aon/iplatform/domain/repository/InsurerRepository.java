package aon.iplatform.domain.repository;

import aon.iplatform.domain.model.common.Customer;
import aon.iplatform.domain.model.insurer.Insurer;
import aon.iplatform.domain.specification.InsurerSpecification;

import java.util.List;

/**
 *
 */
public interface InsurerRepository {
    List<Insurer> getSatisfiedInsurers(Customer customer, InsurerSpecification insurerSpecification);
}
