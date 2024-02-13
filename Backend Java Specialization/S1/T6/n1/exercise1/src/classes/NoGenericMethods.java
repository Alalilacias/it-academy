package S1.T6.n1.exercise1.src.classes;

public class NoGenericMethods {
    private Object objectI;
    private Object objectII;
    private Object objectIII;

    public NoGenericMethods(Object objectI, Object objectII, Object objectIII){
        if (!areAllInstancesOfSameClass(objectI, objectII, objectIII)) {
            throw new IllegalArgumentException("The three objects don't share type");
        }

        this.objectI = objectI;
        this.objectII = objectII;
        this.objectIII = objectIII;
    }

    /* Method that judges if the objects introduced are of the same type. Necessary to confirm the class stores three objects of the same type.
    *  It receives a varargs parameter of objects, that is treated as an array we can access in the method. Chosen for the efficiency of the loop
    *  and I found it cool. */
    private static boolean areAllInstancesOfSameClass(Object... objects) {

        Class<?> firstClass = objects[0].getClass();

        for (Object obj : objects) {
            if (obj != null && !obj.getClass().equals(firstClass)) {
                return false;
            }
        }

        return true;
    }

//    Getters.
    public Object getObjectI() {
        return this.objectI;
    }
    public Object getObjectII() {
        return this.objectII;
    }
    public Object getObjectIII() {
        return this.objectIII;
    }
    /* Setters. They check the introduced object is an instance of the one prior on their place, so the instance of the
    *  same type rule is maintained. */
    public void setObjectI(Object objectI) {
        if (!objectI.getClass().equals(this.objectI.getClass())){
            throw new IllegalArgumentException("New object should be an instance of the same class.");
        }
        this.objectI = objectI;
    }
    public void setObjectII(Object objectII) {
        if (!objectII.getClass().equals(this.objectII.getClass())){
            throw new IllegalArgumentException("New object should be an instance of the same class.");
        }
        this.objectII = objectII;
    }
    public void setObjectIII(Object objectIII) {
        if (!objectIII.getClass().equals(this.objectIII.getClass())){
            throw new IllegalArgumentException("New object should be an instance of the same class.");
        }
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