package S1.T1.n2.exercise1.src.classes;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SmartphoneTest {
    Smartphone mi = new Smartphone("Xiaomi Redmi", "Note 10");
    @Test
    void call() {
        assertEquals("Calling 616323484.", mi.call("616323484"));
    }

    @Test
    void photograph() {
        assertEquals("A picture is being taken.", mi.photograph());
    }

    @Test
    void alarm() {
        assertEquals("The alarm is ringing.", mi.alarm());
    }
}