package S1.T4.n1.exercise3.src;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ArrayClassTest {
    @Test
    void getArray() {
        assertThrows(ArrayIndexOutOfBoundsException.class, () -> ArrayClass.getArray(5));
    }
}