// Main.java — Kiểm thử các kịch bản mượn sách theo Template Method + FeeStrategy
public class Main {
    public static void main(String[] args) {
        Library library = new Library();

        // Nạp kho sách (b2 là sách tham khảo)
        Book b1 = new Book("B01", "Java Core Programming", "Author A", 5, false);
        Book b2 = new Book("B02", "Reference Algorithms", "Author B", 2, true);
        library.addBook(b1);
        library.addBook(b2);

        // Nạp độc giả
        Reader sv = new StudentReader("SV01", "Nguyen Khac Trong");
        Reader senior = new SeniorReader("SE01", "Bac Nguyen Van C");
        Reader lecturer = new LecturerReader("GV01", "Tran Van D");
        library.addReader(sv);
        library.addReader(senior);
        library.addReader(lecturer);

        System.out.println("====== ASSIGNMENT-07: TEMPLATE METHOD + STRATEGY ======\n");
        library.printAllReaders();

        // CASE 1: Student mượn sách tham khảo
        System.out.println("\n--- CASE 1: Student borrow reference book ---");
        library.borrowBook(sv, b2);

        // CASE 2: Senior mượn sách thường
        System.out.println("\n--- CASE 2: Senior borrow normal book ---");
        library.borrowBook(senior, b1);

        // CASE 3: Lecturer mượn sách thường
        System.out.println("\n--- CASE 3: Lecturer borrow normal book ---");
        library.borrowBook(lecturer, b1);

        // CASE 4: Kiểm thử FeeStrategy
        System.out.println("\n--- CASE 4: FeeStrategy demonstration ---");
        LateFeePolicy full = new FullFeePolicy();
        LateFeePolicy discount = new DiscountFeePolicy();
        LateFeePolicy noFee = new NoFeePolicy();

        double baseFee = 20000; // giả định phí cơ bản
        System.out.println("FullFeePolicy: " + full.applyPolicy(baseFee));
        System.out.println("DiscountFeePolicy: " + discount.applyPolicy(baseFee));
        System.out.println("NoFeePolicy: " + noFee.applyPolicy(baseFee));
    }
}

