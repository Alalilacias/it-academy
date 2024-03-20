package code;

import code.classes.Payments;
import code.classes.ShoeStore;
import code.utils.Input;

public class Helper {
    protected static void testExercise(){
        while (true) {
            switch (Input.readInt("""
                    Choose the type of payment to make:
                    1. Credit Card.
                    2. Paypal.
                    3. Bank Account Debt.
                    4. Exit.
                    """)){
                case 1:
                    creditPayment();
                    break;
                case 2:
                    paypalPayment();
                    break;
                case 3:
                    bankDebtPayment();
                    break;
                case 4:
                    System.out.println("Come again.");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Option not available.");
            }
        }
    }
    private static void creditPayment(){
        ShoeStore.payWith(Payments.CREDIT_CARD);
    }
    private static void paypalPayment(){
        ShoeStore.payWith(Payments.PAYPAL);
    }
    private static void bankDebtPayment(){
        ShoeStore.payWith(Payments.BANK_ACCOUNT_DEBT);
    }
}
