package code.classes;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ShoeStoreTest {

    @Test
    void payWith() {
        assertEquals("Payment done with credit card.", ShoeStore.payWith(Payments.CREDIT_CARD));
    }
}