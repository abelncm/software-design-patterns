package behavioral_patterns.chain_of_responsibility;

/**
 * ConcreteHandler 3: VicePresident
 * Can approve purchases up to an even higher limit, or all requests passed to them.
 */
public class VicePresident extends Approver {
    // Vice President might have a very high limit or approve anything that reaches them.
    private static final double APPROVAL_LIMIT = 25000.00;

    public VicePresident(String name) {
        super(name);
    }

    @Override
    public void processRequest(PurchaseRequest request) {
        System.out.println(approverName + " (Vice President) is processing purchase request #" + request.getNumber() + " for $" + String.format("%.2f", request.getAmount()));
        if (request.getAmount() <= APPROVAL_LIMIT) {
            System.out.println(approverName + " (Vice President) approved purchase request #" + request.getNumber() +
                               " for amount $" + String.format("%.2f", request.getAmount()) + " for '" + request.getPurpose() + "'.");
            request.setApproved(true);
            request.setApprovedBy(approverName);
        } else {
            // If even the VP cannot approve (e.g., above their limit or policy),
            // this request goes unhandled by this chain.
            System.out.println("Purchase request #" + request.getNumber() + " for $" + String.format("%.2f", request.getAmount()) +
                               " requires special executive approval and cannot be handled by " + approverName + " (Vice President).");
            // No call to passToNext() if this is the end of this specific approval line,
            // or if nextApprover is null. The passToNext in Approver handles the null case.
            // For this example, we assume VP is the last one who might have a limit.
            // If VP is meant to approve *anything* that reaches them, the condition would be removed.
            passToNext(request); // This will print the "could not be approved" message if next is null.
        }
    }
}
