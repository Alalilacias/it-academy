package NonSprintEvaluations.Midterm03_19_2024.src.classes;

public enum Products {
    BURRITOS("6.5€", "Pin"),
    BURGERS("8.9€", "Cap"),
    KEBAB("4.5€"),
    PIZZA("7.9€");

    private final String price;
    private String gift = null;

    Products(String price){
        this.price = price;
    }
    Products(String price, String gift){
        this.price = price;
        this.gift = gift;
    }

    public String getPrice(){
        return this.price;
    }
    @Override
    public String toString() {
        StringBuilder textToReturn = new StringBuilder();
        //noinspection StringConcatenationInsideStringBufferAppend
        textToReturn.append("\n\t\t- " + this.name() + ", price: " + this.price + ".");
        if(gift != null){
            textToReturn.append(" We have added a ").append(gift).append(" as a gift.");
        }

        return textToReturn.toString();
    }
}
