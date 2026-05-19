class Circle {
    // Thuộc tính
    double radius;

    // Constructor
    public Circle(double radius) {
        this.radius = radius;
    }

    // Tính diện tích
    public double area() {
        return Math.PI * radius * radius;
    }

    // Tính chu vi
    public double circumference() {
        return 2 * Math.PI * radius;
    }
}

public class Main {
    public static void main(String[] args) {

        // Tạo mảng 5 object Circle
        Circle[] circles = new Circle[5];

        circles[0] = new Circle(1);
        circles[1] = new Circle(2);
        circles[2] = new Circle(3);
        circles[3] = new Circle(4);
        circles[4] = new Circle(5);

        double totalArea = 0;

        // Duyệt mảng và tính tổng diện tích
        for (int i = 0; i < circles.length; i++) {
            double area = circles[i].area();
            double circumference = circles[i].circumference();

            System.out.println("Circle " + (i + 1));
            System.out.println("Radius: " + circles[i].radius);
            System.out.println("Area: " + area);
            System.out.println("Circumference: " + circumference);
            System.out.println("----------------------");

            totalArea += area;
        }

        // In tổng diện tích
        System.out.println("Total Area of all circles: " + totalArea);
    }
}
