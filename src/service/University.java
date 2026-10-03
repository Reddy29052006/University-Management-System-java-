package service;

import java.util.Collection;
import java.util.HashMap;
import model.Course;
import model.Student;
import model.Teacher;

public class University {

    private final HashMap<Integer, Student> studentMap = new HashMap<>();
    private final HashMap<Integer, Teacher> teacherMap = new HashMap<>();
    private final HashMap<Integer, Course> courseMap = new HashMap<>();

    public void addCourse(String courseName, int credits) {
        Course course = new Course(courseName, credits);
        courseMap.put(course.getId(), course);
    }

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

    public Student getStudentByID(int id) {
        return studentMap.get(id);
    }

    public Course getCourseByID(int id) {
        return courseMap.get(id);
    }

    public Collection<Student> getAllStudents() {
        return studentMap.values();
    }

    public Collection<Teacher> getAllTeachers() {
        return teacherMap.values();
    }

    public Collection<Course> getAllCourse() {
        return courseMap.values();
    }
}
