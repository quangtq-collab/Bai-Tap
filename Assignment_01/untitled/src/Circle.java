public class Circle {
    // Thuộc tính
    private double radius;

    // Constructor
    public Circle(double radius) {
        this.radius = radius;
    }

    // Tính diện tích: PI * r * r
    public double area() {
        return Math.PI * radius * radius;
    }

    // Tính chu vi (circumference): 2 * PI * r
    public double circumference() {
        return 2 * Math.PI * radius;
    }
}