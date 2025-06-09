package behavioral_patterns.interpreter;

import java.util.Map; // For context if needed, though this example might simplify context

/**
 * AbstractExpression Interface: Declares an interpret() method that all
 * concrete expressions (Terminal and NonTerminal) must implement.
 * The context (e.g., variable values) is passed to the interpret method.
 */
public interface Expression {
    /**
     * Interprets the expression within a given context.
     * For simple arithmetic, context might not be strictly needed if no variables.
     * If variables were involved, context would map variable names to their values.
     *
     * @param context A map containing variable names and their values (if any).
     *                For this example, we'll make it optional or unused for simple numbers.
     * @return The result of the interpretation.
     */
    int interpret(Map<String, Integer> context);
}
