package Katas.Kata05_16_2024.src;

import Katas.Kata05_16_2024.src.enu.HangmanGameWords;
import S1.T2.n2.exercise1.src.classes.Input;

import java.util.ArrayList;
import java.util.Random;

public class KataAndresYNiku {
    static String secretWord;
    static char[] secretWordArray;
    static ArrayList<Character> secretWordHiddenArray;
    static boolean isWon;
    protected static void run(){
        boolean isWon;
        getSecretWord();
        isWon = hangTheMan(secretWordArray);
        System.out.println(isWon
                ? "Congratulations, you've avoided death by hanging.\nThe word was " + secretWord
                : "We will give your family our condolences\nThe word was " + secretWord);
    }

    private static void getSecretWord() {
        int wordArrayLength = HangmanGameWords.values().length;
        int index = new Random().nextInt(wordArrayLength);
        secretWord = HangmanGameWords.values()[index].name().toLowerCase();
        secretWordArray = secretWord.toCharArray();
        secretWordHiddenArray = getHiddenSecretWordCharArray(secretWordArray);
    }

    private static ArrayList<Character> getHiddenSecretWordCharArray(char[] secretWord) {
        ArrayList<Character> hiddenArray = new ArrayList<>();
        for (char ignored : secretWord){
            hiddenArray.add('_');
        }
        return hiddenArray;
    }

    private static boolean hangTheMan(char[] secretWord) {
//        Set variables
        int opportunities = (int) (secretWord.length * 2.5);

//        Play Game
        do{
            askQuestions();
            isWon = !secretWordHiddenArray.contains('_');
            opportunities--;
        } while (opportunities > 0 && !isWon);

//        Give last opportunity
        if(!isWon){
            isWon = askWord();
        }
        return isWon;
    }

    private static void askQuestions() {
        boolean knowsWord = Input.readBoolean("Current letters: " + secretWordHiddenArray + "\nDo you know the word?");
        if(knowsWord){
            isWon = askWord();
            if(isWon){
                secretWordHiddenArray.clear();
                return;
            }
        }
        char answer = Input.readChar("Current letters: " + secretWordHiddenArray + "\nIntroduce your letter:");
        checkAndFill(answer);
    }

    private static void checkAndFill(char answer) {
        boolean anyMatch = false;
        for (int i = 0; i < secretWordArray.length; i++) {
            if(secretWordArray[i] == answer){
                anyMatch = true;
                secretWordHiddenArray.set(i, answer);
            }
        }

        if(anyMatch){
            System.out.println("Correct, " + answer + " was in the word.");
        } else {
            System.out.println("Nope");
        }
    }

    private static boolean askWord() {
        return Input.readString("Write below your best guess of the full word :)").equals(secretWord);
    }

}