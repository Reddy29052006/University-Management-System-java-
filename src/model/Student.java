package model;

public class Student extends Person implements Identifiable {

    private static int nextStudentId = 1;
    private final int studentId;

    public Student(String name, int age) {
        super(name, age);
        studentId = nextStudentId++;
    }

    @Override
    public int getId() {
        return studentId;
    }

    @Override
    public void getRole() {
        System.out.println("Role: Student");
    }

    @Override
    public void displayDetails() {
        System.out.println("Name: " + getName());
        System.out.println("Age: " + getAge());
    }

    public void displayStudentDetails(boolean showId) {
        if (showId) {
            System.out.println("Student ID: " + studentId);
        }
        displayDetails();
    }

    public void displayStudentDetails(String branch) {
        displayStudentDetails(true);
        System.out.println("Branch: " + branch);
    }

    @Override
    public String toString() {
        return "Student ID: " + studentId + "\n" + super.toString();
    }

}
