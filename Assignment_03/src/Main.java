import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        Library library = new Library();

        // 1. Tạo dữ liệu mẫu Sách
        Book b1 = new Book("B01", "Lap trinh Java OOP", "Nguyen Van A", 2024, 2);
        Book b2 = new Book("B02", "Cấu trúc dữ liệu", "Nguyen Viet B", 2023, 1);
        library.addBook(b1);
        library.addBook(b2);

        // 2. Tạo dữ liệu mẫu Độc giả
        Reader sv = new Reader("SV01", "Nguyen Khac Trong", "sv@gmail.com", ReaderType.SINH_VIEN);
        Reader gv = new Reader("GV01", "Truong Minh Tuan", "gv@gmail.com", ReaderType.GIANG_VIEN);
        library.addReader(sv);
        library.addReader(gv);

        System.out.println("=== HỆ THỐNG QUẢN LÝ THƯ VIỆN ===");

        // Thử nghiệm tìm kiếm sách (Nghiệp vụ 3.4)
        library.searchBooks("Cấu trúc");

        // 3. Thử nghiệm nghiệp vụ mượn sách & Giới hạn thẻ (Nghiệp vụ 3.1 & 3.3)
        System.out.println("\n--- Mượn sách ---");
        LocalDate today = LocalDate.of(2026, 5, 1);
        LocalDate dueDate = LocalDate.of(2026, 5, 10);

        // Sinh viên mượn cuốn 1
        library.borrowBook("P01", sv, b1, today, dueDate);
        // Sinh viên mượn tiếp cuốn 2 (Vẫn trong giới hạn 3 cuốn của SV)
        library.borrowBook("P02", sv, b2, today, dueDate);

        // Thử mượn cuốn b2 lần nữa khi kho đã về 0 để test ràng buộc hết sách
        library.borrowBook("P03", gv, b2, today, dueDate);

        // 4. Kiểm tra phiếu quá hạn (Nghiệp vụ 3.5)
        // Giả sử hôm nay là ngày 19/05/2026 (Quá hạn trả ngày 10/05)
        LocalDate checkDate = LocalDate.of(2026, 5, 19);
        library.listOverdueSlips(checkDate);

        // 5. Thử nghiệm trả sách và phạt quá hạn (Nghiệp vụ 3.2)
        System.out.println("\n--- Trả sách ---");
        // Trả đúng hạn hoặc trễ 9 ngày (Tự động tính tiền phạt: 9 ngày * 5000 = 45,000 VND)
        library.returnBook("P01", checkDate);
    }
}