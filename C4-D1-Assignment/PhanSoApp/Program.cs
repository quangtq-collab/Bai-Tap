using System;

namespace PhanSoApp
{
    class Program
    {
        static void Main(string[] args)
        {
            // Đảm bảo hiển thị đúng các ký tự tiếng Việt (nếu có) trên Console
            Console.OutputEncoding = System.Text.Encoding.UTF8;

            // =================================================================
            Console.WriteLine("=== KIỂM TRA BÀI TẬP 1: LỚP PHÂN SỐ CƠ BẢN ===");
            // =================================================================
            
            PhanSo b1_1 = new PhanSo(2, 4);
            Console.WriteLine($"new PhanSo(2, 4)  => ToString() in ra: “{b1_1}”"); // In ra: 1/2

            PhanSo b1_2 = new PhanSo(1, -3);
            Console.WriteLine($"new PhanSo(1, -3) => ToString() in ra: “{b1_2}”"); // In ra: -1/3

            try
            {
                Console.WriteLine("Thử nghiệm tạo phân số với mẫu bằng 0...");
                PhanSo b1_3 = new PhanSo(1, 0);
            }
            catch (ArgumentException ex)
            {
                Console.WriteLine($"=> Kết quả: Ném thành công ArgumentException. Message: {ex.Message}");
            }


            // =================================================================
            Console.WriteLine("\n=== KIỂM TRA BÀI TẬP 2: TOÁN TỬ SỐ HỌC ===");
            // =================================================================
            
            PhanSo ps1 = new PhanSo(1, 2);  // 1/2
            PhanSo ps2 = new PhanSo(1, 3);  // 1/3

            Console.WriteLine($"ps1 = {ps1}");
            Console.WriteLine($"ps2 = {ps2}");
            Console.WriteLine($"ps1 + ps2 = {ps1 + ps2}");  // Kết quả mong muốn: 5/6
            Console.WriteLine($"ps1 - ps2 = {ps1 - ps2}");  // Kết quả mong muốn: 1/6
            Console.WriteLine($"ps1 * ps2 = {ps1 * ps2}");  // Kết quả mong muốn: 1/6
            Console.WriteLine($"ps1 / ps2 = {ps1 / ps2}");  // Kết quả mong muốn: 3/2

            // Kiểm tra yêu cầu nâng cao (Cộng phân số với số nguyên)
            Console.WriteLine($"ps1 + 2   = {ps1 + 2}");      // Kết quả mong muốn: 5/2 (Do 1/2 + 2/1)


            // =================================================================
            Console.WriteLine("\n=== KIỂM TRA BÀI TẬP 3: TOÁN TỬ SO SÁNH ===");
            // =================================================================
            
            PhanSo p3_1 = new PhanSo(1, 2);  // 1/2
            PhanSo p3_2 = new PhanSo(2, 4);  // 2/4 (= 1/2 sau khi rút gọn)
            PhanSo p3_3 = new PhanSo(1, 3);  // 1/3

            Console.WriteLine($"ps1 == ps2 : {p3_1 == p3_2}");  // True  (1/2 == 2/4)
            Console.WriteLine($"ps1 != ps3 : {p3_1 != p3_3}");  // True  (1/2 != 1/3)
            Console.WriteLine($"ps3 < ps1  : {p3_3 < p3_1}");   // True  (1/3 < 1/2)
            Console.WriteLine($"ps1 > ps3  : {p3_1 > p3_3}");   // True  (1/2 > 1/3)

            Console.WriteLine("\n--- Nhấn Enter để kết thúc chương trình ---");
            Console.ReadLine();
        }
    }
}