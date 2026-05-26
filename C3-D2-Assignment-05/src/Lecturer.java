public class Lecturer extends Reader {

    public Lecturer(String readerId, String fullName, String email) {
        super(readerId, fullName, email);
    }

    @Override
    public int getMaxBorrowLimit() {
        return 5;
    }

    @Override
    public double calculateLateFee(int daysLate) {
        return daysLate * 1000.0;
    }

    @Override
    public String getInfo() {
        return super.toString() + " - Thẻ: GIẢNG_VIÊN (Tối đa: " + getMaxBorrowLimit() + " cuốn)";
    }
}
