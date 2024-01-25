package Kata.Kata25_01_2024;

public class Main {
    public static void main(String[] args) {

        /*
         * Crea un programa que analice texto y obtenga:
         * - Número total de palabras.
         * - Longitud media de las palabras.
         * - Número de oraciones del texto.
         */

//        Instancializamos Analizador
        Analizador analizador = new Analizador();

//        Utilizamos el metodo unicobucle para calcular las variables necesarias
        analizador.unicoBucle("Cuando los jugadores se hayan ido, cuando el tiempo los haya consumido, ciertamente no habrá cesado el rito. En el Oriente se encendió esta guerra cuyo anfiteatro es hoy toda la Tierra. Como el otro, este juego es infinito.");

//        Imprimimos resultado en pantalla
        System.out.println(analizador.toString());
    }
}
