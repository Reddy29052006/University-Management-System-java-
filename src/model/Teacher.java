package model;

public class Teacher extends Person implements Identifiable {

    private float salary;
    private static int nextTeacherId = 1;
    private final int teacherId;

    public Teacher(String name, int age, float salary) {
        super(name, age);
        checkSalary(salary);
        this.salary = salary;
        teacherId = nextTeacherId++;
    }

    @Override
    public int getId() {
        return teacherId;
    }

    public float getSalary() {
        return salary;
    }

    public void setSalary(float salary) {
        checkSalary(salary);
        this.salary = salary;
    }

    private void checkSalary(float salary) {
        if (salary <= 1000) {
            throw new IllegalArgumentException("Salary should be greater than 1,000");
        }
    }

    @Override
    public void getRole() {
        System.out.println("Role: Teacher");
    }

    @Override
    public void displayDetails() {
        System.out.println("Name: " + getName());
        System.out.println("Age: " + getAge());
        System.out.println("Salary: " + salary);
    }

    @Override
    public String toString() {
        return "teacherId :" + teacherId + "\n" + super.toString() + "\n" + "salary :" + salary + "\n";
    }
}
