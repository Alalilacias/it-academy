package code.classes;

import code.interfaces.Callback;

public enum Payments implements Callback {
    CREDIT_CARD,
    PAYPAL,
    BANK_ACCOUNT_DEBT;

    @Override
    public String onEvent() {
        return "Payment done with " + this.name().toLowerCase().replace("_"," ") + ".";
    }
}
