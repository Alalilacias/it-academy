package Generic.classes.qualities;

public enum Color implements Generic.classes.qualities.Quality {
    RED,
    ORANGE,
    YELLOW,
    GREEN,
    BLUE,
    INDIGO,
    VIOLET,
    WHITE,
    PINK;

    @Override
    public String getName() {
        return name();
    }
}
