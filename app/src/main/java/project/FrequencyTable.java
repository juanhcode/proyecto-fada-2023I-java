package project;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class FrequencyTable {

    public static HashMap<Character,Integer> generateTable(String text){
        ArrayList<Character> validChars = new ArrayList<>(Arrays.asList('a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '.', ' ', ',','\''));
        HashMap<Character,Integer> mapaDeFrecuencia = new HashMap<>();

        for (char letra : text.toLowerCase().toCharArray()) {
            if (validChars.contains(letra)) {
                if (mapaDeFrecuencia.containsKey(letra)) {
                    mapaDeFrecuencia.put(letra, mapaDeFrecuencia.get(letra) + 1);
                } else {
                    mapaDeFrecuencia.put(letra, 1);
                }
            }
        }

        /*
        // Agregar el salto de línea a la tabla de frecuencias
        char saltoDeLinea = '\n';
        if (text.contains(String.valueOf(saltoDeLinea))) {
            if (mapaDeFrecuencia.containsKey(saltoDeLinea)) {
                mapaDeFrecuencia.put(saltoDeLinea, mapaDeFrecuencia.get(saltoDeLinea) + 1);
            } else {
                mapaDeFrecuencia.put(saltoDeLinea, 1);
            }
        }
        */

        return mapaDeFrecuencia;
    }
}
