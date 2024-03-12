package S3.T1.n1.src;
import java.util.ArrayList;
import java.util.List;

public class Undo {
    private static Undo instance;
    @SuppressWarnings("FieldMayBeFinal")
    private List<String> commandHistory;

    private Undo() {
        commandHistory = new ArrayList<>();
    }

    public static Undo getInstance() {
        if (instance == null) {
            instance = new Undo();
        }
        return instance;
    }

    public void addCommand(String command) {
        commandHistory.add(command);
    }

    @SuppressWarnings("SequencedCollectionMethodCanBeUsed")
    public void removeLastCommand() {
        if (!commandHistory.isEmpty()) {
            commandHistory.remove(commandHistory.size() - 1);
        }
    }

    public void listCommands() {
        if (commandHistory.isEmpty()) {
            System.out.println("No commands in history.");
        } else {
            System.out.println("Command History:");
            for (int i = 0; i < commandHistory.size(); i++) {
                System.out.println((i + 1) + ". " + commandHistory.get(i));
            }
        }
    }
}
