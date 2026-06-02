// StudentReader.java — Sinh viên không được mượn sách tham khảo hiếm
public class StudentReader extends Reader {
    public StudentReader(String readerId, String fullName) {
        super(readerId, fullName);
    }

    @Override
    public int getMaxBorrowLimit() { return 3; }

    @Override
    public double calculateLateFee(int daysLate) { return daysLate * 2000.0; }

    @Override
    public String getInfo() { return "[Student] ID: " + readerId + " | Name: " + fullName; }

    @Override
    protected boolean checkSpecialCondition(Book book) {
        return !book.isReferenceOnly();
    }

    @Override
    protected String getSpecialConditionMessage() {
        return "Sách tham khảo chỉ đọc tại chỗ — sinh viên không được mang về";
    }
}
