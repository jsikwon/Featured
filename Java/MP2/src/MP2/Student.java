package MP2;

public class Student implements Comparable<Student>{

    String name;
    double gpa;
    int studentID;
    static int maxStudentID;

    public Student(String name, double gpa) {
        super();
        this.name = name;
        this.gpa = gpa;
        this.studentID = ++maxStudentID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getGpa() {
        return gpa;
    }

    public void setGpa(double gpa) {
        this.gpa = gpa;
    }

    public static int getMaxStudentID() {
        return maxStudentID;
    }

    public static void setMaxStudentID(int maxStudentID) {
        Student.maxStudentID = maxStudentID;
    }

    @Override
    public String toString() {
        return "MP2.Student{" +
                "name='" + name + '\'' +
                ", gpa=" + gpa +
                ", studentID=" + studentID +
                '}';
    }

    @Override
    public int compareTo(Student o) {

        return studentID-o.studentID;
    }
//    @Override
//    public int compareTo(MP2.Student o) {
//
//        return name.compareTo(o.name);
//    }
}
