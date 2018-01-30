package au.com.aon.domain.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 *
 */
@Entity
public class ExclusionSpecification {

    @Column(name = "exclusion_code")
    private ExclusionCode exclusionCode;

    @Column(name = "exclusion_value")
    private String value;

    @ManyToOne
    @JoinColumn(name = "insurer_name")
    private Insurer insurer;

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public ExclusionCode getExclusionCode() {
        return exclusionCode;
    }

    public void setExclusionCode(ExclusionCode exclusionCode) {
        this.exclusionCode = exclusionCode;
    }
}
