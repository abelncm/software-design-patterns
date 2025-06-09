package behavioral_patterns.interpreter;

import java.util.HashMap; // For context, though not heavily used in this simple example
import java.util.Map;

/**
 * Client Class (Demo): Builds the Abstract Syntax Tree (AST)
 * and then calls interpret() on its root to evaluate the expression.
 * For this simple example, the AST is built manually. A more complex
 * scenario would involve a parser to generate the AST from an input string.
 */
public class InterpreterDemo {
    public static void main(String[] args) {
        System.out.println("--- Interpreter Pattern Demo: Simple Arithmetic ---");

        // The context is not strictly needed here as we are not using variables.
        // If we had variables like "x + 5", context would store {"x": some_value}.
        Map<String, Integer> context = new HashMap<>();

        // Manually building an AST for an expression: "10 + (5 - 2)"
        // Equivalent to: 10 + 3 = 13

        System.out.println("\nBuilding AST for expression: 10 + (5 - 2)");
        // Innermost expression: (5 - 2)
        Expression five = new NumberExpression(5);
        Expression two = new NumberExpression(2);
        Expression fiveMinusTwo = new SubtractExpression(five, two);
        System.out.println("AST for (5 - 2) created.");

        // Outer expression: 10 + (result of fiveMinusTwo)
        Expression ten = new NumberExpression(10);
        Expression finalExpression = new AddExpression(ten, fiveMinusTwo);
        System.out.println("AST for 10 + (5 - 2) created.");

        System.out.println("\n--- Interpreting the expression '10 + (5 - 2)' ---");
        int result = finalExpression.interpret(context);
        System.out.println("Final Result of '10 + (5 - 2)': " + result);

        System.out.println("\n--------------------------------------------------");

        // Another example: "100 - (20 + (50 - 10))"
        // 100 - (20 + 40) = 100 - 60 = 40
        System.out.println("\nBuilding AST for expression: 100 - (20 + (50 - 10))");
        Expression num100 = new NumberExpression(100);
        Expression num50 = new NumberExpression(50);
        Expression num10 = new NumberExpression(10);
        Expression num20 = new NumberExpression(20);

        Expression fiftyMinusTen = new SubtractExpression(num50, num10); // 50 - 10 = 40
        Expression twentyPlusResult = new AddExpression(num20, fiftyMinusTen); // 20 + 40 = 60
        Expression finalExpression2 = new SubtractExpression(num100, twentyPlusResult); // 100 - 60 = 40
        System.out.println("AST for 100 - (20 + (50 - 10)) created.");

        System.out.println("\n--- Interpreting the expression '100 - (20 + (50 - 10))' ---");
        int result2 = finalExpression2.interpret(context);
        System.out.println("Final Result of '100 - (20 + (50 - 10))': " + result2);

        System.out.println("\n--- Interpreter Pattern Demo Finished ---");
    }
}
