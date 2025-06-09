package behavioral_patterns.interpreter;

import java.util.Map;

/**
 * TerminalExpression Class: Represents a terminal symbol in the grammar.
 * In this case, a number.
 * Its interpret() method returns the number itself.
 */
public class NumberExpression implements Expression {
    private int number;

    /**
     * Constructor for NumberExpression.
     * @param number The integer value this expression represents.
     */
    public NumberExpression(int number) {
        this.number = number;
        System.out.println("NumberExpression created with value: " + number);
    }

    /**
     * Interprets the number expression.
     * For a number, interpretation means returning its own value.
     * The context is not used for simple numbers but is part of the interface.
     * @param context The context (e.g., variable values), unused here.
     * @return The integer value of this number.
     */
    @Override
    public int interpret(Map<String, Integer> context) {
        System.out.println("Interpreting NumberExpression: " + number);
        return number;
    }
}
