package aon.iplatform.service.business;

import aon.iplatform.domain.model.common.Customer;
import aon.iplatform.domain.model.common.Quote;
import aon.iplatform.domain.model.insurer.Insurer;
import aon.iplatform.domain.specification.*;
import aon.iplatform.service.domain.InsurerDomainService;
import aon.iplatform.service.domain.PremiumDomainService;
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
    private InsurerDomainService insurerDomainService;

    @Autowired
    private PremiumDomainService premiumDomainService;

    @Transactional
    public List<Quote> getQuotes(Customer customer) {
        InsurerExclusionSpecification insurerExclusionSpecification = new OrSpecification(
                new AndSpecification(new PostcodeExclusionSpecification(), new OccupationExclusionSpecification()), new MinimumTurnoverExclusionSpecification());

        List<Insurer> insurers = insurerDomainService.getInsurers();
        insurers.removeIf(i -> insurerExclusionSpecification.isSatisfiedBy(i, customer));
        List<Quote> quotes = new ArrayList<>(insurers.size());

        insurers.forEach(insurer -> {
            Quote quote = new Quote();
            quote.setInsurer(insurer);
            quote.setPremium(premiumDomainService.getPremium(insurer, customer));
            quotes.add(quote);
        });

        return quotes;
    }
}
