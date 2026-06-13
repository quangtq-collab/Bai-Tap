using System;

namespace OperatorApp
{
    public class Vector2D
    {
        // Thuộc tính
        public double X { get; private set; }
        public double Y { get; private set; }

        // Constructors
        public Vector2D() : this(0, 0) { }
        public Vector2D(double x, double y) { X = x; Y = y; }

        // Độ dài vector (Euclidean norm)
        public double DoDai => Math.Sqrt(X * X + Y * Y);

        // ==========================================
        // YÊU CẦU CƠ BẢN
        // ==========================================

        // Nạp chồng operator + để cộng hai vector
        public static Vector2D operator +(Vector2D a, Vector2D b)
            => new Vector2D(a.X + b.X, a.Y + b.Y);

        // Nạp chồng operator - để trừ hai vector
        public static Vector2D operator -(Vector2D a, Vector2D b)
            => new Vector2D(a.X - b.X, a.Y - b.Y);

        // Nhân scalar: Vector2D * double
        public static Vector2D operator *(Vector2D v, double k)
            => new Vector2D(v.X * k, v.Y * k);

        // Nhân scalar theo chiều ngược (tính giao hoán): double * Vector2D
        public static Vector2D operator *(double k, Vector2D v)
            => v * k;

        // Unary minus: đổi chiều vector
        public static Vector2D operator -(Vector2D v)
            => new Vector2D(-v.X, -v.Y);

        // Override ToString() theo dạng "(X, Y)" lấy 2 chữ số thập phân
        public override string ToString()
            => $"({X:F2}, {Y:F2})";

        // ==========================================
        // YÊU CẦU NÂNG CAO
        // ==========================================

        // 1. Cài đặt operator == và != để so sánh hai vector bằng nhau
        public static bool operator ==(Vector2D a, Vector2D b)
        {
            if (ReferenceEquals(a, b)) return true;
            if (a is null || b is null) return false;
            return a.X == b.X && a.Y == b.Y;
        }

        public static bool operator !=(Vector2D a, Vector2D b)
            => !(a == b);

        // Override Equals và GetHashCode khi nạp chồng == và != để tránh cảnh báo từ Compiler
        public override bool Equals(object obj)
        {
            if (obj is not Vector2D other) return false;
            return this.X == other.X && this.Y == other.Y;
        }

        public override int GetHashCode()
            => HashCode.Combine(X, Y);

        // 2. Tích vô hướng (dot product) giữa hai Vector2D (trả về kiểu double)
        public static double operator *(Vector2D v1, Vector2D v2)
            => v1.X * v2.X + v1.Y * v2.Y;

        // 3. Toán tử chuyển đổi implicit từ (double x, double y) tuple sang Vector2D
        public static implicit operator Vector2D((double x, double y) tuple)
            => new Vector2D(tuple.x, tuple.y);
    }
}