package structural_patterns.decorator;

/**
 * Demo Class: To demonstrate the use of the Decorator pattern.
 * It shows how to wrap a ConcreteComponent (SimpleCoffee) with one or more
 * ConcreteDecorators (MilkDecorator, SugarDecorator) to add responsibilities dynamically.
 */
public class DecoratorDemo {
    public static void main(String[] args) {
        System.out.println("--- Decorator Pattern Demo: Coffee Shop ---");

        // Order 1: A simple coffee, no additions
        System.out.println("\nOrder 1: Simple Coffee");
        Coffee simpleCoffee = new SimpleCoffee();
        System.out.println("Description: " + simpleCoffee.getDescription());
        System.out.println("Cost: $" + String.format("%.2f", simpleCoffee.getCost()));

        // Order 2: A simple coffee with milk
        System.out.println("\nOrder 2: Simple Coffee with Milk");
        Coffee coffeeWithMilk = new SimpleCoffee(); // Start with a simple coffee
        coffeeWithMilk = new MilkDecorator(coffeeWithMilk); // Wrap it with MilkDecorator
        System.out.println("Description: " + coffeeWithMilk.getDescription());
        System.out.println("Cost: $" + String.format("%.2f", coffeeWithMilk.getCost()));

        // Order 3: A simple coffee with milk and sugar
        // Note the order of wrapping: SimpleCoffee -> Milk -> Sugar
        System.out.println("\nOrder 3: Simple Coffee with Milk and Sugar");
        Coffee coffeeWithMilkAndSugar = new SimpleCoffee();
        coffeeWithMilkAndSugar = new MilkDecorator(coffeeWithMilkAndSugar);
        coffeeWithMilkAndSugar = new SugarDecorator(coffeeWithMilkAndSugar); // Wrap the milk coffee with Sugar
        System.out.println("Description: " + coffeeWithMilkAndSugar.getDescription());
        System.out.println("Cost: $" + String.format("%.2f", coffeeWithMilkAndSugar.getCost()));

        // Order 4: A simple coffee with double milk and sugar
        // Demonstrates stacking decorators of the same type (if meaningful) or multiple different ones.
        System.out.println("\nOrder 4: Simple Coffee with Double Milk and Sugar");
        Coffee fancyCoffee = new SimpleCoffee();
        fancyCoffee = new MilkDecorator(fancyCoffee);    // First milk
        fancyCoffee = new MilkDecorator(fancyCoffee);    // Second milk
        fancyCoffee = new SugarDecorator(fancyCoffee);   // Then sugar
        System.out.println("Description: " + fancyCoffee.getDescription());
        System.out.println("Cost: $" + String.format("%.2f", fancyCoffee.getCost()));

        // Order 5: A simple coffee with only sugar
        System.out.println("\nOrder 5: Simple Coffee with Sugar");
        Coffee coffeeWithSugar = new SimpleCoffee();
        coffeeWithSugar = new SugarDecorator(coffeeWithSugar);
        System.out.println("Description: " + coffeeWithSugar.getDescription());
        System.out.println("Cost: $" + String.format("%.2f", coffeeWithSugar.getCost()));


        System.out.println("\n--- Decorator Pattern Demo Finished ---");
    }
}
