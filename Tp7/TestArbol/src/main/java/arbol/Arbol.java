/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package arbol;

import net.datastructures.LinkedBinaryTree;
import net.datastructures.Position;

/**
 *
 * @author Mariano
 */
public class Arbol {

    static LinkedBinaryTree<String> tree = new LinkedBinaryTree<>();
    static Position<String> a,b,c,d,e,f,g;

    public static void main(String[] args) {

        a = tree.addRoot("A");

        b = tree.addLeft(a, "B");
        f = tree.addRight(a, "F");

        c = tree.addLeft(b, "C");

        d = tree.addRight(b, "D");

        e = tree.addRight(c, "E");

        preOrder();
        inOrder();
        postOrder();
        heightYdepth();
        sibiling();

    }

    public static void preOrder() {
        System.out.println("---- Preorder ----");
        for (Position<String> i : tree.preorder()) { //preorder = RID
            System.out.print(i.getElement());
        }
    }

    public static void inOrder() {
        System.out.println("\n---- InOrder ----");
        for (Position<String> i : tree.inorder()) { //inorder = IRD
            System.out.print(i.getElement());
        }
    }

    public static void postOrder() {
        System.out.println("\n---- PostOrder ----");
        for (Position<String> i : tree.postorder()) { //postorder = IDR
            System.out.print(i.getElement());
        }
    }
    
    public static void breadthFirst(){
        System.out.println("\n---- Por Niveles ----");
        for (Position<String> i : tree.breadthfirst()) { //breathfirst = Por niveles
            System.out.print(i.getElement());
        }
    }
    
    public static void heightYdepth(){
        System.out.println("\nheight: "+tree.height(a)); //Altura desde la posicion
        System.out.println("depth: "+tree.depth(e)); //Que tan profundo se encuentra la posicion con respecto de la raiz
    }
    
    public static void sibiling(){
        System.out.println("sibiling de b: "+tree.sibling(b).getElement());
    }
}
