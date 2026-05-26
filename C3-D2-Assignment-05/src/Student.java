public class Student extends Reader {

    public Student(String readerId, String fullName, String email) {
        super(readerId, fullName, email);
    }

    // Hiện thực hóa hàm lấy giới hạn mượn: Sinh viên mượn tối đa 3 cuốn
    @Override
    public int getMaxBorrowLimit() {
        return 3;
    }

    // Hiện thực hóa hàm tính phí phạt: Sinh viên phạt 2,000 VND / ngày trễ
    @Override
    public double calculateLateFee(int daysLate) {
        return daysLate * 2000.0;
    }

    // --- THAY THẾ ĐỊNH DẠNG CHUỖI ---
    // CŨ: return "[SV] " + getBaseDetails() + " - Thẻ: SINH_VIÊN ...";
    // MỚI: Định dạng chính xác theo cấu trúc thiết kế của đề bài mới
    @Override
    public String getInfo() {
        return "[SV] " + getReaderId() + " | " + getFullName()
                + " | Email: " + getEmail()
                + " | Han muon: " + getMaxBorrowLimit() + " cuon"; //
    }
}