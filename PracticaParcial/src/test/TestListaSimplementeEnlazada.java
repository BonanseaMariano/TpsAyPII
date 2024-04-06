/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package test;

import java.util.logging.Level;
import java.util.logging.Logger;
import lista.ListaSimplementeEnlazada;

/**
 *
 * @author Mariano
 */
public class TestListaSimplementeEnlazada {

    public static void main(String[] args) {
        duplicate();
        addLista();
    }

    public static void duplicate() {
        System.out.println("Duplicate");

        ListaSimplementeEnlazada<String> l1 = new ListaSimplementeEnlazada<>();

        l1.addLast("A");
        l1.addLast("B");
        l1.addLast("C");
        l1.addLast("D");

        System.out.println("Lista original:");
        System.out.println(l1);
        System.out.println("Lista duplicada:");
        try {
            System.out.println(l1.duplicate());
        } catch (Exception CloneNotSupportedException) {
            System.out.println("Error de duplicado");
        }
        System.out.println("");
    }

    public static void addLista() {
        System.out.println("AddList");

        ListaSimplementeEnlazada<String> l1 = new ListaSimplementeEnlazada<>();
        ListaSimplementeEnlazada<String> l2 = new ListaSimplementeEnlazada<>();

        l1.addLast("A");
        l1.addLast("B");
        l1.addLast("C");
        l1.addLast("D");

        l2.addLast("X");
        l2.addLast("Y");

        System.out.println("Lista destino:");
        System.out.println(l1);
        System.out.println("Lista a insertar:");
        System.out.println(l2);

        try {
            System.out.println("t1:");
            ListaSimplementeEnlazada<String> t1 = l1.duplicate();
            System.out.println("{A, B, X, Y, C, D}");
            t1.addList(l2, 2);
            System.out.println(t1);
            System.out.println("t2:");
            System.out.println("{X, Y, A, B, C, D}");
            ListaSimplementeEnlazada<String> t2 = l1.duplicate();
            t2.addList(l2, 0);
            System.out.println(t2);
            System.out.println("t3:");
            System.out.println("{A, B, C, D, X, Y}");
            ListaSimplementeEnlazada<String> t3 = l1.duplicate();
            t3.addList(l2, 4);
            System.out.println(t3);
        } catch (Exception CloneNotSupportedException) {
            System.out.println("Error de duplicado");
        }
    }
}
