package S1.T3.n2.exercise1.src.classes;

import java.util.Objects;

public class Restaurant {
    private String name;
    private int score;

    public Restaurant (String name, int score) {
        this.name = name;
        this.score = score;
    }

    public String getName() {
        return this.name;
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
        Restaurant that = (Restaurant) o;
        return ((score == that.score) && (this.name.equals(that.name)));
    }

    @Override
    public String toString() {
        return name + "'s score: " + score;
    }
}
