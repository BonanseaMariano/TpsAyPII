/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cipher;

/**
 *
 * @author Mariano
 */
public class CesarCypher {

    private String alfabeto;
    private String alfabetoDesplazado;
    private int llave; //Cuanto esta desplazado el alfabeto

    public CesarCypher(int llave) {
        alfabeto = "abcdefghijklmnopqrstuvwxyz";
        alfabetoDesplazado = alfabeto.substring(llave) + alfabeto.substring(0, llave); //Primero agarro los caracteres desde llave hasta el final, y desp concateno desde el inicio hasta llave
        this.llave = llave;
    }

    public String encriptar(String mensaje) {

        String encriptacion = "";

        //Recorro el String para ir encriptando mensaje
        for (int i = 0; i < mensaje.length(); i++) {

            //Referencias de cada caracter y del indice en el alfabeto del mismo
            char caracterActual = mensaje.charAt(i);
            int referenciaIndice = alfabeto.indexOf(Character.toLowerCase(caracterActual));

            //Si el caracter no se encuentra dentro del alfabeto se concatena a la encriptacion directamente
            if (referenciaIndice == -1) {
                encriptacion += caracterActual;
            } else {
                //Obtengo el caracter cifrado a travez de la referencia al indice dentro del alfabeto (con el indice en el normal se busca el equivalente en el desplazado)
                char nuevoCaracter = alfabetoDesplazado.charAt(referenciaIndice);

                //Si el caracter esta en mayusculas lo paso a minusculas
                if (Character.isLowerCase(caracterActual)) {
                    encriptacion += Character.toLowerCase(nuevoCaracter);
                } else { //Si esta en minusculas solo lo concateno
                    encriptacion += nuevoCaracter;
                }
            }
        }

        return encriptacion;
    }

    public String decodificar(String mensaje) {
        //Creo un nuevo objeto de Cesar Cypher pero para la llave le paso como parametro el tamaño del alfabeto - la llave (para encriptar al reves/decodificar)
        CesarCypher encriptado = new CesarCypher(alfabeto.length() - llave);
        //Como el objeto encriptado tiene la llave inversa al mensaje que se quiere decodificar, entonces basta con encriptar el objeto para obtener el mensaje decodificado
        return encriptado.encriptar(mensaje);
    }

    public String impresionAlfabetos() {
        return alfabeto+"\n"+alfabetoDesplazado;
    }
}
