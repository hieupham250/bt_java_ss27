package presentation;

import business.model.Student;
import business.service.Student.StudentServices;
import business.service.Student.studentServiceIpm;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class StudentUI {
    public static Scanner sc = new Scanner(System.in);
    private final StudentServices studentServices;
    public StudentUI() {
        studentServices = new studentServiceIpm();
    }
    public static void displayMenu() {
        Scanner sc = new Scanner(System.in);
        StudentUI studentUI = new StudentUI();
        do {
            System.out.println("********** MEU STUDENT **********");
            System.out.println("1. Danh sach sinh vien");
            System.out.println("2. Them moi sinh vien");
            System.out.println("3. Cap nhat sinh vien");
            System.out.println("4. Xoa sinh vien");
            System.out.println("5. Thong ke sinh vien theo trang thai");
            System.out.println("6. Thoat");
            System.out.println("Nhap lua chon cua ban: ");
            int choice = sc.nextInt();
            sc.nextLine();
            switch (choice) {
                case 1:
                    studentUI.displayStudent();
                    break;
                case 2:
                    studentUI.addStudent();
                    break;
                case 3:
                    studentUI.updateStudent();
                    break;
                case 4:
                    studentUI.deleteStudent();
                    break;
                case 5:
                    studentUI.countStudentByStatus();
                    break;
                case 6:
                    System.out.println("Thoat");
                    return;
                default:
                    System.out.println("Lua chon khong hop le");
                    break;
            }
        } while (true);
    }
    public void displayStudent() {
        List<Student> listStudents = studentServices.getAll();
        listStudents.forEach(System.out::println);
    }

    public void addStudent() {
        System.out.println("Nhập vào số sinh viên cần thêm mới:");
        int size = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < size; i++) {
            Student student = new Student();
            student.inputData();
            boolean result = studentServices.add(student);
            if (result) {
                System.out.println("Thêm mới thành công");
            } else {
                System.err.println("Có lỗi trong quá trình thêm mới");
            }
        }
    }
    public void updateStudent() {
        System.out.println("Nhập mã sinh viên: ");
        int id = sc.nextInt();
        sc.nextLine();
        Optional<Student> isCheck = studentServices.getAll().stream().filter(student -> student.getId() == id).findFirst();
        if (isCheck.isPresent()) {
            Student student = isCheck.get();
            System.out.println("Nhập tên mới của sinh viên: ");
            String name = sc.nextLine();
            student.setName(name);
            System.out.println("Nhập tuổi mới của sinh viên: ");
            int age = sc.nextInt();
            student.setAge(age);
            System.out.println("Nhập trạng thái mới của sinh viên: ");
            boolean status = sc.nextBoolean();
            student.setStatus(status);
            boolean result = studentServices.update(student);
            if (result) {
                System.out.println("Cập nhật thành công");
            } else {
                System.err.println("Có lỗi trong quá trình cập nhật");
            }
        } else {
            System.err.println("Sinh viên không tồn tại");
        }
    }
    public void deleteStudent() {
        System.out.println("Nhập mã sinh viên: ");
        int id = sc.nextInt();
        sc.nextLine();
        Optional<Student> isCheck = studentServices.getAll().stream().filter(student -> student.getId() == id).findFirst();
        if (isCheck.isPresent()) {
            Student student = isCheck.get();
            boolean result = studentServices.delete(student);
            if (result) {
                System.out.println("Xóa thành công");
            } else {
                System.err.println("Có lỗi trong quá trình xóa");
            }
        } else {
            System.err.println("Sinh viên không tồn tại");
        }
    }
    public void countStudentByStatus() {
        System.out.println("Nhap trang thai sinh vien: ");
        boolean status = sc.nextBoolean();
        System.out.println("C0 "+ studentServices.getCountStudentByStatus(status) + " sinh vien co trang thai la: "+status);
    }
}
