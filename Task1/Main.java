import java.util.*;

class Calculator {
    public int add(int x, int y) {
        return x + y;
    }

    public int sub(int x, int y) {
        return x - y;
    }

    public int mul(int x, int y) {
        return x * y;
    }

    public int div(int x, int y) {
        if (y != 0) {
            return x / y;
        } else {
            throw new ArithmeticException("Division by zero is undefined");
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Calculator obj = new Calculator();
        int choice;

        do {
            System.out.println("\n--- Calculator Menu ---");
            System.out.println("1. Add");
            System.out.println("2. Subtract");
            System.out.println("3. Multiply");
            System.out.println("4. Divide");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            if (choice >= 1 && choice <= 4) {
                System.out.print("Enter first number: ");
                int a = sc.nextInt();
                System.out.print("Enter second number: ");
                int b = sc.nextInt();

                try {
                    switch (choice) {
                        case 1:
                            System.out.println("Result: " + obj.add(a, b));
                            break;
                        case 2:
                            System.out.println("Result: " + obj.sub(a, b));
                            break;
                        case 3:
                            System.out.println("Result: " + obj.mul(a, b));
                            break;
                        case 4:
                            System.out.println("Result: " + obj.div(a, b));
                            break;
                    }
                } catch (ArithmeticException e) {
                    System.out.println("Error: " + e.getMessage());
                }
            } else if (choice != 5) {
                System.out.println("Invalid choice. Please try again.");
            }

        } while (choice != 5);

        System.out.println("Calculator exited.");
        sc.close();
    }
}
