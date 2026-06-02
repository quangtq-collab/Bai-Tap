import java.util.ArrayList;
import java.util.List;

public class Library {
    private final List<Book> books = new ArrayList<>();
    private final List<Reader> readers = new ArrayList<>();

    public void addBook(Book book) { books.add(book); }
    public void addReader(Reader reader) { readers.add(reader); }

    public void borrowBook(Reader reader, Book book) {
        BorrowResult result = reader.processBorrow(book);
        System.out.println(result.getMessage());
    }

    public void printAllReaders() {
        System.out.println("=== SYSTEM READERS LIST ===");
        for (Reader r : readers) {
            System.out.println(r.getInfo());
        }
    }
}
