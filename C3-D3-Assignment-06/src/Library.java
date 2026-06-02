import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Library {
    private final List<Book> books = new ArrayList<>();
    private final List<Reader> readers = new ArrayList<>();
    private final List<BorrowSlip> borrowSlips = new ArrayList<>();

    public void addBook(Book book) { books.add(book); }
    public void addReader(Reader reader) { readers.add(reader); }

    // Phương thức kiểm tra và ném ra InvalidBorrowException thay vì chỉ hiển thị text và return thông thường
    public void borrowBook(String slipId, Reader reader, Book book, LocalDate borrowDate, LocalDate dueDate)
            throws InvalidBorrowException {

        // 1. Kiểm tra trạng thái còn sách trong kho thư viện
        if (!book.isAvailable()) {
            throw new InvalidBorrowException("Book '" + book.getTitle() + "' is currently out of stock!");
        }

        // 2. Tính toán tổng số lượng sách độc giả này chưa trả
        int currentBorrowedCount = 0;
        for (BorrowSlip slip : borrowSlips) {
            if (slip.getReader().getReaderId().equals(reader.getReaderId()) && slip.getReturnDate() == null) {
                currentBorrowedCount++;
            }
        }

        // 3. Kiểm tra giới hạn mượn theo loại thẻ độc giả
        if (currentBorrowedCount >= reader.getMaxBorrowLimit()) {
            throw new InvalidBorrowException("Reader " + reader.getFullName() +
                    " has reached the borrowing threshold of " + reader.getMaxBorrowLimit() + " books.");
        }

        // Thực hiện ghi nhận mượn sách nếu vượt qua toàn bộ kiểm tra điều kiện lỗi
        book.decreaseQuantity();
        BorrowSlip newSlip = new BorrowSlip(slipId, reader, book, borrowDate, dueDate);
        borrowSlips.add(newSlip);
        System.out.println("-> [SUCCESS] Borrowed '" + book.getTitle() + "' for: " + reader.getFullName());
    }

    public void returnBook(String slipId, LocalDate actualReturnDate) {
        for (BorrowSlip slip : borrowSlips) {
            if (slip.getSlipId().equals(slipId) && slip.getReturnDate() == null) {
                slip.setReturnDate(actualReturnDate);
                slip.getBook().increaseQuantity();

                double fine = slip.calculateFine(actualReturnDate);
                System.out.println("-> Book Returned: '" + slip.getBook().getTitle() + "'");
                if (fine > 0) {
                    System.out.printf("   OVERDUE WARNING! Fine amount: %,.0f VND\n", fine);
                } else {
                    System.out.println("   No fee applied (On time or Exempted).");
                }
                return;
            }
        }
        System.out.println("-> Invalid borrow slip ID!");
    }

    public void printAllReaders() {
        System.out.println("=== SYSTEM READERS LIST ===");
        for (Reader r : readers) {
            System.out.println(r.getInfo());
        }
    }
}