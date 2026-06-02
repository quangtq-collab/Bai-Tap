public class Book {
    private String bookId;
    private String title;
    private String author;
    private int quantity;

    public Book(String bookId, String title, String author, int quantity) {
        this.bookId = bookId;
        this.title = title;
        this.author = author;
        this.quantity = quantity;
    }

    public boolean isAvailable() {
        return this.quantity > 0;
    }

    public void decreaseQuantity() {
        if (this.quantity > 0) this.quantity--;
    }

    public void increaseQuantity() {
        this.quantity++;
    }

    public String getTitle() { return title; }
}