// BorrowResult.java — Lớp hỗ trợ để trả về kết quả giao dịch mượn sách
public class BorrowResult {
    private boolean success;
    private String message;

    public BorrowResult(boolean success, String message) {
        this.success = success;
        this.message = message;
    }

    public boolean isSuccess() { return success; }
    public String getMessage() { return message; }
}
