package au.com.aon.domain.service;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

/**
 *
 */
public class Customer {
    @NotNull
    private String postcode;

    @NotNull
    private String occupation;

    @NotNull
    private BigDecimal annualTurnover;

    public String getPostcode() {
        return postcode;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }

    public String getOccupation() {
        return occupation;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }

    public BigDecimal getAnnualTurnover() {
        return annualTurnover;
    }

    public void setAnnualTurnover(BigDecimal annualTurnover) {
        this.annualTurnover = annualTurnover;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Customer customer = (Customer) o;

        if (!postcode.equals(customer.postcode)) return false;
        if (!occupation.equals(customer.occupation)) return false;
        return annualTurnover.equals(customer.annualTurnover);

    }

    @Override
    public int hashCode() {
        int result = postcode.hashCode();
        result = 31 * result + occupation.hashCode();
        result = 31 * result + annualTurnover.hashCode();
        return result;
    }
}
