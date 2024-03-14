package S3.T1.n2.src.classes.agenda;

import S3.T1.n2.src.classes.agenda.addresses.Address;
import S3.T1.n2.src.classes.agenda.addresses.AddressType;
import S3.T1.n2.src.classes.agenda.factories.TypeAddressFactory;
import S3.T1.n2.src.classes.agenda.factories.TypePhoneFactory;
import S3.T1.n2.src.classes.agenda.others.Countries;
import S3.T1.n2.src.classes.agenda.phones.Phone;
import S3.T1.n2.src.classes.agenda.phones.PhoneType;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Agenda {
    static Scanner s = new Scanner(System.in);
    protected static List<Address> addresses = new ArrayList<>();
    private static final TypeAddressFactory addressFactory = new TypeAddressFactory();
    protected static List<Phone> phones = new ArrayList<>();
    private static final TypePhoneFactory phoneFactory = new TypePhoneFactory();

    protected static void getAgendaContents(){
        StringBuilder textToReturn = new StringBuilder();

        if (addresses.isEmpty() && phones.isEmpty()){
            System.out.println("Agenda is empty.");
            return;
        }

        textToReturn.append("Addresses:\n");

        if (addresses.isEmpty()){
            textToReturn.append("- Empty.\n");
        } else {
            for (Address address : addresses){
                textToReturn.append(address.toString());
            }
        }

        textToReturn.append("Phones:\n");

        if (phones.isEmpty()){
            textToReturn.append("- Empty.\n");
        } else {
            for (Phone phone : phones){
                textToReturn.append(phone.toString());
            }
        }

        System.out.println(textToReturn);
    }
    protected static void introduceInformation(){
        int option;

        System.out.println("""
                Chose what type of information you'd like to introduce into the agenda:
                1. Address.
                2. Phone.
                Introduce your number of choice:
                """);
        option = s.nextInt();
        s.nextLine();

        switch (option) {
            case 1:
                introduceAddress();
                break;
            case 2:
                introducePhone();
                break;
            default:
                System.out.println("That's not an option, try again.");
            }
        }
    private static void introduceAddress(){
        AddressType addressType;
        Countries country;

        String input;

        System.out.println("Input the type of address to introduce:");
        input = s.nextLine().toUpperCase();
        try {
            addressType = AddressType.valueOf(input);
        } catch (IllegalArgumentException e) {
            System.out.println("Invalid choice.");
            return;
        }

        System.out.println("Input the country of the address to introduce:");
        input = s.nextLine().toUpperCase();
        try {
            country = Countries.valueOf(input);
        } catch (IllegalArgumentException e) {
            System.out.println("Invalid choice.");
            return;
        }

        System.out.println("Input the complete address to introduce:");
        input = s.nextLine();

        addresses.add(addressFactory.createAddress(addressType, country, input));
    }
    private static void introducePhone(){
        Countries country;
        PhoneType phoneType;

        String input;

        System.out.println("Input the type of phone to introduce:");
        input = s.nextLine().toUpperCase();
        try {
            phoneType = PhoneType.valueOf(input);
        } catch (IllegalArgumentException e) {
            System.out.println("Invalid choice.");
            return;
        }

        System.out.println("Input the country of the phone to introduce:");
        input = s.nextLine().toUpperCase();
        try {
            country = Countries.valueOf(input);
        } catch (IllegalArgumentException e) {
            System.out.println("Invalid choice.");
            return;
        }

        System.out.println("Input the complete phone to introduce:");
        input = s.nextLine();

        phones.add(phoneFactory.createPhone(phoneType, country, input));
    }
}
