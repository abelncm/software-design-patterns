package behavioral_patterns.chain_of_responsibility;

/**
 * Request Class: Encapsulates the data for the request.
 * In this example, a purchase request with an amount and purpose.
 */
public class PurchaseRequest {
    private final int number;
    private final double amount;
    private final String purpose;
    private boolean isApproved = false; // To track approval status
    private String approvedBy = null;   // To track who approved it

    public PurchaseRequest(int number, double amount, String purpose) {
        this.number = number;
        this.amount = amount;
        this.purpose = purpose;
    }

    public int getNumber() {
        return number;
    }

    public double getAmount() {
        return amount;
    }

    public String getPurpose() {
        return purpose;
    }

    public boolean isApproved() {
        return isApproved;
    }

    public void setApproved(boolean approved) {
        isApproved = approved;
    }

    public String getApprovedBy() {
        return approvedBy;
    }

    public void setApprovedBy(String approvedBy) {
        this.approvedBy = approvedBy;
    }

    @Override
    public String toString() {
        return "PurchaseRequest{" +
               "number=" + number +
               ", amount=" + String.format("%.2f", amount) +
               ", purpose='" + purpose + '\'' +
               (isApproved ? ", approvedBy='" + approvedBy + '\'' : ", status=Pending") +
               '}';
    }
}
