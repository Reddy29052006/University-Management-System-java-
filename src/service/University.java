package service;

import java.util.Collection;
import java.util.HashMap;
import model.Student;
import model.Teacher;

public class University {

    private final HashMap<Integer, Student> studentMap = new HashMap<>();
    private final HashMap<Integer, Teacher> teacherMap = new HashMap<>();

    public void addTeacher(String name, int age, int salary) {
        Teacher teacher = new Teacher(name, age, salary);
        teacherMap.put(teacher.getId(), teacher);
    }

    public void addStudent(String name, int age) {
        Student student = new Student(name, age);
        studentMap.put(student.getId(), student);
    }

    public Teacher getTeacherByID(int id) {
        return teacherMap.get(id);
    }

    public Collection<Student> getAllStudents() {
        return studentMap.values();
    }

    public Student getStudentByID(int id) {
        return studentMap.get(id);
    }

    public Collection<Teacher> getAllTeachers() {
        return teacherMap.values();
    }

}
