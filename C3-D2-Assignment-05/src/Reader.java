// CŨ (C3-D1-Assignment-04): public class Reader {
// MỚI (C3-D2-Assignment-05): Thêm từ khóa abstract để chuyển thành lớp trừu tượng
public abstract class Reader {
    private String readerId;
    private String fullName;
    private String email;

    public Reader(String readerId, String fullName, String email) {
        this.readerId = readerId;
        this.fullName = fullName;
        this.email = email;
    }

    // --- THAY THẾ NGHIỆP VỤ 1: LẤY GIỚI HẠN MƯỢN ---
    // CŨ: Hàm bình thường, trả về giá trị mặc định là 0
    // public int getMaxBorrowLimit() {
    //     return 0;
    // }
    // MỚI: Nâng cấp thành abstract method (xóa body `{}`), ép các lớp con bắt buộc tự cài đặt
    public abstract int getMaxBorrowLimit();


    // --- THÊM MỚI NGHIỆP VỤ 2: TÍNH PHÍ PHẠT TRỄ HẠN ---
    // MỚI: Mỗi loại độc giả có một mức phạt riêng (2k hoặc 1k) nên cần khai báo abstract ở đây
    public abstract double calculateLateFee(int daysLate);


    // --- THAY THẾ NGHIỆP VỤ 3: ĐỊNH DẠNG CHUỖI THÔNG TIN ---
    // CŨ: Sử dụng hàm toString() thông thường để in thông tin cơ bản
    // @Override
    // public String toString() {
    //     return "[ID: " + readerId + "] " + fullName + " (Email: " + email + ")";
    // }
    // MỚI: Chuyển hẳn thành hàm abstract getInfo() theo đúng yêu cầu thiết kế hợp đồng mới
    public abstract String getInfo();


    // Các hàm Getter và Setter của bài cũ giữ nguyên không thay đổi
    public String getReaderId() { return readerId; }
    public void setReaderId(String readerId) { this.readerId = readerId; }
    public String getFullName() { return fullName; }
    public void setFullName(String fullName) { this.fullName = fullName; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    // Giữ lại một hàm hỗ trợ lấy thông tin gốc để các lớp con dùng lại nếu cần
    public String getBaseDetails() {
        return "[ID: " + readerId + "] " + fullName + " (Email: " + email + ")";
    }
}
