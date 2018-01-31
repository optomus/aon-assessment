package aon.iplatform.service.domain;

import aon.iplatform.domain.model.common.Customer;
import aon.iplatform.domain.model.common.Premium;
import aon.iplatform.domain.model.insurer.Insurer;

/**
 *
 */
public interface PremiumCompService {
    Premium getPremium(Insurer insurer, Customer customer);

}
