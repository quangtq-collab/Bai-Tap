public interface Fineable {
    void issueFine(double amount, String reason);
    void payFine(double amount);
    double getRemainingFine();
}