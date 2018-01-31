package aon.iplatform.domain.model.insurer;

import javax.persistence.*;

/**
 *
 */
@Entity
@Table(name = "exclusion_criteria")
public class ExclusionCriteria {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "criteria_code")
    @Enumerated(EnumType.STRING)
    private CriteriaCode criteriaCode;

    @Column(name = "criteria_value")
    private String criteriaValue;

    @ManyToOne
    @JoinColumn(name = "insurer_id")
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
