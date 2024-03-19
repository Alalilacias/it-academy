package NonSprintEvaluations.Midterm03_19_2024.src.classes;

public enum MethodOfTransportation {
    FOOT(1.01),
    BICYCLE(1.02),
    MOTORCYCLE(1);

    private final double priceMultiplier;

    MethodOfTransportation(double priceMultiplier) {
        this.priceMultiplier = priceMultiplier;
    }

    public double getPriceMultiplier() {
        return priceMultiplier;
    }
}
