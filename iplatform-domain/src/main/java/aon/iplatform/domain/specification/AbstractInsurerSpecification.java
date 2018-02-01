package aon.iplatform.domain.specification;

import aon.iplatform.domain.model.insurer.CriteriaCode;
import aon.iplatform.domain.model.insurer.ExclusionCriteria;

import java.util.Optional;
import java.util.Set;

/**
 *
 */
public abstract class AbstractInsurerSpecification implements InsurerSpecification {
    public InsurerSpecification and(InsurerSpecification other) {
        return new AndSpecification(this, other);
    }

    public InsurerSpecification or(InsurerSpecification other) {
        return new OrSpecification(this, other);
    }

    protected ExclusionCriteria filter(Set<ExclusionCriteria> exclusionCriterias,
                                       CriteriaCode criteriaCode) {

        Optional<ExclusionCriteria> ec = exclusionCriterias
                .stream()
                .filter(e -> e.getCriteriaCode() == criteriaCode)
                .findFirst();

        if (ec.isPresent()) return ec.get();
        return null;
    }
}
