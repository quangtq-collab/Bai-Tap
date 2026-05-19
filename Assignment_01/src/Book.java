public class Book {
    // Thuộc tính theo đề bài
    private String title;
    private String author;
    private double price;
    private boolean inStock;

    // Constructor để khởi tạo đối tượng
    public Book(String title, String author, double price, boolean inStock) {
        this.title = title;
        this.author = author;
        this.price = price;
        this.inStock = inStock;
    }

    // Phương thức in toàn bộ thông tin sách
    public void printInfo() {
        System.out.println("Sách: [" + title + "] - Tác giả: " + author +
                " | Giá: " + price + " | Còn hàng: " + (inStock ? "Có" : "Hết"));
    }

    // Phương thức giảm giá theo phần trăm
    public void applyDiscount(double percent) {
        if (percent > 0 && percent <= 100) {
            this.price = this.price * (1 - percent / 100);
        }
    }
}