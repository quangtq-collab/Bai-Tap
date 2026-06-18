public interface Borrowable {
    // Hằng số mặc định
    int MAX_BORROW_DAYS  = 14;       // Số ngày mượn tối đa
    double FINE_PER_DAY  = 5000.0;   // Phạt 5,000 VND / ngày trễ

    // Các phương thức trừu tượng (Abstract methods)
    void borrowBy(String readerId, String date);  // Đăng ký mượn bởi độc giả
    void returnBook(String date);                 // Đăng ký trả sách
    boolean isAvailable();                        // Sách còn trong kho không?
    String getBorrowerId();                       // Lấy ID người đang mượn

    // Phương thức mặc định (Default method) để tính phí phạt
    default double calculateFine(int daysOverdue) {
        if (daysOverdue <= 0) return 0.0;
        return daysOverdue * FINE_PER_DAY;
    }

    // Phương thức tĩnh (Static method) để kiểm tra thời gian mượn hợp lệ
    static boolean isValidBorrowDuration(int days) {
        return days > 0 && days <= MAX_BORROW_DAYS;
    }
}