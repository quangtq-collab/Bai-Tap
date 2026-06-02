public class Main {
    public static void main(String[] args) {
        Library library = new Library();

        Book b1 = new Book("B01", "Java Core Programming", "Author A", 5, false);
        Book b2 = new Book("B02", "Reference Algorithms", "Author B", 2, true);
        library.addBook(b1);
        library.addBook(b2);

        Reader sv = new StudentReader("SV01", "Nguyen Khac Trong");
        Reader senior = new SeniorReader("SE01", "Bac Nguyen Van C");
        Reader lecturer = new LecturerReader("GV01", "Tran Van D");
        library.addReader(sv);
        library.addReader(senior);
        library.addReader(lecturer);

        System.out.println("====== ASSIGNMENT-07: TEMPLATE METHOD ======\n");
        library.printAllReaders();

        System.out.println("\n--- CASE 1: Student borrow reference book ---");
        library.borrowBook(sv, b2);

        System.out.println("\n--- CASE 2: Senior borrow normal book ---");
        library.borrowBook(senior, b1);

        System.out.println("\n--- CASE 3: Lecturer borrow normal book ---");
        library.borrowBook(lecturer, b1);
    }
}
