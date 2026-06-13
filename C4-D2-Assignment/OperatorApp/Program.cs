using System;

namespace OperatorApp
{
    class Program
    {
        static void Main(string[] args)
        {
            // Thiết lập mã hóa UTF-8 để hiển thị tiếng Việt có dấu trên Console không bị lỗi
            Console.OutputEncoding = System.Text.Encoding.UTF8;

            // ==========================================
            // KIỂM TRA BÀI TẬP 1: VECTOR2D
            // ==========================================
            Console.WriteLine("=== TEST BÀI TẬP 1: VECTOR2D ===");
            Vector2D v1 = new Vector2D(3, 4);
            Vector2D v2 = new Vector2D(1, 2);

            Console.WriteLine($"v1 = {v1}");             // (3.00, 4.00)
            Console.WriteLine($"v2 = {v2}");             // (1.00, 2.00)
            Console.WriteLine($"v1 + v2 = {v1 + v2}");  // (4.00, 6.00)
            Console.WriteLine($"v1 - v2 = {v1 - v2}");  // (2.00, 2.00)
            Console.WriteLine($"v1 * 2  = {v1 * 2}");   // (6.00, 8.00)
            Console.WriteLine($"3 * v2  = {3 * v2}");   // (3.00, 6.00)
            Console.WriteLine($"-v1    = {-v1}");        // (-3.00, -4.00)
            Console.WriteLine($"|v1|   = {v1.DoDai:F4}"); // 5.0000

            // Kiểm tra nâng cao Vector2D
            Console.WriteLine("\n--- Tính năng nâng cao Vector2D ---");
            Vector2D v3 = new Vector2D(3, 4);
            Console.WriteLine($"So sánh v1 == v3 (Cùng tọa độ): {v1 == v3}"); // True
            Console.WriteLine($"So sánh v1 != v2 (Khác tọa độ): {v1 != v2}"); // True
            
            double dotProduct = v1 * v2; // Tích vô hướng: 3*1 + 4*2 = 11
            Console.WriteLine($"Tích vô hướng v1 * v2 = {dotProduct}"); // 11

            Vector2D vImplicit = (5.0, 6.0); // Chuyển đổi ngầm định tự động từ Tuple
            Console.WriteLine($"Vector khởi tạo ngầm định từ tuple (5.0, 6.0): {vImplicit}");


            Console.WriteLine("\n" + new string('=', 45) + "\n");


            // ==========================================
            // KIỂM TRA BÀI TẬP 2: MONEY
            // ==========================================
            Console.WriteLine("=== TEST BÀI TẬP 2: MONEY ===");
            Money luong      = new Money(15_000_000, "VND");
            Money thuong     = new Money(3_000_000, "VND");
            Money lamThemGio = luong * 1.5m;  

            Console.WriteLine($"Lương cơ bản:   {luong}");
            Console.WriteLine($"Thưởng tháng:   {thuong}");
            Console.WriteLine($"Lương làm thêm: {lamThemGio}");
            Console.WriteLine($"Tổng thu nhập:  {luong + thuong}");
            Console.WriteLine($"Lương > Thưởng: {luong > thuong}");  // True

            // Kiểm tra bẫy logic – Tính toán trên hai đơn vị tiền tệ khác nhau
            try
            {
                Money usd = new Money(100, "USD");
                Console.WriteLine("\nThử cộng Lương (VND) + 100 USD...");
                Money tong = luong + usd;  // Sẽ ném ra ngoại lệ tại đây!
            }
            catch (InvalidOperationException ex)
            {
                Console.WriteLine($"Bẫy logic hoạt động tốt! Lỗi bắt được: {ex.Message}");
            }

            // Kiểm tra nâng cao Money
            Console.WriteLine("\n--- Tính năng nâng cao Money ---");
            Money usd100 = new Money(100, "USD");
            Money vndQuyDoi = Money.QuyDoi(usd100, "VND", 25500m);
            Console.WriteLine($"Quy đổi tĩnh 100 USD sang VND (Tỷ giá 25,500): {vndQuyDoi}");

            Money m1 = new Money(500, "USD");
            Money m2 = new Money(500, "VND");
            Console.WriteLine($"So sánh m1 == m2 (Cùng Amount nhưng khác đơn vị): {m1 == m2}"); // False

            Money tongHoaDon = new Money(1200000, "VND");
            Money phanCua1Nguoi = tongHoaDon / 4;
            Console.WriteLine($"Chia hóa đơn {tongHoaDon} cho 4 người: {phanCua1Nguoi} / người");

            Console.WriteLine("\nNhấn Enter để thoát chương trình...");
            Console.ReadLine();
        }
    }
}