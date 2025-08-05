import java.util.*;

class Student {
    int id;
    String name;
    double marks;

    Student(int id, String name, double marks) {
        this.id = id;
        this.name = name;
        this.marks = marks;
    }

    public String toString() {
        return "ID: " + id + ", Name: " + name + ", Marks: " + marks;
    }
}

public class StudentManager {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Student> students = new ArrayList<>();
        int choice;

        do {
            System.out.println("\n--- Student Management Menu ---");
            System.out.println("1. Add Student");
            System.out.println("2. View Students");
            System.out.println("3. Update Student");
            System.out.println("4. Delete Student");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter ID: ");
                    int id = sc.nextInt();
                    sc.nextLine(); // consume leftover newline
                    System.out.print("Enter Name: ");
                    String name = sc.nextLine();
                    System.out.print("Enter Marks: ");
                    double marks = sc.nextDouble();
                    students.add(new Student(id, name, marks));
                    System.out.println(" Student added successfully.");
                    break;

                case 2:
                    if (students.isEmpty()) {
                        System.out.println("⚠ No students found.");
                    } else {
                        System.out.println(" List of Students:");
                        for (Student s : students) {
                            System.out.println(s);
                        }
                    }
                    break;

                case 3:
                    System.out.print("Enter ID of student to update: ");
                    int updateId = sc.nextInt();
                    boolean updated = false;
                    for (Student s : students) {
                        if (s.id == updateId) {
                            sc.nextLine(); // consume newline
                            System.out.print("Enter new name: ");
                            s.name = sc.nextLine();
                            System.out.print("Enter new marks: ");
                            s.marks = sc.nextDouble();
                            System.out.println("Student updated.");
                            updated = true;
                            break;
                        }
                    }
                    if (!updated) {
                        System.out.println(" Student with ID " + updateId + " not found.");
                    }
                    break;

                case 4:
                    System.out.print("Enter ID of student to delete: ");
                    int deleteId = sc.nextInt();
                    boolean removed = students.removeIf(s -> s.id == deleteId);
                    if (removed) {
                        System.out.println(" Student deleted.");
                    } else {
                        System.out.println("Student with ID " + deleteId + " not found.");
                    }
                    break;

                case 5:
                    System.out.println(" Exiting...");
                    break;

                default:
                    System.out.println(" Invalid choice. Try again.");
            }

        } while (choice != 5);

        sc.close();
    }
}
