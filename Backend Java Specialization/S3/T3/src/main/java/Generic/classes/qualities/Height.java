package Generic.classes.qualities;

public enum Height implements Generic.classes.qualities.Quality {
    SMALL,
    MEDIUM,
    TALL;

    @Override
    public String getName() {
        return name();
    }
}
