package code.classes;

import code.interfaces.Callback;

public enum Payments implements Callback {
    CREDIT_CARD,
    PAYPAL,
    BANK_ACCOUNT_DEBT;

    @Override
    public String onEvent() {
        return "Paying with " + this.name().toLowerCase().replace("_"," ") + ".";
    }
}
