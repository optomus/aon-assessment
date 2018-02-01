package aon.iplatform.domain.repository;

import aon.iplatform.domain.model.common.Customer;
import aon.iplatform.domain.model.insurer.Insurer;
import aon.iplatform.domain.specification.InsurerSpecification;
import io.swagger.models.auth.In;

import java.util.List;

/**
 *
 */
public interface InsurerRepository {
    List<Insurer> getInsurers();
    List<Insurer> getSatisfiedInsurers(Customer customer, InsurerSpecification insurerSpecification);
}
