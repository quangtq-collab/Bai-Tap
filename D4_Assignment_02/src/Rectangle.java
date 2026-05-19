public class Rectangle {
    double width;
    double height;

    // Constructor mặc định
    public Rectangle() {
        this.width = 1.0;
        this.height = 1.0;
    }

    // Constructor đầy đủ tham số
    public Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }

    // Phương thức tính diện tích
    public double getArea() {
        return this.width * this.height;
    }

    // Phương thức phóng to/thu nhỏ kích thước theo tỷ lệ
    public void scale(double factor) {
        if (factor > 0) {
            this.width *= factor;
            this.height *= factor;
        }
    }

    public void display() {
        System.out.println("Hình chữ nhật: Rộng = " + width + ", Dài = " + height + " -> Diện tích = " + getArea());
    }
}