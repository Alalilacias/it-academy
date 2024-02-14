package S1.T4.n1.exercise2.src;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class dniCalculator {
    static char[] dniLetters = {'T', 'R', 'W', 'A', 'G', 'M', 'Y', 'F', 'P', 'D', 'X',
            'B', 'N', 'J', 'Z', 'S', 'Q', 'V', 'H', 'L', 'C', 'K', 'E'};
    public static char letterCalculator(int dniNumber) {
        return dniLetters[(dniNumber%23)];
    }

//    Random method I made to obtain ten numbers that would produce the same number so JUnit could take them in. Not worth the time it takes.
    @Deprecated
    public static List<Long> tenDNIsWithChosenLetter(char letter){
        List<Long> dniList = new ArrayList<>();

        int necessaryRemainder = Arrays.binarySearch(dniLetters, letter);
        long randomNumber;

        while (dniList.size() < 11) {
            randomNumber = (int) (10000000 + Math.random() * (100000000 - 10000000));
            if ((randomNumber / 23) == necessaryRemainder){
                dniList.add(randomNumber);
            }
        }

        return dniList;
    }
}
