package model;

public abstract class Person {

    private String name;
    private int age;

    public Person(String name, int age) {
        checkName(name);
        checkAge(age);
        this.name = name;
        this.age = age;
    }

    private void checkName(String name) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Name cannot be empty");
        }
    }

    private void checkAge(int age) {
        if (age <= 0) {
            throw new IllegalArgumentException("Age must be positive");
        }
    }

    protected void setName(String name) {
        checkName(name);
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    protected void setAge(int age) {
        checkAge(age);
        this.age = age;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Name: " + name + "\nAge: " + age + "\n";
    }

    public abstract void getRole();

    public abstract void displayDetails();

}
