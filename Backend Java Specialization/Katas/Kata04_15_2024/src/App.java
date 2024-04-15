package Katas.Kata04_15_2024.src;

import S1.T2.n2.exercise1.src.classes.Input;

public class App implements Runnable {
    @Override
    public void run() {
        while(true){
            switch (Input.readString("""
                    0. Exit.
                    1. Enter a command.
                    """)){
                case "0" -> {
                    System.out.println("Goodbye, then :(");
                    System.exit(0);
                }
                case "1" -> enterCommand();
                default -> System.out.println("Option not included, try again :/");
            }
        }
    }
    private static void enterCommand(){
        if (Input.readString("""
                Remember, in our console, the up, down, left and right keys are not available. Use their equivalents in the number pad.
                Introduce your command:
                """).equals("88224466BA")) {
            System.out.println("Oh look, a CHEATER!!! Welcome :)");
        } else {
            System.out.println("Invalid command, loser :)");
        }
    }
}
