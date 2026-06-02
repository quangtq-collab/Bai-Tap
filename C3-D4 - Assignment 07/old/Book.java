public class Book {
    private String bookId;
    private String title;
    private String author;
    private int quantity;
    private boolean referenceOnly;

    public Book(String bookId, String title, String author, int quantity, boolean referenceOnly) {
        this.bookId = bookId;
        this.title = title;
        this.author = author;
        this.quantity = quantity;
        this.referenceOnly = referenceOnly;
    }

    public boolean isAvailable() { return quantity > 0; }
    public boolean isReferenceOnly() { return referenceOnly; }

    public void decreaseStock() {
        if (quantity > 0) quantity--;
    }

    public void increaseQuantity() { quantity++; }

    public String getTitle() { return title; }
}
