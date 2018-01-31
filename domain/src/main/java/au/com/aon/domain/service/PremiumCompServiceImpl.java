package au.com.aon.domain.service;

import au.com.aon.domain.model.Insurer;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

/**
 *
 */
@Service
public class PremiumCompServiceImpl implements PremiumCompService {
    public Premium getPremium(Insurer insurer, Customer customer) {
        Premium premium = new Premium();
        premium.setAnnual(BigDecimal.valueOf(1200.00));
        premium.setMonthly(BigDecimal.valueOf(100.00));
        premium.setWeekly(BigDecimal.valueOf(25.00));
        premium.setMonthBy4(BigDecimal.valueOf(50.00));
        return premium;
    }
}
