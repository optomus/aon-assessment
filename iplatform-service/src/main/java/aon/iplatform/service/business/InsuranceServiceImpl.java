package aon.iplatform.service.business;

import aon.iplatform.domain.model.common.Customer;
import aon.iplatform.domain.model.common.Quote;
import aon.iplatform.domain.model.insurer.Insurer;
import aon.iplatform.domain.specification.*;
import aon.iplatform.service.domain.InsurerCompService;
import aon.iplatform.service.domain.PremiumCompService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 *
 */
@Service
public class InsuranceServiceImpl implements InsuranceService {

    @Autowired
    private InsurerCompService insurerCompService;

    @Autowired
    private PremiumCompService premiumCompService;

    @Transactional
    public List<Quote> getQuotes(Customer customer) {
        InsurerSpecification insurerSpecification =
                new MinimumTurnoverSpecification()
                        .or(new AndSpecification(new PostcodeSpecification(), new OccupationSpecification()));

        List<Quote> quotes = new ArrayList<>();
        List<Insurer> insurers = insurerCompService.getInsurers(customer, insurerSpecification);
        insurers.forEach(insurer -> {
            Quote quote = new Quote();
            quote.setInsurer(insurer);
            quote.setPremium(premiumCompService.getPremium(insurer, customer));
            quotes.add(quote);
        });

        return quotes;
    }
}
