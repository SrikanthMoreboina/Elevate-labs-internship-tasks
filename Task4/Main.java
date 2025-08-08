import java.io.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String fileName = "notes.txt";

        while (true) {
            System.out.println("\n1. Write Note");
            System.out.println("2. Read Notes");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();
            sc.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter your note: ");
                    String note = sc.nextLine();
                    writeNote(fileName, note);
                    break;
                case 2:
                    readNotes(fileName);
                    break;
                case 3:
                    System.out.println("Exiting...");
                    sc.close();
                    return;
                default:
                    System.out.println("Invalid choice.");
            }
        }
    }

    // Method to write to a file
    public static void writeNote(String fileName, String note) {
        try (FileWriter writer = new FileWriter(fileName, true)) {
            writer.write(note + "\n");
            System.out.println("Note saved successfully.");
        } catch (IOException e) {
            System.out.println("An error occurred while writing: " + e.getMessage());
        }
    }

    // Method to read from a file
    public static void readNotes(String fileName) {
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            System.out.println("\nYour Notes:");
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println("- " + line);
            }
        } catch (FileNotFoundException e) {
            System.out.println("No notes found.");
        } catch (IOException e) {
            System.out.println("An error occurred while reading: " + e.getMessage());
        }
    }
}
