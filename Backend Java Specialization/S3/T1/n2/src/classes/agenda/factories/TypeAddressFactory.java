package S3.T1.n2.src.classes.agenda.factories;

import S3.T1.n2.src.classes.agenda.addresses.Address;
import S3.T1.n2.src.classes.agenda.addresses.AddressType;
import S3.T1.n2.src.classes.agenda.addresses.FiscalAddress;
import S3.T1.n2.src.classes.agenda.addresses.HomeAddress;
import S3.T1.n2.src.classes.agenda.others.Countries;

public class TypeAddressFactory implements AbstractTypeAddressFactory {
    @Override
    public HomeAddress makeHomeAddress(Countries country, String address) {
        return new HomeAddress(country, address);
    }
    @Override
    public FiscalAddress makeFiscalAddress(Countries country, String address) {
        return new FiscalAddress(country, address);
    }

     public Address createAddress(AddressType type, Countries country, String address){
         return switch (type) {
             case HOME -> makeHomeAddress(country, address);
             case FISCAL -> makeFiscalAddress(country, address);
         };
     }
}
