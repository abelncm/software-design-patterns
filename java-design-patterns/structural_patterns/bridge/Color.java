package structural_patterns.bridge;

/**
 * Implementor Interface: Defines the interface for implementation classes.
 * This interface decouples the Abstraction from the concrete implementation.
 * In this example, it defines how a color is applied.
 */
public interface Color {
    /**
     * Applies this color.
     * @return A string describing the color being applied.
     */
    String applyColor();
}
