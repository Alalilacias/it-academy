package Katas.Kata03_20_2024.src;

public enum Moves {
    ROCK,
    PAPER,
    SCISSORS;

    public String getName(){
        return this.name().toLowerCase();
    }
}
