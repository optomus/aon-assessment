package au.com.aon.domain.model;

/**
 *
 */
public class ExclusionSpecification {
    private ExclusionCode exclusionCode;
    private String value;

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
