import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class BorrowSlip {
    private String slipId;
    private Reader reader;
    private Book book;
    private LocalDate borrowDate;
    private LocalDate dueDate;
    private LocalDate returnDate; // null nếu chưa trả

    public BorrowSlip(String slipId, Reader reader, Book book, LocalDate borrowDate, LocalDate dueDate) {
        this.slipId = slipId;
        this.reader = reader;
        this.book = book;
        this.borrowDate = borrowDate;
        this.dueDate = dueDate;
        this.returnDate = null;
    }

    // Nghiệp vụ: Tính tiền phạt dựa trên ngày trả thực tế
    public double calculateFine(LocalDate actualReturnDate) {
        if (actualReturnDate.isAfter(this.dueDate)) {
            long daysLate = ChronoUnit.DAYS.between(this.dueDate, actualReturnDate);
            return daysLate * 5000.0;
        }
        return 0.0;
    }

    // Kiểm tra xem phiếu mượn này có đang bị quá hạn so với ngày giả định không
    public boolean isOverdue(LocalDate currentDate) {
        return returnDate == null && currentDate.isAfter(dueDate);
    }

    // Getter và Setter
    public String getSlipId() { return slipId; }
    public Reader getReader() { return reader; }
    public Book getBook() { return book; }
    public LocalDate getDueDate() { return dueDate; }
    public void setReturnDate(LocalDate returnDate) { this.returnDate = returnDate; }
    public LocalDate getReturnDate() { return returnDate; }
}