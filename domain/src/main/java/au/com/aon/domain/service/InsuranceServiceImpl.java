package au.com.aon.domain.service;

import au.com.aon.domain.model.Insurer;
import au.com.aon.domain.specification.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 *
 */
@Service
public class InsuranceServiceImpl implements InsuranceService {
    private InsurerRepository insurerRepository;
    private PremiumCompService premiumCompService;

    @Transactional
    public List<Quote> getQuotes(Customer customer) {
        InsurerSpecification insurerSpecification =
                new MinimumTurnoverSpecification()
                        .or(new AndSpecification(new PostcodeSpecification(), new OccupationSpecification()));

        List<Quote> quotes = new ArrayList<>();
        List<Insurer> insurers = insurerRepository.getSatisfiedInsurers(insurerSpecification);
        insurers.forEach(insurer -> {
            Quote quote = new Quote();
            quote.setInsurer(insurer);
            quote.setPremium(premiumCompService.getPremium(insurer, customer));
            quotes.add(quote);
        });

        return quotes;
    }
}
