import java.util.ArrayList;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        class Student {
            private String name;

            public int getStudentID() {
                return studentID;
            }

            public void setStudentID(int studentID) {
                this.studentID = studentID;
            }

            private int studentID;

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            Student(String name, int studentID) {
                this.name = name;
                this.studentID = studentID;
            }
        }
        ArrayList<Student> studentList = new ArrayList<>();
        Student alan = new Student("Alan", 2155960);
        studentList.add(alan);
        Student alex = new Student("Alex", 1952150);
        studentList.add(alex);
        Student claire = new Student("Claire", 2368507);
        studentList.add(claire);
        Student candice = new Student("Candice", 1569870);
        studentList.add(candice);

        for(Student display: studentList) {
            System.out.println(display.getName() + " (" + display.getStudentID() + ")");
        }

        System.out.print("Search students: ");
        Scanner reader = new Scanner(System.in);
        String searchTerm = reader.nextLine();
        
        for(Student search: studentList) {
            if(search.getName().contains(searchTerm)) {
                System.out.println(search.getName() + " (" + search.getStudentID() + ")");
            }
        }
    }
}
