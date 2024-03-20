package Katas.Kata03_20_2024.src;

import S1.T2.n2.exercise1.src.classes.Input;

import java.util.Random;

public class Helper {
    protected static void testKata(){
        while(true){
            switch (Input.readInt("""
                    What would you like to do now?
                    1. Play.
                    2. Exit.
                    """)){
                case 1:
                    play();
                    break;
                case 2:
                    System.out.println("Thanks for playing.");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Option not available");
            }
        }
    }
    private static void play(){
        String userInput = Input.readString("Write your attack of choice (Rock, paper or scissors)").toLowerCase();
        if (!((userInput.equals("rock")) || (userInput.equals("paper")) || (userInput.equals("scissor")))){
            System.out.println("That is not an acceptable attack.");
            return;
        }
        Moves userMove = Moves.valueOf(userInput);
        System.out.println("User move: " + userMove);
        result(userMove, getMachineMove());
    }
    private static Moves getMachineMove(){
        Moves machineMove = Moves.values()[new Random().nextInt(3)];
        System.out.println("Machine move: " + machineMove.getName());
        return machineMove;
    }
    private static void result(Moves userMove, Moves machineMove){
        if (userMove.getName().equals(machineMove.getName())){
            System.out.println("It's a tie!");
            return;
        }
        if(((userMove.equals(Moves.ROCK)) && (machineMove.equals(Moves.SCISSORS))) ||
            ((userMove.equals(Moves.PAPER)) && (machineMove.equals(Moves.ROCK))) ||
            ((userMove.equals(Moves.SCISSORS)) && (machineMove.equals(Moves.PAPER)))) {
            System.out.println("User wins!");
            return;
        }
        System.out.println("User loses...");
    }
}
