
import java.util.Scanner;
import service.University;

public class Main {

    public static void main(String[] args) {
        System.out.println("-------welcome to lakshmi University------\n");
        Scanner sc = new Scanner(System.in);
        University university = new University();

        menu:
        while (true) {
            System.out.println("1. Enroll as Student");
            System.out.println("2. Enroll as Teacher");
            System.out.println("3. Exit");

            int choose = sc.nextInt();
            sc.nextLine();

            switch (choose) {
                case 1 -> {
                    System.out.println("Enter your name:");
                    String name = sc.nextLine().trim();
                    System.out.println("Enter your age:");
                    int age = Integer.parseInt(sc.nextLine());
                    university.addStudent(name, age);
                }

                case 2 -> {
                    System.out.println("Enter your name:");
                    String name = sc.nextLine().trim();
                    System.out.println("Enter your age:");
                    int age = Integer.parseInt(sc.nextLine());
                    System.out.println("enter your salary :");
                    int salary = Integer.parseInt(sc.nextLine());
                    university.addTeacher(name, age, salary);
                }

                case 3 -> {
                    break menu;
                }
                default ->
                    System.out.println("Enter valid option");
            }
        }
    }
}
