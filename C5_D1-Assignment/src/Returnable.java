public interface Returnable {
    void confirmReturn(String date);       // Xác nhận ngày trả thực tế
    boolean isLate(String currentDate);    // Kiểm tra xem có bị trễ hạn hay không
}