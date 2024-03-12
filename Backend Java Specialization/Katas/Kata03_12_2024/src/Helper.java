package Katas.Kata03_12_2024.src;

public abstract class Helper {
    public static void testKata(String input) {
        System.out.println(rot13Encrypt(input));
    }
    public static String rot13Encrypt(String input) {
        return input.chars()
            .map( c -> {
                if (Character.isLetter(c)){
                    if       (c >= 'a' && c <= 'm') c += 13;
                    else if  (c >= 'n' && c <= 'z') c -= 13;
                    return (char) (c);
                }
                return c;
            })
            .mapToObj(c -> (char) c)
            .collect(StringBuilder::new, StringBuilder::append, StringBuilder::append)
            .toString();
    }
}
