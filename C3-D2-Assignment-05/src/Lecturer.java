public class Lecturer extends Reader {

    public Lecturer(String readerId, String fullName, String email) {
        super(readerId, fullName, email);
    }

    @Override
    public int getMaxBorrowLimit() {
        return 5;
    }

    // --- THÊM MỚI CHÍNH SÁCH PHẠT THEO BẢNG ĐỀ BÀI ---
    // MỚI: Mỗi ngày trễ hạn của giảng viên được ưu đãi hơn, chỉ phạt 1,000 VND
    @Override
    public double calculateLateFee(int daysLate) {
        return daysLate * 1000.0; //
    }

    // --- THAY THẾ ĐỊNH DẠNG CHUỖI XUẤT THÔNG TIN ---
    // CŨ: Dùng hàm ghép chuỗi thủ công thô sơ ở bài trước
    // @Override
    // public String toString() { return super.toString() + " (Giang vien)"; }

    // MỚI: Định dạng chuẩn hóa thông tin chi tiết của Giảng viên
    @Override
    public String getInfo() {
        return "[GV] " + getReaderId() + " | " + getFullName()
                + " | Email: " + getEmail()
                + " | Han muon: " + getMaxBorrowLimit() + " cuon"; //
    }
}