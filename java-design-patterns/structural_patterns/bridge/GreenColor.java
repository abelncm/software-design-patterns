package structural_patterns.bridge;

/**
 * ConcreteImplementor B: Implements the Color interface for Green.
 * (Changed from Blue to Green for variety from a common example).
 */
public class GreenColor implements Color {
    @Override
    public String applyColor() {
        return "Green";
    }
}
