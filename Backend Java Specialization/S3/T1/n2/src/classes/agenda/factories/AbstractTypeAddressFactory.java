package S3.T1.n2.src.classes.agenda.factories;

import S3.T1.n2.src.classes.agenda.addresses.FiscalAddress;
import S3.T1.n2.src.classes.agenda.addresses.HomeAddress;
import S3.T1.n2.src.classes.agenda.others.Countries;

public interface AbstractTypeAddressFactory {
    HomeAddress makeHomeAddress(Countries country, String address);
    FiscalAddress makeFiscalAddress(Countries country, String address);
}
