public class Reader {
    private String readerId;
    private String fullName;
    private String email;

    // Constructor của lớp cha
    public Reader(String readerId, String fullName, String email) {
        this.readerId = readerId;
        this.fullName = fullName;
        this.email = email;
    }

    // Nghiệp vụ gốc: Mặc định lớp cha trả về 0, các lớp con sẽ ghi đè
    public int getMaxBorrowLimit() {
        return 0;
    }

    // Getter và Setter
    public String getReaderId() { return readerId; }
    public void setReaderId(String readerId) { this.readerId = readerId; }

    public String getFullName() { return fullName; }
    public void setFullName(String fullName) { this.fullName = fullName; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    // Dùng cho hàm in danh sách độc giả
    @Override
    public String toString() {
        return "[ID: " + readerId + "] " + fullName + " (Email: " + email + ")";
    }
}