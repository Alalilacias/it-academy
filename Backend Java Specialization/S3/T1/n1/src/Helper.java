package S3.T1.n1.src;

import java.util.Scanner;

public class Helper {
    public static void testExercise(){
        Scanner scanner = new Scanner(System.in);
        Undo undo = Undo.getInstance();

        while (true) {
            System.out.println("Options:");
            System.out.println("1. Add Command");
            System.out.println("2. Remove Last Command");
            System.out.println("3. List Commands");
            System.out.println("4. Exit");
            System.out.print("Enter option: ");

            int option = scanner.nextInt();
            scanner.nextLine(); // Consume the newline

            switch (option) {
                case 1:
                    System.out.print("Enter command to add: ");
                    String commandToAdd = scanner.nextLine();
                    undo.addCommand(commandToAdd);
                    break;
                case 2:
                    undo.removeLastCommand();
                    System.out.println("Last command removed.");
                    break;
                case 3:
                    undo.listCommands();
                    break;
                case 4:
                    System.out.println("Exiting...");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid option. Try again.");
            }
        }
    }
}