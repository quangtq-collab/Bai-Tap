import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Library {
    // --- TỐI ƯU HÓA BIẾN THÀNH FINAL ĐỂ XÓA CẢNH BÁO ---
    // CŨ: private List<Book> books = new ArrayList<>();
    // MỚI: Thêm từ khóa final để khẳng định danh sách này cố định, không bị gán lại đối tượng khác
    private final List<Book> books = new ArrayList<>(); //
    private final List<Reader> readers = new ArrayList<>(); //
    private final List<BorrowSlip> borrowSlips = new ArrayList<>(); //

    public void addBook(Book book) { books.add(book); }
    public void addReader(Reader reader) { readers.add(reader); }

    // --- TỐI ƯU HÓA KIỂU TRẢ VỀ CỦA PHƯƠNG THỨC MƯỢN SÁCH ---
    // CŨ: public boolean borrowBook(String slipId, Reader reader, Book book, LocalDate borrowDate, LocalDate dueDate)
    // MỚI: Đổi thành void vì giá trị trả về không được sử dụng ở lớp Main, xóa hoàn toàn cảnh báo hệ thống
    public void borrowBook(String slipId, Reader reader, Book book, LocalDate borrowDate, LocalDate dueDate) { //
        if (!book.isAvailable()) {
            System.out.println("-> Mượn thất bại: Sách '" + book.getTitle() + "' đã hết trong kho.");
            // CŨ: return false;
            return; // Dùng return trống để ngắt hàm ngay lập tức khi không thỏa mãn điều kiện
        }

        int currentBorrowedCount = 0;
        for (BorrowSlip slip : borrowSlips) {
            if (slip.getReader().getReaderId().equals(reader.getReaderId()) && slip.getReturnDate() == null) {
                currentBorrowedCount++;
            }
        }

        if (currentBorrowedCount >= reader.getMaxBorrowLimit()) {
            System.out.println("-> Mượn thất bại: Độc giả " + reader.getFullName() +
                    " đã đạt giới hạn mượn tối đa (" + reader.getMaxBorrowLimit() + " cuốn).");
            // CŨ: return false;
            return; // Bẻ gãy tiến trình mượn sách nếu vượt hạn mức
        }

        book.decreaseQuantity();
        BorrowSlip newSlip = new BorrowSlip(slipId, reader, book, borrowDate, dueDate);
        borrowSlips.add(newSlip);
        System.out.println("-> Mượn thành công sách '" + book.getTitle() + "' cho độc giả " + reader.getFullName());

        // CŨ: return true; -> Xóa bỏ vì hàm đã chuyển đổi hoàn toàn sang kiểu void
    }

    // Nghiệp vụ trả sách giữ nguyên chuẩn hóa đa hình từ bước trước
    public void returnBook(String slipId, LocalDate actualReturnDate) {
        for (BorrowSlip slip : borrowSlips) {
            if (slip.getSlipId().equals(slipId) && slip.getReturnDate() == null) {
                slip.setReturnDate(actualReturnDate);
                slip.getBook().increaseQuantity();

                double fine = slip.calculateFine(actualReturnDate);
                System.out.println("-> Đã trả sách: '" + slip.getBook().getTitle() + "'");
                if (fine > 0) {
                    System.out.printf("   STT QUÁ HẠN! Tiền phạt cố định của phiếu mượn: %,.0f VND\n", fine);
                } else {
                    System.out.println("   Đúng hạn. Không bị phạt.");
                }
                return;
            }
        }
        System.out.println("-> Không tìm thấy mã phiếu mượn chưa trả hợp lệ!");
    }

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

    public void printAllReaders() {
        System.out.println("=== DANH SACH DOC GIA ==="); //
        for (Reader r : readers) {
            System.out.println(r.getInfo());
        }
    }

    public void showLateFees(int daysLate) {
        System.out.println("\n=== PHI PHAT TRE HAN (" + daysLate + " ngay) ==="); //
        for (Reader r : readers) {
            System.out.printf("%-25s | Fee: %,.0f VND\n", r.getFullName(), r.calculateLateFee(daysLate)); //
        }
    }
}