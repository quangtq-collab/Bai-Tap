import java.util.ArrayList;
import java.util.List;

public class LibraryManager {

    // Xử lý đa hình với danh sách các đối tượng mượn được (Borrowable)
    public void processAllBorrowable(List<Borrowable> items) {
        System.out.println("=== BORROWABLE ITEM STATUS ===");
        for (Borrowable item : items) {
            String status = item.isAvailable()
                    ? "Sẵn sàng cho mượn"
                    : "Đang được mượn bởi ID: " + item.getBorrowerId();
            System.out.println("  -> " + status);
        }
    }

    // Xử lý đa hình gửi thông báo hàng loạt (Notifiable)
    public void notifyAll(List<Notifiable> users, String message) {
        System.out.println("=== SENDING NOTIFICATIONS ===");
        for (Notifiable user : users) {
            user.sendNotification(message);
        }
    }

    public static void main(String[] args) {
        LibraryManager mgr = new LibraryManager();

        // 1. Kiểm thử quản lý vật phẩm cho mượn (Borrowable)
        List<Borrowable> items = new ArrayList<>();
        Book b1 = new Book("B001", "Clean Code", "Robert Martin");
        Book b2 = new Book("B002", "Design Patterns", "GoF");

        // Mô phỏng mượn sách b1
        b1.borrowBy("R001", "2026-06-01");
        items.add(b1);
        items.add(b2);

        mgr.processAllBorrowable(items);

        // 2. Kiểm thử gửi thông báo hàng loạt (Notifiable)
        List<Notifiable> readers = new ArrayList<>();
        readers.add(new Reader("R001", "Nguyen Van A"));
        readers.add(new Reader("R002", "Tran Thi B"));

        mgr.notifyAll(readers, "Thư viện sẽ đóng cửa vào ngày lễ sắp tới.");

        // 3. Kiểm thử phương thức static trên interface
        int borrowDays = 10;
        System.out.println("\nThời gian mượn " + borrowDays + " ngày có hợp lệ không? "
                + Borrowable.isValidBorrowDuration(borrowDays));
    }
}