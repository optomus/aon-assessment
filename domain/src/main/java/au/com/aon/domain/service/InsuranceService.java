package au.com.aon.domain.service;

import java.util.List;

/**
 *
 */
public interface InsuranceService {
    public List<Quote> getQuotes(Customer customer);
}
