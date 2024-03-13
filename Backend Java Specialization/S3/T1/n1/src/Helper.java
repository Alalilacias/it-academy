package S3.T1.n1.src;

import java.util.Scanner;

public class Helper {
    public static void testExercise(){
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("""
                    Select your choice of action:
                    1. Add Command.
                    2. Remove Last Command.
                    3. List Commands.
                    4. Exit.
                    Your choice here:
                    """);

            int option = scanner.nextInt();
            scanner.nextLine(); // Consume the newline

            switch (option) {
                case 1:
                    System.out.print("Enter command to add: ");
                    String commandToAdd = scanner.nextLine();
                    Undo.INSTANCE.addCommand(commandToAdd);
                    break;
                case 2:
                    Undo.INSTANCE.removeLastCommand();
                    System.out.println("Last command removed.");
                    break;
                case 3:
                    Undo.INSTANCE.listCommands();
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