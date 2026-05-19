class Book {
    // Thuộc tính
    String title;
    String author;
    double price;
    boolean inStock;

    // Constructor
    public Book(String title, String author, double price, boolean inStock) {
        this.title = title;
        this.author = author;
        this.price = price;
        this.inStock = inStock;
    }

    // Phương thức in thông tin sách
    public void printInfo() {
        System.out.println("Title: " + title);
        System.out.println("Author: " + author);
        System.out.println("Price: " + price);
        System.out.println("In Stock: " + inStock);
        System.out.println("--------------------------");
    }

    // Phương thức giảm giá theo phần trăm
    public void applyDiscount(double percent) {
        price = price - (price * percent / 100);
    }
}

public class Main {
    public static void main(String[] args) {

        // Tạo 3 object Book
        Book b1 = new Book("Java Basics", "Nguyen Van A", 100000, true);
        Book b2 = new Book("OOP in Java", "Tran Van B", 150000, true);
        Book b3 = new Book("Data Structures", "Le Van C", 200000, false);

        // In thông tin ban đầu
        System.out.println("=== BEFORE DISCOUNT ===");
        b1.printInfo();
        b2.printInfo();
        b3.printInfo();

        // Giảm giá 10%
        b1.applyDiscount(10);
        b2.applyDiscount(10);
        b3.applyDiscount(10);

        // In thông tin sau khi giảm
        System.out.println("=== AFTER DISCOUNT (10%) ===");
        b1.printInfo();
        b2.printInfo();
        b3.printInfo();
    }
}