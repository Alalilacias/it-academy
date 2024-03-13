package S3.T1.n2.src.classes.agenda.others;

@SuppressWarnings("unused")
public enum Countries {
    FRANCE("+33"),
    GERMANY("+49"),
    SPAIN("+34");

    private final String prefix;

    Countries(String prefix) {
        this.prefix = prefix;
    }

    public String getPrefix() {
        return prefix;
    }
}
