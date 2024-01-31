package S1.T3.n1.exercise1.src.classes;

import java.util.Objects;

public class Month {
//    Instance variable
    private String name;
//    Constructor
    public Month (String name) {
        this.name = name;
    }
//    Getters
    public String getName() {
        return name;
    }
//    Setters
    public void setName(String name) {
        this.name = name;
    }
//    Hashcode and equals overriding so the hashSet they're included in works properly and doesn't allow duplicates.
    public int hashCode(){
        int hash = 5;
        hash = 31 + hash + Objects.hashCode(this.name);
        return hash;
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (obj instanceof Month test) {
            return test.getName().equals(this.getName());
        }
        return false;
    }
}
