package S3.T1.n1.src.classes;

import java.util.ArrayList;
import java.util.List;

// Singleton Enum representing the Undo command
enum Undo {
    INSTANCE;

    private final List<String> commandHistory = new ArrayList<>();

    public void addCommand(String command) {
        commandHistory.add(command);
        System.out.println("Command \"" + command + "\" added");
    }

    public void removeLastCommand() {
        if (commandHistory.isEmpty()) {
            System.out.println("No commands in history.");
        } else {
            System.out.println("Command \"" + commandHistory.getLast() + "\" removed.");
            commandHistory.removeLast();
        }
    }

    public void listCommands() {
        if (commandHistory.isEmpty()) {
            System.out.println("No commands in history.");
        } else {
            String textToPrint = "Command History:";
            for (int i = commandHistory.size() - 1; i >= 0; i--) {
                textToPrint = textToPrint.concat ("\n"+ (i + 1) + ". " + commandHistory.get(i) + ".");
            }
            System.out.println(textToPrint);
        }

    }
}

