package au.com.aon.domain.model;

import javax.persistence.*;
import java.util.List;

/**
 *
 */
@Entity
public class Insurer {

    @Id
    @Column(name = "insurer_name")
    private String name;

    @OneToMany(mappedBy = "insurer", cascade = CascadeType.ALL)
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
