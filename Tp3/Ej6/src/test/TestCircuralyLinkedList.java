/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package test;

import circularyLinkedList.CircularlyLinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Mariano
 */
public class TestCircuralyLinkedList {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        pruebaClone();
        pruebaSearch();
        pruebaRemoveElement();
        pruebaConcatenate();
    }
    
    public static void pruebaClone(){
        System.out.println("Clone:");
        CircularlyLinkedList<String> listaCircular = new CircularlyLinkedList<>();
        listaCircular.addLast("A");
        listaCircular.addLast("B");
        listaCircular.addLast("C");
        
        System.out.println(listaCircular);
        try {
            System.out.println(listaCircular.clone());
        } catch (CloneNotSupportedException ex) {
            Logger.getLogger(TestCircuralyLinkedList.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static void pruebaSearch(){
        System.out.println("Search:");
        CircularlyLinkedList<String> listaCircular = new CircularlyLinkedList<>();
        listaCircular.addLast("A");
        listaCircular.addLast("B");
        listaCircular.addLast("C");
        
        System.out.println(listaCircular);
        
        System.out.println("A");
        System.out.println(listaCircular.search("A"));
        System.out.println("C");
        System.out.println(listaCircular.search("C"));
        System.out.println("B");
        System.out.println(listaCircular.search("B"));
        System.out.println("null");
        System.out.println(listaCircular.search("Z")); 
    }
    
    public static void pruebaRemoveElement(){
        System.out.println("Remove Element:");
        CircularlyLinkedList<String> listaCircular = new CircularlyLinkedList<>();
        listaCircular.addLast("A");
        listaCircular.addLast("B");
        listaCircular.addLast("C");
        
        System.out.println(listaCircular);
        listaCircular.removeElement("Z");
        System.out.println(listaCircular);
        
        System.out.println("(A, C)");
        listaCircular.removeElement("B");
        System.out.println(listaCircular);
        
        System.out.println("(A)");
        listaCircular.removeElement("C");
        System.out.println(listaCircular);
        
        listaCircular.addLast("B");
        listaCircular.addLast("C");
        System.out.println("(B, C)");
        listaCircular.removeElement("A");
        System.out.println(listaCircular);
    }
    
    public static void pruebaConcatenate(){
        System.out.println("Concatenate:");
        CircularlyLinkedList<String> listaCircular = new CircularlyLinkedList<>();
        listaCircular.addLast("A");
        listaCircular.addLast("B");
        listaCircular.addLast("C");
        System.out.println(listaCircular);
        CircularlyLinkedList<String> listaCircular2 = new CircularlyLinkedList<>();
        listaCircular2.addLast("D");
        listaCircular2.addLast("E");
        listaCircular2.addLast("F");
        System.out.println(listaCircular2);
        System.out.println("");
        System.out.println("(A, B, C, D, E, F)");
        listaCircular.concatenate(listaCircular2);
        System.out.println(listaCircular);
    }
}
