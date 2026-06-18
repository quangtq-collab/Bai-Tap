import java.util.ArrayList;
import java.util.List;

public class Library implements Searchable {
    private List<Book> books = new ArrayList<>();

    public void addBook(Book book) {
        books.add(book);
    }

    @Override
    public List<Book> searchByTitle(String title) {
        List<Book> result = new ArrayList<>();
        String cleanKeyword = Searchable.normalizeKeyword(title);
        for (Book b : books) {
            if (b.getTitle().toLowerCase().contains(cleanKeyword)) {
                result.add(b);
            }
        }
        return result;
    }

    @Override
    public List<Book> searchByAuthor(String author) {
        List<Book> result = new ArrayList<>();
        String cleanKeyword = Searchable.normalizeKeyword(author);
        for (Book b : books) {
            if (b.getAuthor().toLowerCase().contains(cleanKeyword)) {
                result.add(b);
            }
        }
        return result;
    }
}