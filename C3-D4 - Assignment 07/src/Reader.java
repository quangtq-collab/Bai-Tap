// Reader.java — Lớp trừu tượng, định nghĩa Template Method cho quy trình mượn sách
public abstract class Reader {
    protected String readerId;
    protected String fullName;
    protected int currentBorrowCount;

    public Reader(String readerId, String fullName) {
        this.readerId = readerId;
        this.fullName = fullName;
        this.currentBorrowCount = 0;
    }

    // Abstract methods
    public abstract String getInfo();
    public abstract double calculateLateFee(int daysLate);
    public abstract int getMaxBorrowLimit();

    // Template Method: quy trình cho mượn chuẩn (4 bước cố định)
    public final BorrowResult processBorrow(Book book) {
        // Bước 1: kiểm tra quota
        if (!checkBorrowQuota()) {
            return new BorrowResult(false, "Đã đạt giới hạn mượn: " + getMaxBorrowLimit() + " cuốn");
        }
        // Bước 2: kiểm tra điều kiện đặc thù
        if (!checkSpecialCondition(book)) {
            return new BorrowResult(false, getSpecialConditionMessage());
        }
        // Bước 3: trừ tồn kho
        book.decreaseStock();
        currentBorrowCount++;
        // Bước 4: hook method
        onBorrowSuccess(book);
        return new BorrowResult(true, "Mượn thành công: " + book.getTitle());
    }

    private boolean checkBorrowQuota() {
        return currentBorrowCount < getMaxBorrowLimit();
    }

    protected abstract boolean checkSpecialCondition(Book book);
    protected abstract String getSpecialConditionMessage();

    protected void onBorrowSuccess(Book book) {
        System.out.println(fullName + " mượn: " + book.getTitle());
    }

    public String getFullName() { return fullName; }
}
