public class Main {
    public static void main(String[] args) {

        // =================================================================
        System.out.println("=== BAI 1: CLASS BOOK ===");
        Book b = new Book("Tam Quốc Diễn Nghĩa", "La Quán Trung");
        b.applyDiscount(20.0);
        b.displayInfo();

        // =================================================================
        System.out.println("\n=== BAI 2: CLASS RECTANGLE ===");
        Rectangle r = new Rectangle(1.0, 1.0);
        r.scale(2.0);
        r.display();

        // =================================================================
        System.out.println("\n=== BAI 3: CLASS BANKACCOUNT ===");
        BankAccount a1 = new BankAccount("1234567890", "Khách hàng A", 1000.0);
        BankAccount a2 = new BankAccount("8765432101", "Khách hàng B", 500.0);
        a1.transfer(a2, 200.0);
        a1.display();
        a2.display();

        // =================================================================
        System.out.println("\n=== BAI 4: CLASS EMPLOYEE ===");
        Employee emp = new Employee("NV01", "Nguyễn An", 15000000);
        emp.display();
        System.out.print("-> Thực lĩnh (gồm phụ cấp 4tr): ");
        System.out.printf("%,.0f\n", emp.calculateSalary(4000000));

        // =================================================================
        System.out.println("\n=== BAI 5: CLASS PRODUCT ===");
        Product p = new Product("T14", "Laptop LENOVO", 19000000);
        p.display();
    }
}