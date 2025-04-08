package business.modal;

import java.util.Scanner;

public class Student {
    Scanner sc = new Scanner(System.in);
    private int id;
    private String name;
    private int age;
    private boolean status;
    public Student() {};
    public Student(int id, String name, int age, boolean status) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
    public void inputData(){
        System.out.println("Nhap ten sinh vien: ");
        this.name = sc.nextLine();
        System.out.println("Nhap tuoi sinh vien: ");
        this.age = sc.nextInt();
        System.out.println("Nhap trang thai sinh vien: ");
        this.status = sc.nextBoolean();
    }
    @Override
    public String toString() {
        return String.format("| %-2d | %-14s | %-3d | %-8s |", id, name, age, status);
    }
}
