package S3.T1.n2.src.classes.agenda.factories;

import S3.T1.n2.src.classes.agenda.others.Countries;
import S3.T1.n2.src.classes.agenda.phones.MobilePhone;
import S3.T1.n2.src.classes.agenda.phones.NonMobilePhone;

public interface AbstractTypePhoneFactory {
    MobilePhone makeMobilePhone(Countries country, String number);
    NonMobilePhone makeNonMobilePhone(Countries country, String number);
}
