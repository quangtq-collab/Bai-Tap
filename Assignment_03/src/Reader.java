public class Reader {
    private String readerId;
    private String fullName;
    private String email;
    private ReaderType type;

    public Reader(String readerId, String fullName, String email, ReaderType type) {
        this.readerId = readerId;
        this.fullName = fullName;
        this.email = email;
        this.type = type;
    }

    // Nghiệp vụ: Lấy số sách tối đa được mượn dựa theo loại thẻ
    public int getMaxBorrowLimit() {
        return (this.type == ReaderType.GIANG_VIEN) ? 5 : 3;
    }

    // Getter và Setter
    public String getReaderId() { return readerId; }
    public String getFullName() { return fullName; }
    public ReaderType getType() { return type; }
}