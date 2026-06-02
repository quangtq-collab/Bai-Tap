// LecturerReader.java — Giảng viên, giới hạn 5 cuốn, phí phạt thấp hơn sinh viên
public class LecturerReader extends Reader {
    public LecturerReader(String readerId, String fullName) {
        super(readerId, fullName);
    }

    @Override
    public int getMaxBorrowLimit() { return 5; }

    @Override
    public double calculateLateFee(int daysLate) { return daysLate * 1000.0; }

    @Override
    public String getInfo() { return "[Lecturer] ID: " + readerId + " | Name: " + fullName; }

    @Override
    protected boolean checkSpecialCondition(Book book) { return true; }

    @Override
    protected String getSpecialConditionMessage() { return ""; }
}
