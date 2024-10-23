import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Students {

    public static class Student implements Comparable<Student> {
        private String firstName;
        private String lastName;

        public double getGrade() {
            return grade;
        }

        private double grade;

        public int compareTo(Student other) {
            return Double.compare(other.grade, this.grade);
        }

        @Override
        public String toString() {
            return String.format("%s %s: %.2f", firstName, lastName, grade);
        }

        public Student(String firstName, String lastName, double grade) {
            this.firstName = firstName;
            this.lastName = lastName;
            this.grade = grade;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        ArrayList<Student> students = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String info = scanner.nextLine();
            String[] data = info.split(" ");
            String firstName = data[0];
            String lastName = data[1];
            double grade = Double.parseDouble(data[2]);


            Student student = new Student(firstName, lastName, grade);
            students.add(student);
        }
        Collections.sort(students);
        for (Student student : students) {
            System.out.println(student);
        }
    }
}
