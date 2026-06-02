import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        Library library = new Library();

        // Nạp kho sách (Thiết lập cuốn b2 số lượng bằng 0 để chủ động kích hoạt lỗi)
        Book b1 = new Book("B01", "Java Core Programming", "Author A", 5);
        Book b2 = new Book("B02", "Advanced Algorithm Design", "Author B", 0); // Hết sách
        library.addBook(b1);
        library.addBook(b2);

        // Nạp danh sách thẻ độc giả
        Reader sv = new Student("SV01", "Nguyen Khac Trong", "sv@gmail.com");
        Reader senior = new SeniorReader("SE01", "Bac Nguyen Van C", "senior@gmail.com");
        library.addReader(sv);
        library.addReader(senior);

        System.out.println("====== ASSIGNMENT-06: EXCEPTION HANDLING & SENIOR POLICY ======\n");

        // 1. Kiểm tra chuỗi định dạng của Độc giả cao tuổi [NCT - MIEN PHAT]
        library.printAllReaders();

        LocalDate borrowDate = LocalDate.of(2026, 5, 1);
        LocalDate dueDate = LocalDate.of(2026, 5, 15);

        // 2. Kiểm thử kịch bản mượn sách thành công và trả quá hạn đối với SeniorReader
        System.out.println("\n--- CASE 1: SENIOR READER BORROW & OVERDUE RETURN ---");
        try {
            library.borrowBook("SLIP01", senior, b1, borrowDate, dueDate);

            // Tiến hành trả sách trễ hạn 10 ngày (Ngày trả thực tế là 25/05, hạn cuối là 15/05)
            LocalDate lateReturnDate = LocalDate.of(2026, 5, 25);
            library.returnBook("SLIP01", lateReturnDate);

        } catch (InvalidBorrowException e) {
            System.err.println("-> [ERROR] " + e.getMessage());
        }

        // 3. Kiểm thử kịch bản kích hoạt, bắt và xử lý ngoại lệ InvalidBorrowException
        System.out.println("\n--- CASE 2: KÍCH HOẠT VÀ XỬ LÝ NGOẠI LỆ (MƯỢN SÁCH HẾT KHO) ---");
        try {
            // Cố tình thực hiện hành vi mượn cuốn b2 (Cuốn sách đang có số lượng = 0)
            library.borrowBook("SLIP02", sv, b2, borrowDate, dueDate);

            System.out.println("Dòng lệnh này sẽ không bao giờ được thực thi.");
        } catch (InvalidBorrowException e) {
            // Khối catch tóm gọn ngoại lệ và hiển thị thông điệp nguyên nhân lỗi an toàn
            System.err.println("-> [CAUGHT EXCEPTION] Borrowing process halted!");
            System.err.println("   Reason: " + e.getMessage());
        }
    }
}