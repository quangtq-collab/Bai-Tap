import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Library {
    private List<Book> books = new ArrayList<>();
    private List<Reader> readers = new ArrayList<>();
    private List<BorrowSlip> borrowSlips = new ArrayList<>();

    public void addBook(Book book) { books.add(book); }
    public void addReader(Reader reader) { readers.add(reader); }

    // Nghiệp vụ 3.1 & 3.3: Mượn sách có ràng buộc
    public boolean borrowBook(String slipId, Reader reader, Book book, LocalDate borrowDate, LocalDate dueDate) {
        // Ràng buộc 1: Kiểm tra số lượng kho
        if (!book.isAvailable()) {
            System.out.println("-> Mượn thất bại: Sách '" + book.getTitle() + "' đã hết trong kho.");
            return false;
        }

        // Ràng buộc 3: Kiểm tra giới hạn mượn của loại thẻ
        int currentBorrowedCount = 0;
        for (BorrowSlip slip : borrowSlips) {
            if (slip.getReader().getReaderId().equals(reader.getReaderId()) && slip.getReturnDate() == null) {
                currentBorrowedCount++;
            }
        }

        if (currentBorrowedCount >= reader.getMaxBorrowLimit()) {
            System.out.println("-> Mượn thất bại: Độc giả " + reader.getFullName() +
                    " (" + reader.getType() + ") đã đạt giới hạn mượn tối đa (" +
                    reader.getMaxBorrowLimit() + " cuốn).");
            return false;
        }

        // Thực hiện nghiệp vụ khi đủ điều kiện
        book.decreaseQuantity();
        BorrowSlip newSlip = new BorrowSlip(slipId, reader, book, borrowDate, dueDate);
        borrowSlips.add(newSlip);
        System.out.println("-> Mượn thành công sách '" + book.getTitle() + "' cho độc giả " + reader.getFullName());
        return true;
    }

    // Nghiệp vụ 3.2: Trả sách và tính tiền phạt tiền
    public void returnBook(String slipId, LocalDate actualReturnDate) {
        for (BorrowSlip slip : borrowSlips) {
            if (slip.getSlipId().equals(slipId) && slip.getReturnDate() == null) {
                slip.setReturnDate(actualReturnDate);
                slip.getBook().increaseQuantity(); // Cộng lại kho 1

                double fine = slip.calculateFine(actualReturnDate);
                System.out.println("-> Đã trả sách: '" + slip.getBook().getTitle() + "'");
                if (fine > 0) {
                    System.out.printf("   STT QUÁ HẠN! Tiền phạt: %,.0f VND\n", fine);
                } else {
                    System.out.println("   Đúng hạn. Không bị phạt.");
                }
                return;
            }
        }
        System.out.println("-> Không tìm thấy mã phiếu mượn chưa trả hợp lệ!");
    }

    // Nghiệp vụ 3.4: Tìm kiếm sách theo tên hoặc tác giả (Không phân biệt hoa thường)
    public void searchBooks(String keyword) {
        System.out.println("\n--- Kết quả tìm kiếm sách với từ khóa '" + keyword + "' ---");
        boolean found = false;
        for (Book b : books) {
            if (b.getTitle().toLowerCase().contains(keyword.toLowerCase()) ||
                    b.getAuthor().toLowerCase().contains(keyword.toLowerCase())) {
                System.out.println("   [ID: " + b.getBookId() + "] " + b.getTitle() + " - Tác giả: " + b.getAuthor() + " (Còn lại: " + b.getQuantity() + ")");
                found = true;
            }
        }
        if (!found) System.out.println("   Không tìm thấy cuốn sách nào.");
    }

    // Nghiệp vụ 3.5: Liệt kê các phiếu mượn đang quá hạn
    public void listOverdueSlips(LocalDate currentDate) {
        System.out.println("\n--- Danh sách phiếu mượn ĐANG QUÁ HẠN (Tính đến ngày " + currentDate + ") ---");
        boolean hasOverdue = false;
        for (BorrowSlip slip : borrowSlips) {
            if (slip.isOverdue(currentDate)) {
                System.out.println("   [Mã Phiếu: " + slip.getSlipId() + "] Độc giả: " + slip.getReader().getFullName() +
                        " | Sách: " + slip.getBook().getTitle() + " | Hạn trả: " + slip.getDueDate());
                hasOverdue = true;
            }
        }
        if (!hasOverdue) System.out.println("   Tuyệt vời! Không có phiếu mượn nào quá hạn.");
    }
}