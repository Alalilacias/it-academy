package Kata.Kata25_01_2024;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;

public class Analizador {
//    Formatter
    NumberFormat f = new DecimalFormat("#.##");
//    Variables de la instancia
    private List<String> palabras;
    private List<Integer> longitudPalabras;
    private int numeroOraciones;
//    Constructor
    public Analizador(){
        this.palabras = new ArrayList<String>();
        this.longitudPalabras = new ArrayList<Integer>();
        this.numeroOraciones = 0;
    }
//    User-defined method
    public void unicoBucle(String text){
//        Rellenamos numeroOraciones
        List<String> tempList = new ArrayList<String>();
        tempList = List.of(text.split("[.]"));
        this.numeroOraciones = tempList.size();

//        Rellenamos palabras
        text.replace(",", "");
        text.replace(".", "");
        tempList = List.of(text.split(" "));
        this.palabras = tempList;

//        Rellenamos longitudPalabras
        for (String palabra : this.palabras){
            this.longitudPalabras.add(palabra.length());
        }
    }
    public String toString(){
        int longitudPalabras = 0;
        for (int longitudPalabra : this.longitudPalabras){
            longitudPalabras += longitudPalabra;
        }
        return "\n Palabras: " + this.palabras.size()
                + " - Oraciones: " + this.numeroOraciones
                + " - Longitud media: " + f.format(((double) (longitudPalabras) / this.palabras.size()));
    }
}
