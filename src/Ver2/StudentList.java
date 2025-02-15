package Ver2;
import java.util.ArrayList;
class StudentList {
    private ArrayList<Student> studentList;

    public StudentList() {
        this.studentList = new ArrayList<>();
    }
    public void addStudent(Student student) {
        studentList.add(student);
        System.out.println("Student added: " + student.getFullName());
    }
    public void deleteStudentById(String id) {
        studentList.removeIf(student -> student.getId().equals(id));
        System.out.println("Deleted student with ID: " + id);
    }
    public Student findStudentById(String id) {
        for (Student student : studentList) {
            if (student.getId().equals(id)) {
                return student;
            }
        }
        return null;
    }
    public void displayAllStudents() {
        for (Student student : studentList) {
            student.displayInfo();
        }
    }
    public Student findTopStudent() {
        if (studentList.isEmpty()) {
            return null;
        }
        Student topStudent = studentList.get(0);
        for (Student student : studentList) {
            if (student.getGpa() > topStudent.getGpa()) {
                topStudent = student;
            }
        }
        return topStudent;
    }
    public ArrayList<Student> findScholarshipStudents() {
        ArrayList<Student> scholarshipStudents = new ArrayList<>();
        for (Student student : studentList) {
            if (student.hasScholarship()) {
                scholarshipStudents.add(student);
            }
        }
        return scholarshipStudents;
    }
    public double calculateTuitionOfAllStudents() {
        double totalTuition = 0;
        for (Student student : studentList) {
            totalTuition += student.calculateTuition();
        }
        return totalTuition;
    }
}
