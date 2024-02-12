package S1.T4.n1.exercise2.src;

public class dniCalculator {
    static char[] dniLetters = {'T', 'R', 'W', 'A', 'G', 'M', 'Y', 'F', 'P', 'D', 'X',
            'B', 'N', 'J', 'Z', 'S', 'Q', 'V', 'H', 'L', 'C', 'K', 'E'};
    public static char letterCalculator(int dniNumber) {
        return dniLetters[(dniNumber%23)];
    }

    public static void main(String[] args) {
        int[] dniNumbers = {15302904, 93261207, 36778938, 77032857, 68078164, 51061574, 50206996, 59480900, 27450753, 43990241, 14998752};

        for (int dni : dniNumbers) {
            System.out.println(letterCalculator(dni));
        }
    }
}
