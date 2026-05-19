public class BankAccount {
    String accountNumber;
    String ownerName;
    double balance;

    // Constructor đầy đủ tham số
    public BankAccount(String accountNumber, String ownerName, double balance) {
        this.accountNumber = accountNumber;
        this.ownerName = ownerName;
        this.balance = balance;
    }

    // Phương thức chuyển tiền sang tài khoản khác
    public void transfer(BankAccount targetAccount, double amount) {
        if (amount > 0 && this.balance >= amount) {
            this.balance -= amount;
            targetAccount.balance += amount;
            System.out.println("-> [" + this.ownerName + "] đã chuyển " + amount + " cho [" + targetAccount.ownerName + "]");
        } else {
            System.out.println("-> Giao dịch thất bại: Số dư không đủ hoặc số tiền không hợp lệ!");
        }
    }

    public void display() {
        System.out.println("Tài khoản: " + accountNumber + " - Chủ TK: " + ownerName + " - Số dư: " + balance);
    }
}