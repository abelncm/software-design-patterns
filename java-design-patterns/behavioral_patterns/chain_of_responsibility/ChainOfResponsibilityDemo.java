package behavioral_patterns.chain_of_responsibility;

/**
 * Client Class (Demo): Creates the chain of handlers (Approvers)
 * and then sends requests to the first handler in the chain.
 */
public class ChainOfResponsibilityDemo {

    public static void main(String[] args) {
        System.out.println("--- Chain of Responsibility Pattern Demo: Expense Approval ---");

        // Create the chain of approvers
        Approver manager = new Manager("Alice (Manager)");
        Approver director = new Director("Bob (Director)");
        Approver vp = new VicePresident("Charles (VP)");
        // Approver ceo = new CEO("Diana (CEO)"); // Example of extending the chain

        // Set up the chain: Manager -> Director -> VicePresident
        manager.setNextApprover(director);
        director.setNextApprover(vp);
        // vp.setNextApprover(ceo); // If CEO was part of the chain

        System.out.println("\nChain setup: Manager -> Director -> Vice President\n");

        // Create purchase requests
        PurchaseRequest request1 = new PurchaseRequest(101, 350.00, "Office Supplies");
        PurchaseRequest request2 = new PurchaseRequest(102, 4500.00, "New Laptop");
        PurchaseRequest request3 = new PurchaseRequest(103, 18000.00, "Marketing Campaign");
        PurchaseRequest request4 = new PurchaseRequest(104, 50000.00, "Cloud Services Contract Renewal");
        PurchaseRequest request5 = new PurchaseRequest(105, 499.99, "Team Lunch");


        // Process the requests by sending them to the first handler in the chain (manager)
        System.out.println("--- Processing Request 1 ---");
        manager.processRequest(request1);
        System.out.println(request1.toString() + "\n");

        System.out.println("--- Processing Request 2 ---");
        manager.processRequest(request2);
        System.out.println(request2.toString() + "\n");

        System.out.println("--- Processing Request 3 ---");
        manager.processRequest(request3);
        System.out.println(request3.toString() + "\n");

        System.out.println("--- Processing Request 4 ---");
        manager.processRequest(request4); // This should exceed VP's limit
        System.out.println(request4.toString() + "\n");

        System.out.println("--- Processing Request 5 ---");
        manager.processRequest(request5); // Manager should approve this
        System.out.println(request5.toString() + "\n");

        System.out.println("--- Chain of Responsibility Pattern Demo Finished ---");
    }
}
