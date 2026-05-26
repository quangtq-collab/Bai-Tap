public abstract class Reader {
    private String readerId;
    private String fullName;
    private String email;

    // Constructor của lớp cha
    public Reader(String readerId, String fullName, String email) {
        this.readerId = readerId;
        this.fullName = fullName;
        this.email = email;
    }

    // Nghiệp vụ 1: Phương thức trừu tượng lấy số sách mượn tối đa
    public abstract int getMaxBorrowLimit();

    // Nghiệp vụ 2: Phương thức trừu tượng tính tiền phạt trễ hạn dựa theo số ngày trễ
    public abstract double calculateLateFee(int daysLate);

    // Nghiệp vụ 3: Phương thức trừu tượng định dạng chuỗi thông tin độc giả
    public abstract String getInfo();

    // Getter và Setter giữ nguyên
    public String getReaderId() { return readerId; }
    public void setReaderId(String readerId) { this.readerId = readerId; }

    public String getFullName() { return fullName; }
    public void setFullName(String fullName) { this.fullName = fullName; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    // Giữ lại hàm toString cơ bản để các lớp con tái sử dụng qua super.toString()
    @Override
    public String toString() {
        return "[ID: " + readerId + "] " + fullName + " (Email: " + email + ")";
    }
}
