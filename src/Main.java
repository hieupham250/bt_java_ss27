import presentation.StudentUI;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        do {
            System.out.println("********* MENU ********* ");
            System.out.println("1. Quan li sinh vien");
            System.out.println("2. Quan li lop hoc");
            System.out.println("3. Thoat");
            System.out.println("Nhap lua chon cua ban: ");
            int choice = sc.nextInt();
            switch (choice) {
                case 1:
                    StudentUI.displayMenu();
                    break;
                case 2:
                    break;
                case 3:
                    System.out.println("Thoat chuong trinh");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Lua chon khong hop le");
                    break;
            }
        } while (true);
    }
}
