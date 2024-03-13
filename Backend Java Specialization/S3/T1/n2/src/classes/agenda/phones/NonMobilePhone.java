package S3.T1.n2.src.classes.agenda.phones;

import S3.T1.n2.src.classes.agenda.others.Countries;

public class NonMobilePhone extends Phone{
    public NonMobilePhone(Countries country, String number) {
        super(PhoneType.NON_MOBILE, country, number);
    }

    @Override
    void create() {
        System.out.println("Non-mobile phone \"" + this.number + "\" saved.");
    }
}
