


import Lab2.Engine;
import java.util.Scanner;

public class Lab2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input designer and power from the user
        System.out.print("Enter designer: ");
        String designerInput = scanner.nextLine();

        System.out.print("Enter power: ");
        int powerInput = scanner.nextInt();

        // Create an Engine object using the parameterized constructor
        Engine engine = new Engine(designerInput, powerInput);

        // Display the menu and allow the user to choose options
        int choice;
        do {
            System.out.println("\n1. Test getDesigner()");
            System.out.println("2. Test setPower()");
            System.out.println("3. Test toString()");
            System.out.print("Enter TC (1 or 2 or 3): ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    // Test getDesigner() method
                    System.out.println("OUTPUT:");
                    System.out.println(engine.getDesigner());
                    break;

                case 2:
                    // Test setPower() and getPower() methods
                    System.out.print("Enter new power: ");
                    int newPower = scanner.nextInt();
                    engine.setPower(newPower);
                    System.out.println("OUTPUT:");
                    System.out.println(engine.getPower());
                    break;

                case 3:
                    // Test toString() method
                    System.out.println("OUTPUT:");
                    System.out.println(engine.toString());
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 4);

        scanner.close();
    }
}