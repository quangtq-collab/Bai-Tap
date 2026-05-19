public class Rectangle {
    // Thuộc tính
    private double width;
    private double height;

    // Constructor
    public Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }

    // Phương thức tính diện tích
    public double area() {
        return width * height;
    }

    // Phương thức tính chu vi
    public double perimeter() {
        return (width + height) * 2;
    }

    // Kiểm tra xem có phải hình vuông không
    public boolean isSquare() {
        return width == height;
    }
}