import java.util.List;

public interface Searchable {
    List<Book> searchByTitle(String title);
    List<Book> searchByAuthor(String author);

    // Chuẩn hóa từ khóa tìm kiếm (Xóa khoảng trắng thừa, viết thường)
    static String normalizeKeyword(String keyword) {
        if (keyword == null) return "";
        return keyword.trim().toLowerCase();
    }
}