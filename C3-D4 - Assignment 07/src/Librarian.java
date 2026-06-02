// Librarian.java — Refactor: HAS-A Library, không kế thừa Reader
import java.time.LocalDate;

public class Librarian {
    private String employeeId;
    private String fullName;
    private String phone;
    private String shift;
    private Library library;   // HAS-A Library (Composition)

    public Librarian(String employeeId, String fullName, String phone,
                     String shift, Library library) {
        this.employeeId = employeeId;
        this.fullName   = fullName;
        this.phone      = phone;
        this.shift      = shift;
        this.library    = library;
    }

    // Nghiệp vụ: xử lý cho mượn qua đa hình Reader.processBorrow()
    public void processLoan(Reader reader, Book book) {
        System.out.println("[Thủ thư " + fullName + "] Xử lý cho mượn:");
        BorrowResult result = reader.processBorrow(book);
        System.out.println("  Kết quả: " + result.getMessage());
        if (result.isSuccess()) {
            BorrowSlip slip = new BorrowSlip(reader, book, LocalDate.now());
            library.addBorrowSlip(slip);
        }
    }

    // Nghiệp vụ: xử lý trả sách
    public void processReturn(BorrowSlip slip) {
        int daysLate = slip.calculateDaysLate(LocalDate.now());
        if (daysLate > 0) {
            double fee = slip.getReader().calculateLateFee(daysLate);
            System.out.printf("Phạt quá hạn %d ngày: %.0f VND%n", daysLate, fee);
        }
        slip.getBook().increaseQuantity();
        library.removeBorrowSlip(slip);
    }
}
