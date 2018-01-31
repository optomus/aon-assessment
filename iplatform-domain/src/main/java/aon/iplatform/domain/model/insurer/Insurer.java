package aon.iplatform.domain.model.insurer;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModel;

import javax.persistence.*;
import java.util.Set;

/**
 *
 */
@Entity
@Table(name = "insurer")
@ApiModel(value="Insurer", description="Insurer")
public class Insurer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    @JsonIgnore
    private Long id;

    @Column(name = "insurer_name")
    private String name;

    @JsonIgnore
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
