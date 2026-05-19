public class Book {
    String title;
    String author;
    int year;
    double price;

    // Constructor mặc định
    public Book() {
        this.title = "Unknown";
        this.author = "Unknown";
        this.year = 2000;
        this.price = 0;
    }

    // Constructor có 4 tham số
    public Book(String title, String author, int year, double price) {
        this.title = title;
        this.author = author;
        this.year = year;
        this.price = price;
    }

    // Phần mở rộng: Constructor 2 tham số
    public Book(String title, String author) {
        this.title = title;
        this.author = author;
        this.year = 2026;
        this.price = 100000;
    }

    public void displayInfo() {
        System.out.println("Sách: " + title + " - Tác giả: " + author + " - Năm: " + year + " - Giá: " + price);
    }

    public void applyDiscount(double percent) {
        if (percent > 0 && percent <= 100) {
            this.price = this.price * (1 - percent / 100);
        }
    }
}