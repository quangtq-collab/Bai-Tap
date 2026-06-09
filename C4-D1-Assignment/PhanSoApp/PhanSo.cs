using System;

namespace PhanSoApp
{
    public class PhanSo
    {
        // 1. Thuộc tính (Properties)
        public int TuSo { get; private set; }
        public int MauSo { get; private set; }

        // 2. Hàm khởi tạo (Constructor)
        public PhanSo(int tuSo, int mauSo)
        {
            if (mauSo == 0)
                throw new ArgumentException("Mau so khong duoc bang 0!");

            // Xử lý dấu: đưa dấu âm lên tử số nếu có
            if (mauSo < 0)
            {
                tuSo = -tuSo;
                mauSo = -mauSo;
            }

            // Tự động rút gọn phân số ngay khi khởi tạo
            int ucln = UCLN(Math.Abs(tuSo), mauSo);
            TuSo = tuSo / ucln;
            MauSo = mauSo / ucln;
        }

        // 3. Phương thức trợ giúp private tĩnh tính UCLN (Thuật toán Euclid)
        private static int UCLN(int a, int b)
        {
            while (b != 0)
            {
                int t = b;
                b = a % b;
                a = t;
            }
            return a;
        }

        // 4. Phương thức rút gọn (Vì constructor đã làm, nên chỉ cần trả về một phân số mới)
        public PhanSo RutGon()
        {
            return new PhanSo(TuSo, MauSo);
        }

        // 5. Ghi đè phương thức ToString()
        public override string ToString()
        {
            if (MauSo == 1) return TuSo.ToString();
            return $"{TuSo}/{MauSo}";
        }

        // --- BÀI TẬP 2: NẠP CHỒNG TOÁN TỬ SỐ HỌC ---

        // Toán tử cộng hai phân số
        public static PhanSo operator +(PhanSo ps1, PhanSo ps2)
        {
            int tu = ps1.TuSo * ps2.MauSo + ps2.TuSo * ps1.MauSo;
            int mau = ps1.MauSo * ps2.MauSo;
            return new PhanSo(tu, mau);
        }

        // Toán tử trừ hai phân số
        public static PhanSo operator -(PhanSo ps1, PhanSo ps2)
        {
            int tu = ps1.TuSo * ps2.MauSo - ps2.TuSo * ps1.MauSo;
            int mau = ps1.MauSo * ps2.MauSo;
            return new PhanSo(tu, mau);
        }

        // Toán tử nhân hai phân số
        public static PhanSo operator *(PhanSo ps1, PhanSo ps2)
        {
            int tu = ps1.TuSo * ps2.TuSo;
            int mau = ps1.MauSo * ps2.MauSo;
            return new PhanSo(tu, mau);
        }

        // Toán tử chia hai phân số
        public static PhanSo operator /(PhanSo ps1, PhanSo ps2)
        {
            if (ps2.TuSo == 0)
                throw new DivideByZeroException("Khong the chia cho phan so co gia tri bang 0!");

            int tu = ps1.TuSo * ps2.MauSo;
            int mau = ps1.MauSo * ps2.TuSo;
            return new PhanSo(tu, mau);
        }

        // Yêu cầu nâng cao: Toán tử cộng Phân số với Số nguyên (PhanSo + int)
        public static PhanSo operator +(PhanSo ps, int value)
        {
            return ps + new PhanSo(value, 1);
        }

        // (Tùy chọn thêm để logic hoàn chỉnh hơn): Số nguyên + Phân số (int + PhanSo)
        public static PhanSo operator +(int value, PhanSo ps)
        {
            return new PhanSo(value, 1) + ps;
        }


        // --- BÀI TẬP 3: NẠP CHỒNG TOÁN TỬ SO SÁNH ---

        // Toán tử so sánh bằng (==)
        public static bool operator ==(PhanSo ps1, PhanSo ps2)
        {
            // Xử lý trường hợp một hoặc cả hai đối tượng bị null
            if (ReferenceEquals(ps1, null) && ReferenceEquals(ps2, null)) return true;
            if (ReferenceEquals(ps1, null) || ReferenceEquals(ps2, null)) return false;

            // Vì đã được rút gọn trong Constructor nên chỉ cần so sánh tử với tử, mẫu với mẫu
            return ps1.TuSo == ps2.TuSo && ps1.MauSo == ps2.MauSo;
        }

        // Toán tử so sánh không bằng (!=) - Bắt buộc đi kèm với ==
        public static bool operator !=(PhanSo ps1, PhanSo ps2)
        {
            return !(ps1 == ps2);
        }

        // Toán tử nhỏ hơn (<)
        public static bool operator <(PhanSo ps1, PhanSo ps2)
        {
            // Do mẫu số luôn dương sau khi qua constructor, ta chỉ cần so sánh tích chéo
            return ps1.TuSo * ps2.MauSo < ps2.TuSo * ps1.MauSo;
        }

        // Toán tử lớn hơn (>) - Bắt buộc đi kèm với <
        public static bool operator >(PhanSo ps1, PhanSo ps2)
        {
            return ps1.TuSo * ps2.MauSo > ps2.TuSo * ps1.MauSo;
        }

        // Ghi đè Equals và GetHashCode để tránh Warning từ Compiler
        public override bool Equals(object obj)
        {
            if (obj is PhanSo other)
            {
                return this == other;
            }
            return false;
        }

        public override int GetHashCode()
        {
            // Trả về hash code kết hợp của TuSo và MauSo
            return HashCode.Combine(TuSo, MauSo);
        }
    }
}