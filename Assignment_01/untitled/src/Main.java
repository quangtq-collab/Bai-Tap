public class Main {
    public static void main(String[] args) {

        // ==================== BÀI 1: CLASS BOOK ====================
        System.out.println("=== BÀI 1: CLASS BOOK ===");
        // Tạo 3 object Book khác nhau
        Book book1 = new Book("Java Basics", "Nguyen Van A", 150000, true);
        Book book2 = new Book("OOP Basics", "Tran Thi B", 200000, true);
        Book book3 = new Book("Data Analysis", "Le Van C", 250000, false);

        System.out.println("--- Thông tin ban đầu ---");
        book1.printInfo();
        book2.printInfo();
        book3.printInfo();

        System.out.println("\n--- Áp dụng giảm giá 10% ---");
        book1.applyDiscount(10);
        book2.applyDiscount(10);
        book3.applyDiscount(10);

        book1.printInfo();
        book2.printInfo();
        book3.printInfo();


        // ==================== BÀI 2: CLASS RECTANGLE ====================
        System.out.println("\n=== BÀI 2: CLASS RECTANGLE ===");
        // Tạo 2 object Rectangle
        Rectangle r1 = new Rectangle(5.0, 10.0);
        Rectangle r2 = new Rectangle(6.0, 6.0);

        System.out.println("Hình 1 -> Diện tích: " + r1.area() + " | Chu vi: " + r1.perimeter() + " | Là hình vuông? " + r1.isSquare());
        System.out.println("Hình 2 -> Diện tích: " + r2.area() + " | Chu vi: " + r2.perimeter() + " | Là hình vuông? " + r2.isSquare());


        // ==================== BÀI 3: CLASS CIRCLE ====================
        System.out.println("\n=== BÀI 3: CLASS CIRCLE (NÂNG CAO) ===");
        // Tạo mảng chứa 5 object Circle với bán kính khác nhau
        Circle[] circles = new Circle[5];
        circles[0] = new Circle(1.5);
        circles[1] = new Circle(2.0);
        circles[2] = new Circle(3.5);
        circles[3] = new Circle(4.0);
        circles[4] = new Circle(5.5);

        // Duyệt mảng để tính tổng diện tích của tất cả các hình tròn
        double totalArea = 0;
        for (int i = 0; i < circles.length; i++) {
            totalArea += circles[i].area();
        }

        // In kết quả tổng diện tích tròn
        System.out.printf("Tổng diện tích của cả 5 hình tròn là: %.2f\n", totalArea);
    }
}