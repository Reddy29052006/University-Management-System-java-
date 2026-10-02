package model;

public class Course {

    private final int courseId;
    private String courseName;
    private int credits;
    private static int nextCourseId = 1;

    public Course(String courseName, int credits) {

        if (isValidCourceName(courseName)) {
            throw new IllegalArgumentException("Course name cannot be empty");
        }

        if (!isValidCredit(credits)) {
            throw new IllegalArgumentException("Credits must be greater than 0");
        }

        this.courseName = courseName;
        this.credits = credits;
        this.courseId = nextCourseId++;
    }

    private boolean isValidCourceName(String courseName) {
        return courseName == null || courseName.isBlank();
    }

    private boolean isValidCredit(int credits) {
        return credits > 0;
    }

    public void displayCourseDetails() {
        System.out.println("credits :" + credits);
        System.out.println("course Name :" + courseName);
    }

    public void displayCourseDetails(boolean showId) {
        if (showId) {
            System.out.println("course id :" + courseId);
        }
        displayCourseDetails();
    }

    public int getCourseId() {
        return courseId;
    }

    public String getCourseName() {
        return courseName;
    }

    public int getCredits() {
        return credits;
    }

    @Override
    public String toString() {
        return "course id" + courseId + "\n" + "credits :" + credits + "\n" + "course Name :" + courseName;
    }

}
