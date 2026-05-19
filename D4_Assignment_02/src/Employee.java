public class Employee {
    String id;
    String name;
    double baseSalary;

    // Constructor
    public Employee(String id, String name, double baseSalary) {
        this.id = id;
        this.name = name;
        this.baseSalary = baseSalary;
    }

    // Giả sử có phương thức tăng lương theo hệ số
    public double calculateSalary(double allowance) {
        return this.baseSalary + allowance;
    }

    public void display() {
        System.out.printf("Nhân viên: [%s] %s - Lương cơ bản: %,.0f\n", id, name, baseSalary);
    }
}