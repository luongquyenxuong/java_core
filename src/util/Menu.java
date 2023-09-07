package util;

public class Menu {

    private Menu() {
    }

    public static void printMenu() {
        System.out.println("Chọn chức năng:");
        System.out.println("1. Thêm sách");
        System.out.println("2. Hiện thị danh sách");
        System.out.println("3. Sắp xếp tăng dần theo giá");
        System.out.println("4. Sắp xếp giảm dần theo giá");
        System.out.println("5. Sắp xếp theo tên");
        System.out.println("6. Lưu thư viện vào tệp");
        System.out.println("7. Đọc thư viện từ tệp");
        System.out.println("8. Tìm kiếm theo tên");
        System.out.println("0. Thoát");
    }

}
