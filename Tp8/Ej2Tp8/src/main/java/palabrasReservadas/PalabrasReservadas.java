/*
 * Copyright 2014, Michael T. Goodrich, Roberto Tamassia, Michael H. Goldwasser
 *
 * Developed for use with the book:
 *
 *    Data Structures and Algorithms in Java, Sixth Edition
 *    Michael T. Goodrich, Roberto Tamassia, and Michael H. Goldwasser
 *    John Wiley & Sons, 2014
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package palabrasReservadas;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import net.datastructures.ChainHashMap;
import net.datastructures.Entry;
import net.datastructures.Map;

/**
 * A program that counts words in a document, printing the most frequent.
 */
public class PalabrasReservadas {

    static String[] palabrasReservadas = {
            "abstract", "continue", "for", "new", "switch", "assert", "default",
            "goto", "package", "synchronized", "boolean", "do", "if", "private",
            "this", "break", "double", "implements", "protected", "throw", "byte",
            "else", "import", "public", "throws", "case", "enum", "instanceof",
            "return", "transient", "catch", "extends", "int", "short", "try",
            "char", "final", "interface", "static", "void", "class", "finally",
            "long", "strictfp", "volatile", "const", "float", "native", "super",
            "while"
    };

    static Map<String, Integer> freq;

    public static void main(String[] args) {
        if (args.length != 1) {
            throw new IllegalArgumentException("Cantidad de argumentos incorrecta");
        }

        //Carga del mapa
        setUp();

        // scan input for words, using all nonletters as delimiters
        Scanner doc = null;

        try {
            doc = new Scanner(new File(args[0])).useDelimiter("[^a-zA-Z]+");
        } catch (FileNotFoundException e) {
            System.out.println("El archivo " + args[0] + " no pudo encontrarse");
        }

        while (doc.hasNext()) {
            String word = doc.next();   // convert next word to lowercase
            checkWord(word);
        }

        printWords();
    }

    /**
     * Initializes the frequency map with all reserved words and sets their initial frequency to 0.
     */
    public static void setUp() {
        freq = new ChainHashMap<>();  // or any concrete map
        for (String palabrasReservada : palabrasReservadas) {
            freq.put(palabrasReservada, 0);
        }
    }

    /**
     * Checks if the given word is a reserved word and updates its frequency in the frequency map.
     *
     * @param word the word to be checked
     */
    public static void checkWord(String word) {
        for (String palabrasReservada : palabrasReservadas) {
            if (palabrasReservada.equals(word)) {
                freq.put(word, 1 + freq.get(word));
                return; //Para que no tenga que recorrer necesariamente todo el arreglo
            }
        }
    }

    public static void printWords() {
        System.out.println("Cantidad de palabras reservadas utilizadas en el archivo:");
        for (Entry<String, Integer> e : freq.entrySet()) {
            if (e.getValue() > 0) {
                System.out.println(e);
            }
        }
    }
}
