package S1.T4.n1.exercise2.src;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class dniCalculatorIT {
    @Test
    void letterCalculator() {
        int[] dniNumbers = {15302904, 93261207, 36778938, 77032857, 68078164, 51061574, 50206996, 59480900, 27450753, 43990241, 14998752};
        char[] dniLetters = {'S','W','Y','S','G','X','C','W','T','G','S'};

        for(int i = 0; i < 10; i++){
            assertEquals(dniLetters[i], dniCalculator.letterCalculator(dniNumbers[i]));
        }
    }
}