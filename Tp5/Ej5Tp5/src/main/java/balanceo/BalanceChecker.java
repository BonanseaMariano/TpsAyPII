package balanceo;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Stack;

public class BalanceChecker {

    
    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("Uso: java BalanceChecker archivo_a_verificar.txt");
            return;
        }

        String filename = args[0];
        try {
            if (isBalanced(filename)) {
                System.out.println("El archivo está balanceado.");
            }
        } catch (IOException e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());
        }
    }

    /**
     * Método para verificar el balance de caracteres en el archivo
     */
    public static boolean isBalanced(String filename) throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            Stack<Character> stack = new Stack<>();
            String line;
            int lineNumber = 1;

            while ((line = reader.readLine()) != null) {    //  Obtengo la cada linea del archivo de texto
                for (char c : line.toCharArray()) { // Recorro cada caracter de la linea
                    if (isOpenBracket(c)) { //  Si encuentro una {([ lo añado a la pila
                        stack.push(c);
                    } else if (isCloseBracket(c)) { //  Si encuentro una })] chequeo si tengo su correspondiente en la pila
                        if (stack.isEmpty() || !matches(stack.pop(), c)) {
                            System.out.println("Error: Desbalanceado en la línea " + lineNumber); // Imprimo la linea en la cual se encuentra desbalanceado
                            return false;
                        }
                    }
                }
                lineNumber++;   //Incremento el contador de linea
            }

            if (!stack.isEmpty()) { // para caso de que en ningun momento se haya agregado el cierre de alguna apertura
                System.out.println("Error: Desbalanceado en la línea " + (lineNumber-1));
                return false;
            }
        }
        return true;    // Todas las aperturas tienen su cierre
    }

    /**
     * Métodos auxiliar para verificar si un carácter es un paréntesis, corchete
     * o llave que abre
     */
    private static boolean isOpenBracket(char c) {
        return c == '(' || c == '[' || c == '{';
    }

    /**
     * Método auxiliar para verificar si un carácter es un paréntesis, corchete
     * o llave que cierra
     */
    private static boolean isCloseBracket(char c) {
        return c == ')' || c == ']' || c == '}';
    }

    /**
     * Método auxiliar para verificar si para cada paréntesis, corchete o llave
     * que abre hay otra que cierra
     */
    private static boolean matches(char open, char close) {
        return (open == '(' && close == ')')
                || (open == '[' && close == ']')
                || (open == '{' && close == '}');
    }
}
