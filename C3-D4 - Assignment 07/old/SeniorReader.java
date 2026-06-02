public class SeniorReader extends Reader {
    public SeniorReader(String readerId, String fullName) {
        super(readerId, fullName);
    }

    @Override
    public int getMaxBorrowLimit() { return Integer.MAX_VALUE; }

    @Override
    public double calculateLateFee(int daysLate) { return 0.0; }

    @Override
    public String getInfo() { return "ID: " + readerId + " | Name: " + fullName + " [NCT - MIEN PHAT]"; }

    @Override
    protected boolean checkSpecialCondition(Book book) { return true; }

    @Override
    protected String getSpecialConditionMessage() { return ""; }

    @Override
    protected void onBorrowSuccess(Book book) {
        super.onBorrowSuccess(book);
        System.out.println("  -> Đã ghi nhận: Người cao tuổi — miễn phí phạt");
    }
}
