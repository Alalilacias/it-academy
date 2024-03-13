package S3.T1.n1.src;

import java.util.ArrayList;
import java.util.List;

// Singleton Enum representing the Undo command
enum Undo {
    INSTANCE;

    private final List<String> commandHistory = new ArrayList<>();

    public void addCommand(String command) {
        commandHistory.add(command);
    }

    public void removeLastCommand() {
        if (!commandHistory.isEmpty()) {
            commandHistory.removeLast();
        }
    }

    public void listCommands() {
        if (commandHistory.isEmpty()) {
            System.out.println("No commands in history.");
        } else {
            String textToPrint = "Command History:";
            for (int i = 0; i < commandHistory.size(); i++) {
                textToPrint = textToPrint.concat ((i + 1) + ". " + commandHistory.get(i));
            }
            System.out.println(textToPrint);
        }

    }
}

