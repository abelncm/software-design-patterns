package behavioral_patterns.chain_of_responsibility;

/**
 * ConcreteHandler 1: Manager
 * Can approve purchases up to a certain limit. If the amount is larger,
 * it passes the request to the next approver in the chain.
 */
public class Manager extends Approver {
    private static final double APPROVAL_LIMIT = 500.00;

    public Manager(String name) {
        super(name);
    }

    @Override
    public void processRequest(PurchaseRequest request) {
        System.out.println(approverName + " (Manager) is processing purchase request #" + request.getNumber() + " for $" + String.format("%.2f", request.getAmount()));
        if (request.getAmount() <= APPROVAL_LIMIT) {
            System.out.println(approverName + " (Manager) approved purchase request #" + request.getNumber() +
                               " for amount $" + String.format("%.2f", request.getAmount()) + " for '" + request.getPurpose() + "'.");
            request.setApproved(true);
            request.setApprovedBy(approverName);
        } else {
            // If manager cannot approve, pass it to the next approver
            passToNext(request);
        }
    }
}
