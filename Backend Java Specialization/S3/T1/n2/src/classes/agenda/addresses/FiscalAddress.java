package S3.T1.n2.src.classes.agenda.addresses;

import S3.T1.n2.src.classes.agenda.others.Countries;

public class FiscalAddress extends Address{
    public FiscalAddress (Countries country, String address){
        super(AddressType.FISCAL, country, address);
        create();
    }

    @Override
    void create() {
        System.out.println("Fiscal address \"" + this.address + "\" saved.");
    }
}
