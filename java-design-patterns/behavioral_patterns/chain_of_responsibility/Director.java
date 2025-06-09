package behavioral_patterns.chain_of_responsibility;

/**
 * ConcreteHandler 2: Director
 * Can approve purchases up to a higher limit than a Manager.
 */
public class Director extends Approver {
    private static final double APPROVAL_LIMIT = 5000.00;

    public Director(String name) {
        super(name);
    }

    @Override
    public void processRequest(PurchaseRequest request) {
        System.out.println(approverName + " (Director) is processing purchase request #" + request.getNumber() + " for $" + String.format("%.2f", request.getAmount()));
        if (request.getAmount() <= APPROVAL_LIMIT) {
            System.out.println(approverName + " (Director) approved purchase request #" + request.getNumber() +
                               " for amount $" + String.format("%.2f", request.getAmount()) + " for '" + request.getPurpose() + "'.");
            request.setApproved(true);
            request.setApprovedBy(approverName);
        } else {
            passToNext(request);
        }
    }
}
