class Rectangle {
    // Thuộc tính
    double width;
    double height;

    // Constructor
    public Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }

    // Tính diện tích
    public double area() {
        return width * height;
    }

    // Tính chu vi
    public double perimeter() {
        return 2 * (width + height);
    }

    // Kiểm tra có phải hình vuông không
    public boolean isSquare() {
        return width == height;
    }
}

public class Main {
    public static void main(String[] args) {

        // Tạo 2 object Rectangle
        Rectangle r1 = new Rectangle(5, 10);
        Rectangle r2 = new Rectangle(7, 7);

        // In thông tin r1
        System.out.println("=== Rectangle 1 ===");
        System.out.println("Area: " + r1.area());
        System.out.println("Perimeter: " + r1.perimeter());
        System.out.println("Is Square: " + r1.isSquare());

        // In thông tin r2
        System.out.println("=== Rectangle 2 ===");
        System.out.println("Area: " + r2.area());
        System.out.println("Perimeter: " + r2.perimeter());
        System.out.println("Is Square: " + r2.isSquare());
    }
}