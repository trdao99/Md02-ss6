package ra.bussiness;

import java.util.Scanner;

public class BookManagement {
    public static Book listbooks = new Book();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean run = true;

        while (run) {
            System.out.println("****************JAVAVAVA-HACKATATHON-05-BASIC-MENU***************\n1. Nhập số lượng sách thêm mới và nhập thông tin cho từng cuốn sách \n2. Hiển thị thông tin tất cả sách trong thư viện \n3. Sắp xếp sách theo lợi nhuận tăng dần \n4. Xóa sách theo mã sách \n5. Tìm kiếm tương đối sách theo tên sách hoặc mô tả \n6. Thay đổi thông tin sách theo mã sách \n7. Thoát");
            System.out.println("\t *************************************");
            System.out.println("chọn chức năng");
            int chose = sc.nextInt();
            switch (chose) {
                case 1:
                    listbooks.inputData();
                    break;
                case 2:
                    listbooks.displayData();
                    break;
                case 3:
                    listbooks.sortInteres();
                    break;
                case 4:
                    listbooks.deleteBook();
                    break;
                case 5:
                    listbooks.findBook();
                    break;
                case 6:
                    listbooks.change();
                    break;
                case 7:
                    run = false;
                    break;
            }
        }
    }
}



