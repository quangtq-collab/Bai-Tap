public class Product {
    String productCode;
    String productName;
    double price;

    // Constructor
    public Product(String productCode, String productName, double price) {
        this.productCode = productCode;
        this.productName = productName;
        this.price = price;
    }

    public void display() {
        System.out.printf("Sản phẩm: %s - Tên: %s - Giá bán: %,.0f\n", productCode, productName, price);
    }
}