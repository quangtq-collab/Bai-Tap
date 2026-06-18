public class Book implements Borrowable {
    private String bookId;
    private String title;
    private String author;
    private String currentBorrowerId; // null nếu chưa ai mượn
    private String borrowDate;

    public Book(String bookId, String title, String author) {
        this.bookId = bookId;
        this.title = title;
        this.author = author;
        this.currentBorrowerId = null;
        this.borrowDate = null;
    }

    @Override
    public void borrowBy(String readerId, String date) {
        if (isAvailable()) {
            this.currentBorrowerId = readerId;
            this.borrowDate = date;
            System.out.println("Sách '" + title + "' đã được cho mượn bởi độc giả: " + readerId);
        } else {
            System.out.println("Sách '" + title + "' hiện tại không có sẵn để mượn.");
        }
    }

    @Override
    public void returnBook(String date) {
        if (!isAvailable()) {
            System.out.println("Sách '" + title + "' đã được trả lại thư viện thành công.");
            this.currentBorrowerId = null;
            this.borrowDate = null;
        } else {
            System.out.println("Sách '" + title + "' hiện đang ở trong thư viện, không cần trả.");
        }
    }

    @Override
    public boolean isAvailable() {
        return this.currentBorrowerId == null;
    }

    @Override
    public String getBorrowerId() {
        return this.currentBorrowerId;
    }

    // Getters
    public String getBookId() { return bookId; }
    public String getTitle() { return title; }
    public String getAuthor() { return author; }
}