package au.com.aon.domain.service;

import au.com.aon.domain.model.Insurer;
import au.com.aon.domain.specification.*;

import java.util.ArrayList;
import java.util.List;

/**
 *
 */
public class InsuranceServiceImpl implements InsuranceService {
    private InsurerRepository insurerRepository;
    private PremiumCompService premiumCompService;

    // TODO: Transaction
    public List<Quote> getQuotes(Customer customer) {
        final List<Quote> quotes = new ArrayList<Quote>();

        InsurerSpecification insurerSpecification =
                new OrSpecification(
                        new MinimumTurnoverSpecification(),
                        new AndSpecification(new PostcodeSpecification(), new OccupationSpecification()));

        for (Insurer insurer : insurerRepository.getSatisfiedInsurers(insurerSpecification)) {
            Quote quote = new Quote();
            quote.setInsurer(insurer);
            quote.setPremium(premiumCompService.getPremium(insurer, customer));
            quotes.add(quote);
        }

        return quotes;
    }
}
