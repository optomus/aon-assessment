package au.com.aon.domain.service;

import au.com.aon.domain.model.Insurer;

/**
 *
 */
public interface PremiumCompService {
    Premium getPremium(Insurer insurer, Customer customer);

}
