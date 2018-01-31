package aon.iplatform.service.business;

import aon.iplatform.domain.model.common.Customer;
import aon.iplatform.domain.model.common.Quote;

import java.util.List;

/**
 *
 */
public interface InsuranceService {
    List<Quote> getQuotes(Customer customer);
}
