package behavioral_patterns.chain_of_responsibility;

/**
 * Handler Abstract Class: Declares a method to handle requests and
 * holds a reference to the next handler in the chain.
 */
public abstract class Approver {
    protected Approver nextApprover; // The next object in the chain of responsibility
    protected String approverName;

    public Approver(String name) {
        this.approverName = name;
    }

    /**
     * Sets the next approver in the chain.
     * @param nextApprover The next approver.
     */
    public void setNextApprover(Approver nextApprover) {
        this.nextApprover = nextApprover;
    }

    /**
     * Processes the purchase request.
     * This method will be implemented by concrete handlers.
     * @param request The purchase request to be processed.
     */
    public abstract void processRequest(PurchaseRequest request);

    /**
     * Helper method to pass the request to the next approver if one exists.
     * If not, it means the request cannot be handled by the current chain setup
     * beyond the current approver's capability.
     * @param request The purchase request.
     */
    protected void passToNext(PurchaseRequest request) {
        if (nextApprover != null) {
            System.out.println(approverName + " cannot approve $" + String.format("%.2f",request.getAmount()) + ". Passing to " + nextApprover.approverName + ".");
            nextApprover.processRequest(request);
        } else {
            System.out.println("Request for $" + String.format("%.2f",request.getAmount()) + " could not be approved by anyone in the chain. " +
                               approverName + " was the last approver or no further chain set.");
            // Optionally, mark request as unapproved explicitly if needed.
            // request.setApproved(false); // Though it's already false by default
        }
    }
}
