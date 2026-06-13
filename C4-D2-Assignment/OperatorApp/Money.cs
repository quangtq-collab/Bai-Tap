using System;

namespace OperatorApp
{
    public class Money
    {
        // Thuộc tính
        public decimal Amount { get; private set; }
        public string Currency { get; private set; }

        // Constructor kèm validate dữ liệu đầu vào
        public Money(decimal amount, string currency)
        {
            if (amount < 0)
                throw new ArgumentException("So tien khong the am!");
            
            Amount = amount;
            Currency = currency.ToUpper();
        }

        // Hàm kiểm tra cùng đơn vị tiền tệ để tái sử dụng
        private static void KiemTraCungDonVi(Money a, Money b)
        {
            if (a.Currency != b.Currency)
            {
                throw new InvalidOperationException(
                    $"Khong the thuc hien phep toan giua {a.Currency} va {b.Currency}. " +
                    $"Vui long quy doi ve cung don vi truoc.");
            }
        }

        // ==========================================
        // YÊU CẦU CƠ BẢN
        // ==========================================

        // Cộng hai khoản tiền cùng đơn vị
        public static Money operator +(Money a, Money b)
        {
            KiemTraCungDonVi(a, b);
            return new Money(a.Amount + b.Amount, a.Currency);
        }

        // Trừ hai khoản tiền cùng đơn vị
        public static Money operator -(Money a, Money b)
        {
            KiemTraCungDonVi(a, b);
            if (a.Amount < b.Amount)
                throw new InvalidOperationException("Ket qua tru khong duoc am!");
            return new Money(a.Amount - b.Amount, a.Currency);
        }

        // Nhân tiền với một hệ số decimal
        public static Money operator *(Money m, decimal heSo)
        {
            if (heSo < 0)
                throw new ArgumentException("He so khong the am!");
            return new Money(m.Amount * heSo, m.Currency);
        }

        public static Money operator *(decimal heSo, Money m) => m * heSo;

        // Toán tử so sánh > và <
        public static bool operator >(Money a, Money b)
        {
            KiemTraCungDonVi(a, b);
            return a.Amount > b.Amount;
        }

        public static bool operator <(Money a, Money b)
        {
            KiemTraCungDonVi(a, b);
            return a.Amount < b.Amount;
        }

        // Override ToString() định dạng phân cách hàng nghìn
        public override string ToString()
            => $"{Amount:N0} {Currency}";

        // ==========================================
        // YÊU CẦU NÂNG CAO
        // ==========================================

        // 1. Thêm phương thức static QuyDoi hỗ trợ quy đổi đơn vị theo tỷ giá tỉ lệ thuận
        public static Money QuyDoi(Money nguon, string donViDich, decimal tyGia)
        {
            if (tyGia <= 0)
                throw new ArgumentException("Ty gia phai lon hon 0!");
            return new Money(nguon.Amount * tyGia, donViDich);
        }

        // 2. Cài đặt operator == và != cho Money (khác đơn vị luôn != nhau)
        public static bool operator ==(Money a, Money b)
        {
            if (ReferenceEquals(a, b)) return true;
            if (a is null || b is null) return false;
            if (a.Currency != b.Currency) return false; // Khác đơn vị tiền tệ mặc định không bằng nhau
            return a.Amount == b.Amount;
        }

        public static bool operator !=(Money a, Money b)
            => !(a == b);

        public override bool Equals(object obj)
        {
            if (obj is not Money other) return false;
            return this.Amount == other.Amount && this.Currency == other.Currency;
        }

        public override int GetHashCode()
            => HashCode.Combine(Amount, Currency);

        // 3. Thêm toán tử / để chia tiền cho một số nguyên/decimal (ví dụ chia hóa đơn)
        public static Money operator /(Money m, decimal chiaSo)
        {
            if (chiaSo == 0)
                throw new DivideByZeroException("Khong the chia cho so 0!");
            if (chiaSo < 0)
                throw new ArgumentException("So chia khong the am!");
            return new Money(m.Amount / chiaSo, m.Currency);
        }
    }
}