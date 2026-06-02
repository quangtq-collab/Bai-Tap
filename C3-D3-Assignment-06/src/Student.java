public class Student extends Reader {
    public Student(String readerId, String fullName, String email) {
        super(readerId, fullName, email);
    }

    @Override
    public int getMaxBorrowLimit() {
        return 3;
    }

    @Override
    public double calculateLateFee(int daysLate) {
        return daysLate * 2000.0;
    }

    @Override
    public String getInfo() {
        return "[Student] " + super.getInfo();
    }
}