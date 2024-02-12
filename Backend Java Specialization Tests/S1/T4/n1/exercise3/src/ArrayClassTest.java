package S1.T4.n1.exercise3.src;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ArrayClassTest {
    @Test
    void getArray() {
        boolean thrown = false;

        try {
            ArrayClass.getArray(5);
        } catch (ArrayIndexOutOfBoundsException e) {
            thrown = true;
        }

        assertTrue(thrown);
    }
}