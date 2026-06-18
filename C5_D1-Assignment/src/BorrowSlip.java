import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class BorrowSlip implements Returnable {
    private String slipId;
    private String readerId;
    private String bookId;
    private String dueDate;        // Định dạng yyyy-MM-dd
    private String actualReturnDate;

    public BorrowSlip(String slipId, String readerId, String bookId, String dueDate) {
        this.slipId = slipId;
        this.readerId = readerId;
        this.bookId = bookId;
        this.dueDate = dueDate;
        this.actualReturnDate = null;
    }

    @Override
    public void confirmReturn(String date) {
        this.actualReturnDate = date;
        System.out.println("Phiếu mượn " + slipId + " xác nhận trả sách ngày: " + date);
    }

    @Override
    public boolean isLate(String currentDate) {
        LocalDate due = LocalDate.parse(this.dueDate);
        LocalDate current = LocalDate.parse(currentDate);
        return current.isAfter(due);
    }

    public int getDaysLate(String currentDate) {
        if (!isLate(currentDate)) return 0;
        LocalDate due = LocalDate.parse(this.dueDate);
        LocalDate current = LocalDate.parse(currentDate);
        return (int) ChronoUnit.DAYS.between(due, current);
    }

    // Getters
    public String getSlipId() { return slipId; }
    public String getReaderId() { return readerId; }
    public String getBookId() { return bookId; }
}