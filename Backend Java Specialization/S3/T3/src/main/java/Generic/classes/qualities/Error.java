package Generic.classes.qualities;

public enum Error implements Generic.classes.qualities.Quality {
    TREE,
    FLOWER,
    DECORATION,
    ERROR;

    @Override
    public String getName() {
        return name();
    }
}
