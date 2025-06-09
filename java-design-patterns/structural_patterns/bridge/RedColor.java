package structural_patterns.bridge;

/**
 * ConcreteImplementor A: Implements the Color interface for Red.
 */
public class RedColor implements Color {
    @Override
    public String applyColor() {
        return "Red";
    }
}
