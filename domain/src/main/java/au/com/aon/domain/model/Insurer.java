package au.com.aon.domain.model;

import java.util.List;

/**
 *
 */
public class Insurer {
    private String name;
    private List<ExclusionSpecification> exclusionSpecifications;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<ExclusionSpecification> getExclusionSpecifications() {
        return exclusionSpecifications;
    }

    public void setExclusionSpecifications(List<ExclusionSpecification> exclusionSpecifications) {
        this.exclusionSpecifications = exclusionSpecifications;
    }
}
