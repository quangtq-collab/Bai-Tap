public class Lecturer extends Reader {

    public Lecturer(String readerId, String fullName, String email) {
        super(readerId, fullName, email);
    }

    // Ghi đè giới hạn mượn của Giảng viên
    @Override
    public int getMaxBorrowLimit() {
        return 5;
    }

    @Override
    public String toString() {
        return super.toString() + " - Thẻ: GIẢNG_VIÊN (Tối đa: " + getMaxBorrowLimit() + " cuốn)";
    }
}
