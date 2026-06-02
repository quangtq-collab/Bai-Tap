// DesignAnalysis.java — Phân tích thiết kế hệ thống

/*
==========================
PHẦN CƠ BẢN
==========================
1. Quan hệ Composition (HAS-A):
   - Library HAS-A Book: vì thư viện quản lý nhiều sách, không phải là một loại sách.
   - Library HAS-A Reader: vì thư viện quản lý nhiều độc giả, không phải là một loại độc giả.
   - Library HAS-A BorrowSlip: vì thư viện quản lý các phiếu mượn, không phải là một loại phiếu.
   => Dùng Composition thay vì kế thừa để phản ánh quan hệ sở hữu/quản lý.

2. Quan hệ Inheritance (IS-A):
   - StudentReader IS-A Reader: kế thừa hợp lý vì sinh viên là một loại độc giả.
   - SeniorReader IS-A Reader: kế thừa hợp lý vì người cao tuổi là một loại độc giả.
   - LecturerReader IS-A Reader: kế thừa hợp lý vì giảng viên là một loại độc giả.
   => Dùng kế thừa để chia sẻ Template Method và đặc tả hành vi riêng.

3. Điểm cải thiện thiết kế:
   - Hiện tại phí phạt được tính trực tiếp trong từng lớp Reader.
   - Có thể cải thiện bằng cách áp dụng Strategy Pattern (LateFeePolicy) để tách riêng chính sách phí phạt.
   - Điều này giúp dễ dàng thay đổi hoặc thêm mới chính sách mà không cần sửa code trong Reader.

==========================
PHẦN NÂNG CAO
==========================
Tình huống: Librarian kế thừa sai chỗ

1. Phân tích vi phạm:
   (a) Librarian có IS-A Reader không? → Không. Thủ thư không phải là độc giả, họ không mượn sách, không bị tính phí phạt.
   (b) 3 câu kiểm tra (A.2.1):
       - “Mọi Librarian đều là Reader?” → Sai.
       - “Mọi Reader đều là Librarian?” → Sai.
       - “Có hành vi chung để chia sẻ?” → Không, nghiệp vụ khác hẳn.
   (c) Thiết kế này vi phạm nguyên tắc Liskov Substitution (LSP) và nguyên tắc IS-A.

2. Refactor bằng Composition:
   - Librarian không kế thừa Reader, thay vào đó HAS-A Library.
   - Librarian xử lý cho mượn/trả qua đa hình Reader.processBorrow() (Template Method).
   - Thiết kế mới an toàn: không thể thêm Librarian vào danh sách Reader.

3. Kết quả kiểm thử:
   - Librarian xử lý cho mượn cho StudentReader và SeniorReader đúng logic.
   - Nếu cố gắng `library.addReader(libr)` → lỗi compile, đảm bảo không còn tình trạng thủ thư bị coi là độc giả.
*/
