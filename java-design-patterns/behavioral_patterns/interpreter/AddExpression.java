package behavioral_patterns.interpreter;

import java.util.Map;

/**
 * NonTerminalExpression Class: Represents an operation (addition) in the grammar.
 * It combines other expressions (left and right operands).
 * Its interpret() method calls interpret() on its operands and then performs addition.
 */
public class AddExpression implements Expression {
    private Expression leftOperand;
    private Expression rightOperand;

    /**
     * Constructor for AddExpression.
     * @param leftOperand The left operand expression.
     * @param rightOperand The right operand expression.
     */
    public AddExpression(Expression leftOperand, Expression rightOperand) {
        if (leftOperand == null || rightOperand == null) {
            throw new IllegalArgumentException("Operands for AddExpression cannot be null.");
        }
        this.leftOperand = leftOperand;
        this.rightOperand = rightOperand;
        System.out.println("AddExpression created with left: " + leftOperand.getClass().getSimpleName() +
                           ", right: " + rightOperand.getClass().getSimpleName());
    }

    /**
     * Interprets the addition expression.
     * It recursively interprets its left and right operands and returns their sum.
     * @param context The context (e.g., variable values).
     * @return The result of the addition.
     */
    @Override
    public int interpret(Map<String, Integer> context) {
        System.out.println("Interpreting AddExpression:");
        int leftValue = leftOperand.interpret(context);
        int rightValue = rightOperand.interpret(context);
        int result = leftValue + rightValue;
        System.out.println("AddExpression result: " + leftValue + " + " + rightValue + " = " + result);
        return result;
    }
}
