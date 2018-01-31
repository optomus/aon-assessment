package au.com.aon.domain.model;

import javax.persistence.*;

/**
 *
 */
@Entity
public class ExclusionCriteria {

    @Column(name = "criteria_code")
    @Enumerated(EnumType.STRING)
    private CriteriaCode criteriaCode;

    @Column(name = "criteria_value")
    private String criteriaValue;

    @ManyToOne
    @JoinColumn(name = "insurer_name")
    private Insurer insurer;

    public String getCriteriaValue() {
        return criteriaValue;
    }

    public void setCriteriaValue(String criteriaValue) {
        this.criteriaValue = criteriaValue;
    }

    public CriteriaCode getCriteriaCode() {
        return criteriaCode;
    }

    public void setCriteriaCode(CriteriaCode criteriaCode) {
        this.criteriaCode = criteriaCode;
    }


}
