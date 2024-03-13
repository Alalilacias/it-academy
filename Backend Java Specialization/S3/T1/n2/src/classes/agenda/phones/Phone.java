package S3.T1.n2.src.classes.agenda.phones;

import S3.T1.n2.src.classes.agenda.others.Countries;

public abstract class Phone {
    PhoneType type;
    String prefix;
    String number;
    public Phone (PhoneType type, Countries country, String number){
        this.type = type;
        this.prefix = country.getPrefix();
        this.number = number;
    }

    abstract void create();
}
