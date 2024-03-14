package S3.T1.n2.src.classes.agenda.phones;

import S3.T1.n2.src.classes.agenda.others.Countries;

public class MobilePhone extends Phone{
    public MobilePhone(Countries country, String number) {
        super(PhoneType.MOBILE, country, number);
        create();
    }

    @Override
    void create() {
        System.out.println("Mobile phone \"" + this.number + "\" saved.");
    }
}
