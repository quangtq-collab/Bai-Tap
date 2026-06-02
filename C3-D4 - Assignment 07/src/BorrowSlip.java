import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class BorrowSlip {
    private Reader reader;
    private Book book;
    private LocalDate borrowDate;

    public BorrowSlip(Reader reader, Book book, LocalDate borrowDate) {
        this.reader = reader;
        this.book = book;
        this.borrowDate = borrowDate;
    }

    public Reader getReader() { return reader; }
    public Book getBook() { return book; }

    public int calculateDaysLate(LocalDate currentDate) {
        LocalDate dueDate = borrowDate.plusDays(14);
        if (currentDate.isAfter(dueDate)) {
            return (int) ChronoUnit.DAYS.between(dueDate, currentDate);
        }
        return 0;
    }
}
