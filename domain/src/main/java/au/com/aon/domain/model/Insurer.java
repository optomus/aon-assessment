package au.com.aon.domain.model;

import javax.persistence.*;
import java.util.Set;

/**
 *
 */
@Entity
public class Insurer {

    @Id
    @Column(name = "insurer_name")
    private String name;

    @OneToMany(mappedBy = "insurer", cascade = CascadeType.ALL)
    private Set<ExclusionCriteria> exclusionCriterias;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<ExclusionCriteria> getExclusionCriterias() {
        return exclusionCriterias;
    }

    public void setExclusionCriterias(Set<ExclusionCriteria> exclusionCriterias) {
        this.exclusionCriterias = exclusionCriterias;
    }
}
