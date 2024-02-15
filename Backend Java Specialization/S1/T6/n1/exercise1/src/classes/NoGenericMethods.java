package S1.T6.n1.exercise1.src.classes;

@SuppressWarnings("unused")
public class NoGenericMethods {
    private String objectI;
    private String objectII;
    private String objectIII;

    public NoGenericMethods(String objectI, String objectII, String objectIII){

        this.objectI = objectI;
        this.objectII = objectII;
        this.objectIII = objectIII;
    }

//    Getters.
    public String getObjectI() {
        return this.objectI;
    }
    public String getObjectII() {
        return this.objectII;
    }
    public String getObjectIII() {
        return this.objectIII;
    }
//    Setters
    public void setObjectI(String objectI) {
        this.objectI = objectI;
    }
    public void setObjectII(String objectII) {
        this.objectII = objectII;
    }
    public void setObjectIII(String objectIII) {
        this.objectIII = objectIII;
    }

//    User-defined Methods

    @Override
    public String toString() {
        return "Generic class contents:" +
                "\nFirst object = " + objectI +
                "\nSecond object = " + objectII +
                "\nThird object = " + objectIII + ".\n";
    }
}