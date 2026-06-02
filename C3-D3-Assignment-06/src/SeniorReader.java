public class SeniorReader extends Reader {

    public SeniorReader(String readerId, String fullName, String email) {
        super(readerId, fullName, email);
    }

    @Override
    public int getMaxBorrowLimit() {
        return Integer.MAX_VALUE; // Không giới hạn số lượng mượn
    }

    @Override
    public double calculateLateFee(int daysLate) {
        return 0.0; // Miễn phí phạt hoàn toàn
    }

    // --- ĐÚNG MẪU: Gọi super.getInfo() rồi nối thêm chuỗi định danh vào cuối ---
    @Override
    public String getInfo() {
        return super.getInfo() + " [NCT - MIEN PHAT]";
    }
}