package S1.T4.n1.exercise2.src;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class dniCalculatorIT {
    /*



23000092*/
    @ParameterizedTest
    @ValueSource(ints = {23000046, 46000092, 69000069, 92000115, 11500046, 13800092, 16100069, 18400115, 20700046, 23000092})
    void letterCalculator(int dniNumbers) {
            assertEquals('T', dniCalculator.letterCalculator(dniNumbers));
    }
}