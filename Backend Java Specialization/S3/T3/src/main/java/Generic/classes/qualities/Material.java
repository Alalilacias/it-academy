package Generic.classes.qualities;

public enum Material implements Generic.classes.qualities.Quality {
    WOOD,
    PLASTIC;

    @Override
    public String getName() {
        return name();
    }
}
