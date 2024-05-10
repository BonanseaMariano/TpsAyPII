/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package arbolExpresiones;

import net.datastructures.*;

/**
 *
 * @author Mariano
 */
public class ArbolExpresiones {

    //“((5+2) * (2−1))/((2+9)+((7−2)−1)) *8”
    static LinkedBinaryTree<String> linkedBinaryTree = new LinkedBinaryTree<>();
    static Position<String>[] p = new Position[19];

    public static void main(String[] args) {
        cargaArbol();
        postOrderYResultado();
    }

    public static void cargaArbol() {
        p[0] = linkedBinaryTree.addRoot("*");

        p[1] = linkedBinaryTree.addRight(p[0], "8");
        p[2] = linkedBinaryTree.addLeft(p[0], "/");

        p[3] = linkedBinaryTree.addRight(p[2], "+");
        p[4] = linkedBinaryTree.addLeft(p[2], "*");

        p[5] = linkedBinaryTree.addRight(p[4], "-");
        p[6] = linkedBinaryTree.addLeft(p[4], "+");
        p[7] = linkedBinaryTree.addRight(p[3], "-");
        p[8] = linkedBinaryTree.addLeft(p[3], "+");

        p[9] = linkedBinaryTree.addRight(p[5], "1");
        p[10] = linkedBinaryTree.addLeft(p[5], "2");
        p[11] = linkedBinaryTree.addRight(p[6], "2");
        p[12] = linkedBinaryTree.addLeft(p[6], "5");
        p[13] = linkedBinaryTree.addRight(p[7], "1");
        p[14] = linkedBinaryTree.addLeft(p[7], "-");
        p[15] = linkedBinaryTree.addRight(p[8], "9");
        p[16] = linkedBinaryTree.addLeft(p[8], "2");

        p[17] = linkedBinaryTree.addRight(p[14], "2");
        p[18] = linkedBinaryTree.addLeft(p[14], "7");
    }

    public static void postOrderYResultado() {
        ArrayStack<String> stack = new ArrayStack<>();

        System.out.println("\n---- PostOrder (IDR)----");
        for (Position<String> i : linkedBinaryTree.postorder()) { //postorder = IDR
            System.out.print(i.getElement());
        }
        System.out.println();

        for (Position<String> i : linkedBinaryTree.postorder()) { //postorder = IDR
            chequearOperador(i, stack);
        }
        System.out.println("Resultado: " + stack.pop());
    }

    public static void chequearOperador(Position<String> i, ArrayStack<String> stack) {
        switch (i.getElement().charAt(0)) {
            case '+':
                operar(0, stack);
                break;
            case '-':
                operar(1, stack);
                break;
            case '*':
                operar(2, stack);
                break;
            case '/':
                operar(3, stack);
                break;
            default:
                stack.push(i.getElement());
        }
    }

    public static void operar(int op, ArrayStack<String> stack) {
        double op2 = Double.parseDouble(stack.pop());
        double op1 = Double.parseDouble(stack.pop());

        switch (op) {
            case 0:
                stack.push("" + (op1 + op2));
                break;
            case 1:
                stack.push("" + (op1 - op2));
                break;
            case 2:
                stack.push("" + (op1 * op2));
                break;
            case 3:
                stack.push("" + (op1 / op2));
                break;
        }

    }
}
