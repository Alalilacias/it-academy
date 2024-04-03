package NonSprintEvaluations.Midterm03_19_2024.src.classes;

public enum Products {
    BURRITOS(6.5, "Pin"),
    BURGERS(8.9, "Cap"),
    KEBAB(4.5),
    PIZZA(7.9);

    private final double price;
    private String gift = null;

    Products(double price){
        this.price = price;
    }
    Products(double price, String gift){
        this.price = price;
        this.gift = gift;
    }

    public double getPrice(){
        return this.price;
    }
    @Override
    public String toString() {
        StringBuilder textToReturn = new StringBuilder();

        textToReturn.append("\n\t- ").append(this.name()).append(", price: ").append(this.price).append("€.");
        if(gift != null){
            textToReturn.append(" We have added a ").append(gift).append(" as a gift.");
        }

        return textToReturn.toString();
    }
}
