package au.com.aon.domain.specification;

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
}
