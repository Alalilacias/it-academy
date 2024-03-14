package S3.T1.n2.src.classes.agenda.factories;

import S3.T1.n2.src.classes.agenda.others.Countries;
import S3.T1.n2.src.classes.agenda.phones.MobilePhone;
import S3.T1.n2.src.classes.agenda.phones.NonMobilePhone;
import S3.T1.n2.src.classes.agenda.phones.Phone;
import S3.T1.n2.src.classes.agenda.phones.PhoneType;

public class TypePhoneFactory implements AbstractTypePhoneFactory {
    @Override
    public MobilePhone makeMobilePhone(Countries country, String number) {
        return new MobilePhone(country, number);
    }
    @Override
    public NonMobilePhone makeNonMobilePhone(Countries country, String number) {
        return new NonMobilePhone(country, number);
    }

    public Phone createPhone(PhoneType type, Countries country, String number) {
        return switch (type) {
            case MOBILE -> makeMobilePhone(country, number);
            case NON_MOBILE -> makeNonMobilePhone(country, number);
        };
    }
}
