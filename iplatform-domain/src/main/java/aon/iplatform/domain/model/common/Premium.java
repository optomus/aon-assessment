package aon.iplatform.domain.model.common;

import java.math.BigDecimal;

/**
 *
 */
public class Premium {
    private BigDecimal annual;
    private BigDecimal monthly;
    private BigDecimal monthBy4;
    private BigDecimal weekly;

    public BigDecimal getAnnual() {
        return annual;
    }

    public void setAnnual(BigDecimal annual) {
        this.annual = annual;
    }

    public BigDecimal getMonthly() {
        return monthly;
    }

    public void setMonthly(BigDecimal monthly) {
        this.monthly = monthly;
    }

    public BigDecimal getMonthBy4() {
        return monthBy4;
    }

    public void setMonthBy4(BigDecimal monthBy4) {
        this.monthBy4 = monthBy4;
    }

    public BigDecimal getWeekly() {
        return weekly;
    }

    public void setWeekly(BigDecimal weekly) {
        this.weekly = weekly;
    }
}
