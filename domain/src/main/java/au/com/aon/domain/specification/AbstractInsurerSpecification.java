package au.com.aon.domain.specification;

import au.com.aon.domain.model.ExclusionCode;
import au.com.aon.domain.model.ExclusionSpecification;

import java.util.List;

/**
 *
 */
public abstract class AbstractInsurerSpecification implements InsurerSpecification {
    ExclusionSpecification resolveExclusionSpecification(List<ExclusionSpecification> exclusionSpecifications,
                                                         ExclusionCode exclusionCode) {

        for (ExclusionSpecification exclusionSpecification : exclusionSpecifications) {
            if (exclusionCode == exclusionSpecification.getExclusionCode())
                return exclusionSpecification;
        }

        return null;
    }

    public InsurerSpecification and(InsurerSpecification other) {
        return new AndSpecification(this, other);
    }

    public InsurerSpecification or(InsurerSpecification other) {
        return new OrSpecification(this, other);
    }
}
