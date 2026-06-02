import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class BorrowSlip {
    private String slipId;
    private Reader reader;
    private Book book;
    private LocalDate borrowDate;
    private LocalDate dueDate;
    private LocalDate returnDate;

    public BorrowSlip(String slipId, Reader reader, Book book, LocalDate borrowDate, LocalDate dueDate) {
        this.slipId = slipId;
        this.reader = reader;
        this.book = book;
        this.borrowDate = borrowDate;
        this.dueDate = dueDate;
    }

    public double calculateFine(LocalDate actualReturnDate) {
        if (actualReturnDate.isAfter(dueDate)) {
            int daysLate = (int) ChronoUnit.DAYS.between(dueDate, actualReturnDate);
            return reader.calculateLateFee(daysLate);
        }
        return 0;
    }

    public String getSlipId() { return slipId; }
    public Reader getReader() { return reader; }
    public Book getBook() { return book; }
    public LocalDate getReturnDate() { return returnDate; }
    public void setReturnDate(LocalDate returnDate) { this.returnDate = returnDate; }
}