1. Mô tả đề bài: Truy cập CSDL từ xa, theo mô hình client/server cho phép truy cập từ xa với số lượng lớn.
2. PP giải quyết:
- Lập trình Socket TCP
- Mỗi khi có client kết nối sẽ có một Thread phục vụ client đó.
3. Vấn đề
- Chưa có monitor để quản lý các Thread, gây tranh giành tài nguyên => kết quả bị sai.
4. Ngôn ngữ lập trình: Java, IDE: Eclipse
