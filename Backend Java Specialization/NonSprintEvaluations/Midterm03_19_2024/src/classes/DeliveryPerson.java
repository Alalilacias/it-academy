package NonSprintEvaluations.Midterm03_19_2024.src.classes;

public class DeliveryPerson {
    private final String name;
    private final MethodOfTransportation methodOfTransportation;

    public DeliveryPerson(Builder builder){
        this.name = builder.name;
        this.methodOfTransportation = builder.methodOfTransportation;
    }

    public double getPriceMultiplier(){
        return this.methodOfTransportation.getPriceMultiplier();
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name + ", Transportation: " + this.methodOfTransportation.name().toLowerCase() + ".";
    }

//    Ya sé que no te gustan las inner nested classes pero si no la hago aquí dentro, tendría que llamarla de otra manera y me encanta el builder :)
    public static class Builder{
        private String name;
        private MethodOfTransportation methodOfTransportation;
        public Builder(){

        }

        public Builder name(String name){
            this.name = name;
            return this;
        }
        public Builder methodOfTransportation(MethodOfTransportation methodOfTransportation){
            this.methodOfTransportation = methodOfTransportation;
            return this;
        }
        public DeliveryPerson build(){
            return new DeliveryPerson(this);
        }
    }
}
