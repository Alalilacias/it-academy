package S3.T1.n2.src.classes.agenda.addresses;

import S3.T1.n2.src.classes.agenda.others.Countries;

public abstract class Address {
    AddressType type;
    Countries country;
    String address;
    public Address (AddressType type, Countries country, String address){
        this.type = type;
        this.country = country;
        this.address = address;
    }

    abstract void create();

    @Override
    public String toString() {

        return "- [Type: " + this.type + ", Country: " + this.country + ", Address: " + this.address + "]\n";
    }
}
