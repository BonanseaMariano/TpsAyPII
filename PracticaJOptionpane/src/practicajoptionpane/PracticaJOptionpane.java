/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package practicajoptionpane;

import com.toedter.calendar.JDateChooser;
import java.text.SimpleDateFormat;
import java.time.Clock;
import javax.swing.JOptionPane;

/**
 *
 * @author Usuario
 */
public class PracticaJOptionpane {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        //String message ="Ingrese una fecha:\n";
        //Object[] params = {message,jd};
        //JOptionPane.showConfirmDialog(null,params,"Fecha",-1);
        //String s=sdf.format(((JDateChooser)params[1]).getDate());
        //JOptionPane.showMessageDialog(null, "Fecha: "+s);
        JDateChooser jd = new JDateChooser();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        do {
            JOptionPane.showConfirmDialog(null, jd, "Ingrese una fecha", -1, -1);
        } while (jd.getCalendar() == null);

        JOptionPane.showMessageDialog(null, sdf.format(jd.getDate()));

        String hola = (String) JOptionPane.showInputDialog(null, "Saludos", "Selecciones", -1, null, new String[]{"Hola", "Adios"}, null);
        JOptionPane.showMessageDialog(null, hola);

        var hol = 1;
        var bol = hol == 1 ? "Es uno" : "no es uno";
        System.out.println("bol = " + bol);
    }
}
