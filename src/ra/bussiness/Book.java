package ra.bussiness;

import java.util.Scanner;

public class Book {
    private int bookId;
    private String bookName;
    private String author;
    private String descriptions;
    private double importPrice;
    private double exportPrice;
    private float interest;
    private boolean bookStatus;

    public Book() {
    }

    public Book(int bookId, String bookName, String author, String descriptions, double importPrice, double exportPrice, float interest, boolean bookStatus) {
        this.bookId = bookId;
        this.bookName = bookName;
        this.author = author;
        this.descriptions = descriptions;
        this.importPrice = importPrice;
        this.exportPrice = exportPrice;
        this.interest = interest;
        this.bookStatus = bookStatus;
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getDescriptions() {
        return descriptions;
    }

    public void setDescriptions(String descriptions) {
        this.descriptions = descriptions;
    }

    public double getImportPrice() {
        return importPrice;
    }

    public void setImportPrice(double importPrice) {
        this.importPrice = importPrice;
    }

    public double getExportPrice() {
        return exportPrice;
    }

    public void setExportPrice(double exportPrice) {
        this.exportPrice = exportPrice;
    }

    public float getInterest() {
        return interest;
    }

    public void setInterest(float interest) {
        this.interest = interest;
    }

    public boolean isBookStatus() {
        return bookStatus;
    }

    public void setBookStatus(boolean bookStatus) {
        this.bookStatus = bookStatus;
    }


    Book[] listBooks = new Book[100];
    int lenght = 0;

    public void inputData() {
        Scanner sc = new Scanner(System.in);
        System.out.println("nhập số lượng sách muốn thêm: ");
        int add = Integer.parseInt(sc.nextLine());
        for (int i = lenght; i < add; i++) {
            listBooks[i] = new Book();
            listBooks[i].setBookId(i + 1);


            while (true) {
                System.out.println("nhập tên sách: ");
                String name = sc.nextLine();
                if (name.equals("")) {
                    System.out.println("không được để trống");
                } else {
                    listBooks[i].setBookName(name);
                    break;
                }
            }

            while (true) {
                System.out.println("nhập tên tác giả: ");
                String auThor = sc.nextLine();
                if (auThor.equals("")) {
                    System.out.println("không được để trống");
                } else {
                    listBooks[i].setAuthor(auThor);
                    break;
                }
            }

            while (true) {
                System.out.println("nhập mô tả sách: ");
                String descrip = sc.nextLine();
                if (descrip.equals("")) {
                    System.out.println("không được để trống");
                } else if (descrip.length() < 10) {
                    System.out.println("phải có ít nhất 10 ký tự");
                } else {
                    listBooks[i].setDescriptions(descrip);
                    break;
                }
            }
            int inPrice;
            int outPrice;
            while (true) {
                System.out.println("giá nhập: ");
                inPrice = Integer.parseInt(sc.nextLine());
                if (inPrice <= 0) {
                    System.out.println("giá phải lớn hơn 0");
                } else {
                    listBooks[i].setImportPrice(inPrice);
                    break;
                }
            }

            while (true) {
                System.out.println("giá xuất: ");
                outPrice = Integer.parseInt(sc.nextLine());
                if (outPrice >= inPrice * 1.2) {
                    listBooks[i].setExportPrice(outPrice);
                    break;
                } else {
                    System.out.println("phải lớn hơn 1.2 lần giá nhập");
                }
            }


            System.out.println("tình trạng sách(true/false): ");
            boolean defaul = true;
            boolean status = Boolean.parseBoolean(sc.nextLine());
            if (status != defaul) {
                listBooks[i].setBookStatus(status);
            } else {
                listBooks[i].setBookStatus(defaul);
            }

            listBooks[i].setInterest((float) (outPrice - inPrice));

            lenght++;
        }
    }

    public void displayData() {
        for (int i = 0; i < lenght; i++) {
            System.out.println("id sách: " + listBooks[i].getBookId() + " | " +
                    "tên sách: " + listBooks[i].getBookName() + " | " +
                    "tên tác giả: " + listBooks[i].getAuthor() + " | " +
                    "\n mô tả sách: " + listBooks[i].getDescriptions() +
                    "\n giá nhập: " + listBooks[i].getImportPrice() +
                    "\n giá xuất: " + listBooks[i].getExportPrice() +
                    "\n lợi nhuận: " + listBooks[i].getInterest() +
                    "\n tình trạng: " + (listBooks[i].bookStatus ? "còn hàng" : "hết hàng"));
            System.out.println("________________________________");
        }
    }

    public void sortInteres() {
        for (int i = 0; i < lenght - 1; i++) {
            for (int j = i + 1; j < lenght; j++) {
                if (listBooks[i].getInterest() > listBooks[j].getInterest()) {
                    Book compe = listBooks[i];
                    listBooks[i] = listBooks[j];
                    listBooks[j] = compe;
                }
            }
        }
        displayData();
    }

    public void deleteBook() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Chọn mã sách muốn xóa: ");
        int id = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < lenght; i++) {
            if (listBooks[i].getBookId() == id) {
                for (int j = i; j < lenght - 1; j++) {
                    listBooks[j] = listBooks[j + 1];
                }
                listBooks[lenght - 1] = null;
                lenght--;
                break;
            }
        }
    }

    public void findBook() {
        Scanner sc = new Scanner(System.in);
        System.out.println("nhập tên sách muốn tìm");
        String nameFind = sc.nextLine();
        for (int i = 0; i < lenght; i++) {
            if (listBooks[i].getBookName().equals(nameFind)) {
                System.out.println("id sách: " + listBooks[i].getBookId() + " | " +
                        "tên sách: " + listBooks[i].getBookName() + " | " +
                        "tên tác giả: " + listBooks[i].getAuthor() + " | " +
                        "\n mô tả sách: " + listBooks[i].getDescriptions() +
                        "\n giá nhập: " + listBooks[i].getImportPrice() +
                        "\n giá xuất: " + listBooks[i].getExportPrice() +
                        "\n lợi nhuận: " + listBooks[i].getInterest() +
                        "\n tình trạng: " + (listBooks[i].bookStatus ? "còn hàng" : "hết hàng"));
                System.out.println("________________________________");
                break;
            }
        }
    }

    public void change() {
        Scanner sc = new Scanner(System.in);
        System.out.println("nhập mã sách muốn thay ");
        int id = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < lenght; i++) {
            if (listBooks[i].getBookId() == id) {
                while (true) {
                    System.out.println("nhập tên sách: ");
                    String name = sc.nextLine();
                    if (name.equals("")) {
                        System.out.println("không được để trống");
                    } else {
                        listBooks[i].setBookName(name);
                        break;
                    }
                }

                while (true) {
                    System.out.println("nhập tên tác giả: ");
                    String auThor = sc.nextLine();
                    if (auThor.equals("")) {
                        System.out.println("không được để trống");
                    } else {
                        listBooks[i].setAuthor(auThor);
                        break;
                    }
                }

                while (true) {
                    System.out.println("nhập mô tả sách: ");
                    String descrip = sc.nextLine();
                    if (descrip.equals("")) {
                        System.out.println("không được để trống");
                    } else if (descrip.length() < 10) {
                        System.out.println("phải có ít nhất 10 ký tự");
                    } else {
                        listBooks[i].setDescriptions(descrip);
                        break;
                    }
                }
                int inPrice;
                int outPrice;
                while (true) {
                    System.out.println("giá nhập: ");
                    inPrice = Integer.parseInt(sc.nextLine());
                    if (inPrice <= 0) {
                        System.out.println("giá phải lớn hơn 0");
                    } else {
                        listBooks[i].setImportPrice(inPrice);
                        break;
                    }
                }

                while (true) {
                    System.out.println("giá xuất: ");
                    outPrice = Integer.parseInt(sc.nextLine());
                    if (outPrice >= inPrice * 1.2) {
                        listBooks[i].setExportPrice(outPrice);
                        break;
                    } else {
                        System.out.println("phải lớn hơn 1.2 lần giá nhập");
                    }
                }


                System.out.println("tình trạng sách(true/false): ");
                boolean defaul = true;
                boolean status = Boolean.parseBoolean(sc.nextLine());
                if (status != defaul) {
                    listBooks[i].setBookStatus(status);
                } else {
                    listBooks[i].setBookStatus(defaul);
                }

                listBooks[i].setInterest((float) (outPrice - inPrice));
            }
        }
    }

}
