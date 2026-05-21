public class Book {
    private String bookId;
    private String title;
    private String author;
    private int publishYear;
    private int quantity;

    public Book(String bookId, String title, String author, int publishYear, int quantity) {
        this.bookId = bookId;
        this.title = title;
        this.author = author;
        this.publishYear = publishYear;
        this.quantity = quantity;
    }

    // Nghiệp vụ: Kiểm tra còn hàng
    public boolean isAvailable() {
        return this.quantity > 0;
    }

    // Nghiệp vụ: Giảm kho khi mượn
    public void decreaseQuantity() {
        if (quantity > 0) quantity--;
    }

    // Nghiệp vụ: Tăng kho khi trả
    public void increaseQuantity() {
        quantity++;
    }

    // Getter và Setter
    public String getBookId() { return bookId; }
    public String getTitle() { return title; }
    public String getAuthor() { return author; }
    public int getQuantity() { return quantity; }
}