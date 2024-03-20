package code.classes;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PaymentsTest {

    @Test
    void onEvent() {
        assertEquals("Payment done with bank account debt.", Payments.BANK_ACCOUNT_DEBT.onEvent());
    }
}