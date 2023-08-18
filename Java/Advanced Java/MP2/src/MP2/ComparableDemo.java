package MP2;

public class ComparableDemo {
    public static void main(String[] args) {
        Student[] students = new Student[6];
        students[0] = new Student("Jun", 3.55);
        students[1] = new Student("Garrett", 3.45);
        students[2] = new Student("Victoria", 3.99);
        students[3] = new Student("Alex", 2.72);
        students[4] = new Student("Carlito", 3.94);
        students[5] = new Student("Maggie", 1.31);
        System.out.println("before sort");
        for (Student student : students) {
            System.out.println(student);
        }
        MySelectionSort.sort(students);
        System.out.println("after sort");
        for (Student student : students) {
            System.out.println(student);
        }

    }
}