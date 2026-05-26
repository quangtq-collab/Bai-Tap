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

    public boolean isOverdue(LocalDate currentDate) {
        return returnDate == null && currentDate.isAfter(dueDate);
    }

    // --- THAY THẾ NGHIỆP VỤ TÍNH TIỀN PHẠT TRỄ HẠN ---
    // CŨ (C3-D1-Assignment-04): Tính một mức giá phạt chung chung không phân biệt loại thẻ độc giả
    // public double calculateFine(LocalDate actualReturnDate) {
    //     if (actualReturnDate.isAfter(dueDate)) {
    //         long daysLate = ChronoUnit.DAYS.between(dueDate, actualReturnDate);
    //         return daysLate * 5000.0;
    //     }
    //     return 0;
    // }

    // MỚI (C3-D2-Assignment-05): Tận dụng tính đa hình để tính tiền phạt dựa theo chính sách từng loại thẻ
    public double calculateFine(LocalDate actualReturnDate) {
        if (actualReturnDate.isAfter(dueDate)) {
            // Tính khoảng cách số ngày trễ giữa ngày hẹn trả và ngày trả thực tế
            int daysLate = (int) ChronoUnit.DAYS.between(dueDate, actualReturnDate);

            // ĐA HÌNH: Trình biên dịch tự động chạy xuống hàm calculateLateFee() của lớp con
            // Student (nhân 2,000) hoặc Lecturer (nhân 1,000) tùy thuộc vào đối tượng đang mượn sách
            return reader.calculateLateFee(daysLate); //
        }
        return 0;
    }

    // Các hàm Getter và Setter giữ nguyên vẹn
    public String getSlipId() { return slipId; }
    public Reader getReader() { return reader; }
    public Book getBook() { return book; }
    public LocalDate getDueDate() { return dueDate; }
    public LocalDate getReturnDate() { return returnDate; }
    public void setReturnDate(LocalDate returnDate) { this.returnDate = returnDate; }
}