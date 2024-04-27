package htmlValidator;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class HTMLAttributeValidator {

    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("Uso: java HTMLAttributeValidator <ruta_al_archivo>");
            return;
        }

        String filePath = args[0];
        validateHTMLAttributes(filePath);
    }

    public static void validateHTMLAttributes(String filePath) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            int lineNumber = 0;

            while ((line = reader.readLine()) != null) {
                lineNumber++;
                Pattern pattern = Pattern.compile("<(\\w+)\\s+([^>]+)>"); //Crea un patron para analizar los elementos que componen a la sintaxis de html
                Matcher matcher = pattern.matcher(line); //Utiliza un matcher para reconocer estos patrones en la linea obtenida

                while (matcher.find()) { // Intenta encontrar alguna coincidencia del patron
                    String tagName = matcher.group(1); // Guarda el nombre del tag
                    String attributes = matcher.group(2); // Guarda los atributos del tag

                    // Verificar si los valores de los atributos están entre comillas dobles
                    if (!attributes.matches("(\\w+)=\"[^\"]*\"")) {
                        System.out.printf("Error en la línea %d, columna %d: Delimitador de atributo inválido en la etiqueta <%s>%n",
                                lineNumber, matcher.start(), tagName);
                    }
                }
            }
        } catch (IOException e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());
        }
    }
}
