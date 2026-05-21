public class Student extends Reader {

    public Student(String readerId, String fullName, String email) {
        // Gọi constructor lớp cha
        super(readerId, fullName, email);
    }

    // Ghi đè giới hạn mượn của Sinh viên
    @Override
    public int getMaxBorrowLimit() {
        return 3;
    }

    @Override
    public String toString() {
        return super.toString() + " - Thẻ: SINH_VIÊN (Tối đa: " + getMaxBorrowLimit() + " cuốn)";
    }
}
