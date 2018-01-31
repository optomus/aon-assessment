package au.com.aon.domain.service;

import au.com.aon.domain.model.Insurer;

/**
 * Created by pnavaratnam on 30/01/2018.
 */
public class Quote {
    private Insurer insurer;
    private Premium premium;

    public Insurer getInsurer() {
        return insurer;
    }

    public void setInsurer(Insurer insurer) {
        this.insurer = insurer;
    }

    public Premium getPremium() {
        return premium;
    }

    public void setPremium(Premium premium) {
        this.premium = premium;
    }
}