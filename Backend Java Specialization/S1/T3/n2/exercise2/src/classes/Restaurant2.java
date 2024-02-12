package S1.T3.n2.exercise2.src.classes;

import java.util.Objects;

public class Restaurant2 implements Comparable<Restaurant2> {
    private String name;
    private int score;

    public Restaurant2(String name, int score) {
        this.name = name;
        this.score = score;
    }

    public String getName() {
        return this.name;
    }
    public int getScore() {
        return this.score;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int hashCode() {
        return Objects.hash(this.name, this.score);
    }
    @Override
    public boolean equals(Object o) {
        if (this == o){
            return true;
        }
        if (o == null || getClass() != o.getClass()){
            return false;
        }
        Restaurant2 that = (Restaurant2) o;
        return ((score == that.score) && (this.name.equals(that.name)));
    }
    @Override
    public int compareTo(Restaurant2 o) {
        return Integer.compare(o.getScore(), this.score);
    }
    @Override
    public String toString() {
        return name + "'s score: " + score;
    }
}
