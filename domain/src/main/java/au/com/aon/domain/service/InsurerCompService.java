package au.com.aon.domain.service;

import au.com.aon.domain.model.Insurer;
import au.com.aon.domain.specification.InsurerSpecification;

import java.util.List;

/**
 *
 */
public interface InsurerCompService {
    List<Insurer> getInsurers(InsurerSpecification insurerSpecification);
}
