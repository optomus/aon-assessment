package aon.iplatform.service.domain;

import aon.iplatform.domain.model.common.Customer;
import aon.iplatform.domain.model.insurer.Insurer;
import aon.iplatform.domain.specification.InsurerSpecification;

import java.util.List;

/**
 *
 */
public interface InsurerCompService {
    List<Insurer> getInsurers(Customer customer, InsurerSpecification insurerSpecification);
}
