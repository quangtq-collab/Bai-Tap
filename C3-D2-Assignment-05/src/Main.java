import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        Library library = new Library();

        // 1. Tạo dữ liệu mẫu Sách (Giữ nguyên gốc cũ của bạn)
        Book b1 = new Book("B01", "Lap trinh Java OOP", "Nguyen Van A", 2024, 2);
        Book b2 = new Book("B02", "Cấu trúc dữ liệu", "Nguyen Viet B", 2023, 1);
        library.addBook(b1);
        library.addBook(b2);

        // --- THAY THẾ CÁCH KHỞI TẠO ĐỘC GIẢ ---
        // CŨ (Bị lỗi biên dịch ở bài mới này): Khởi tạo trực tiếp từ lớp cha Reader
        // Reader sv = new Reader("SV01", "Nguyen Khac Trong", "sv@gmail.com");
        // Reader gv = new Reader("GV01", "Truong Minh Tuan", "gv@gmail.com");

        // MỚI: Ép buộc phải tạo thông qua các lớp con thực tế (Student và Lecturer)
        Reader sv = new Student("SV01", "Nguyen Khac Trong", "sv@gmail.com");
        Reader gv = new Lecturer("GV01", "Truong Minh Tuan", "gv@gmail.com");

        library.addReader(sv);
        library.addReader(gv);

        System.out.println("=== HỆ THỐNG QUẢN LÝ THƯ VIỆN ===");

        // Thử nghiệm in danh sách kiểm tra đa hình thông qua hàm getInfo() mới thay thế cho toString()
        library.printAllReaders();

        // --- GỌI THÊM NGHIỆP VỤ MỚI CỦA BÀI 5 ---
        // MỚI: Thử nghiệm in bảng tính phí phạt trễ hạn giả định (Ví dụ: trễ 7 ngày)
        library.showLateFees(7);

        // Thử nghiệm tìm kiếm sách (Giữ nguyên gốc)
        library.searchBooks("Cấu trúc");

        // 3. Thử nghiệm nghiệp vụ mượn sách & Giới hạn thẻ (Giữ nguyên gốc)
        System.out.println("\n--- Mượn sách ---");
        LocalDate today = LocalDate.of(2026, 5, 1);
        LocalDate dueDate = LocalDate.of(2026, 5, 10);

        // Sinh viên mượn cuốn 1
        library.borrowBook("P01", sv, b1, today, dueDate);
        // Sinh viên mượn tiếp cuốn 2 (Vẫn trong giới hạn 3 cuốn của SV)
        library.borrowBook("P02", sv, b2, today, dueDate);

        // Thử mượn cuốn b2 lần nữa khi kho đã về 0 để test ràng buộc hết sách
        library.borrowBook("P03", gv, b2, today, dueDate);

        // 4. Kiểm tra phiếu quá hạn (Giữ nguyên gốc)
        LocalDate checkDate = LocalDate.of(2026, 5, 19);
        library.listOverdueSlips(checkDate);

        // 5. Thử nghiệm trả sách và phạt quá hạn (Giữ nguyên gốc)
        System.out.println("\n--- Trả sách ---");
        library.returnBook("P01", checkDate);
    }
}
