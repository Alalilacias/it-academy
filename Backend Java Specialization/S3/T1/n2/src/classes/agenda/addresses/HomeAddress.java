package S3.T1.n2.src.classes.agenda.addresses;

import S3.T1.n2.src.classes.agenda.others.Countries;

public class HomeAddress extends Address{
    public HomeAddress (Countries country, String address){
        super(AddressType.HOME, country, address);
        create();
    }

    @Override
    void create() {
        System.out.println("Home address: \"" + this.address + "\" saved.");
    }
}
