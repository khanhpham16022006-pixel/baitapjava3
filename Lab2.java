import java.util.Scanner;

public class EngineTest {
    
    private String designer;
    private int power;


    public EngineTest() {
        this.designer = "";
        this.power = 0;
    }

    
    public EngineTest(String designer, int power) {
        this.designer = designer;
        this.power = power;
    }

    
    public String getDesigner() {
        String result = designer.length() > 3 ? designer.substring(0, 3) : designer;
        return result.substring(0, 1).toLowerCase() + result.substring(1);
    }

   
    public int getPower() {
        return power;
    }

   
    public void setPower(int power) {
        this.power = power;
    }

 
    @Override
    public String toString() {
        return "Designer: " + getDesigner() + ", Power: " + getPower();
    }

    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

   
        System.out.print("Enter designer: ");
        String designerInput = scanner.nextLine();

        System.out.print("Enter power: ");
        int powerInput = scanner.nextInt();


        EngineTest engine = new EngineTest(designerInput, powerInput);

        
        int choice;
        do {
            System.out.println("\n1. Test getDesigner()");
            System.out.println("2. Test setPower()");
            System.out.println("3. Test toString()");
            System.out.print("Enter TC (1, 2 or 3): ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                
                    System.out.println("OUTPUT:");
                    System.out.println(engine.getDesigner());
                    break;

                case 2:

                    System.out.print("Enter new power: ");
                    int newPower = scanner.nextInt();
                    engine.setPower(newPower);
                    System.out.println("OUTPUT:");
                    System.out.println(engine.getPower());
                    break;

                case 3:
                   
                    System.out.println("OUTPUT:");
                    System.out.println(engine.toString());
                    break;

                default:
                    System.out.println("Invalid choice. Please enter 1, 2, or 3.");
            }
        } while (choice != 4);

        scanner.close();
    }
}
