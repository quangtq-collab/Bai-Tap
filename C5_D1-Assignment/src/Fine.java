public class Fine implements Fineable {
    private String fineId;
    private String readerId;
    private double fineAmount;

    public Fine(String fineId, String readerId) {
        this.fineId = fineId;
        this.readerId = readerId;
        this.fineAmount = 0.0;
    }

    @Override
    public void issueFine(double amount, String reason) {
        this.fineAmount += amount;
        System.out.println("Đã phạt độc giả " + readerId + " số tiền: " + amount + " VND. Lý do: " + reason);
    }

    @Override
    public void payFine(double amount) {
        if (amount <= fineAmount) {
            fineAmount -= amount;
            System.out.println("Độc giả " + readerId + " đã thanh toán: " + amount + " VND tiền phạt.");
        } else {
            System.out.println("Số tiền thanh toán vượt quá số tiền phạt hiện tại.");
        }
    }

    @Override
    public double getRemainingFine() {
        return fineAmount;
    }
}