package behavioral_patterns.interpreter;

import java.util.Map;

/**
 * NonTerminalExpression Class: Represents a subtraction operation in the grammar.
 * It combines other expressions (left and right operands).
 * Its interpret() method calls interpret() on its operands and then performs subtraction.
 */
public class SubtractExpression implements Expression {
    private Expression leftOperand;
    private Expression rightOperand;

    /**
     * Constructor for SubtractExpression.
     * @param leftOperand The left operand expression.
     * @param rightOperand The right operand expression.
     */
    public SubtractExpression(Expression leftOperand, Expression rightOperand) {
        if (leftOperand == null || rightOperand == null) {
            throw new IllegalArgumentException("Operands for SubtractExpression cannot be null.");
        }
        this.leftOperand = leftOperand;
        this.rightOperand = rightOperand;
        System.out.println("SubtractExpression created with left: " + leftOperand.getClass().getSimpleName() +
                           ", right: " + rightOperand.getClass().getSimpleName());
    }

    /**
     * Interprets the subtraction expression.
     * It recursively interprets its left and right operands and returns their difference.
     * @param context The context (e.g., variable values).
     * @return The result of the subtraction.
     */
    @Override
    public int interpret(Map<String, Integer> context) {
        System.out.println("Interpreting SubtractExpression:");
        int leftValue = leftOperand.interpret(context);
        int rightValue = rightOperand.interpret(context);
        int result = leftValue - rightValue;
        System.out.println("SubtractExpression result: " + leftValue + " - " + rightValue + " = " + result);
        return result;
    }
}
