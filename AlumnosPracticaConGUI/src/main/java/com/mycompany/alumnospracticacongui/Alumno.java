
package com.mycompany.alumnospracticacongui;

import javax.swing.JOptionPane;

/**
 *
 * @author Usuario
 */
public class Alumno {
    public int legajo;
    private String nombre_y_apellido;
    private int  dni;
    private String nacionalidad;
    private String email;
    private String direccion;
    private String genero;
    
    /**
     * @return the legajo
     */
    public int getLegajo() {
        return legajo;
    }

    /**
     * @param legajo the legajo to set
     */
    public void setLegajo(int legajo) {
        this.legajo = legajo;
    }

    /**
     * @return the nombre_y_apellido
     */
    public String getNombre_y_apellido() {
        return nombre_y_apellido;
    }

    /**
     * @param nombre_y_apellido the nombre_y_apellido to set
     */
    public void setNombre_y_apellido(String nombre_y_apellido) {
        this.nombre_y_apellido = nombre_y_apellido;
    }

    /**
     * @return the dni
     */
    public int getDni() {
        return dni;
    }

    /**
     * @param dni the dni to set
     */
    public void setDni(int dni) {
        this.dni = dni;
    }

    /**
     * @return the nacionalidad
     */
    public String getNacionalidad() {
        return nacionalidad;
    }

    /**
     * @param nacionalidad the nacionalidad to set
     */
    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return the direccion
     */
    public String getDireccion() {
        return direccion;
    }

    /**
     * @param direccion the direccion to set
     */
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    /**
     * @return the genero
     */
    public String getGenero() {
        return genero;
    }

    /**
     * @param genero the genero to set
     */
    public void setGenero(String genero) {
        this.genero = genero;
    }
    
    //Constructor sin parametros para inicializar
    Alumno(){
        this.legajo=0;
        this.nombre_y_apellido="";
        this.dni=0;
        this.nacionalidad="";
        this.email="";
        this.direccion="";
        this.genero="";
    }
    
    //Constructor con parametros para cargar
    Alumno(int legajo, String nombre_y_apellido, int dni, String nacionalidad, String email, String direccion, String genero){   
        this.legajo = legajo;
        this.nombre_y_apellido = nombre_y_apellido;
        this.dni = dni;
        this.nacionalidad = nacionalidad;
        this.email = email;
        this.direccion = direccion;
        this.genero = genero;       
    }
    
    public void registrarAlumno(String le, String nya, String dn, String nac, String ma, String dir, String gen) {
        //Para validar es mejor utilizar una variable aparte en vez del campo, es decir que el campo siempre llegue limpio
        legajo = Integer.parseInt(le);
        nombre_y_apellido = nya;
        dni = Integer.parseInt(dn);
        nacionalidad = nac;
        email = ma;
        direccion = dir;
        genero = gen;
    }
    
    public String toString() {
        String res;
        res= "\nLegajo: "+legajo+"\nNombre y apellido: "+nombre_y_apellido+"\ndni: "+dni+"\nNacionalidad: "+nacionalidad+"\nEmail: "+email+"\nDireccion: "+direccion+"\nGenero: "+genero;
        return res; 
    }
    public void mostrar(){
        JOptionPane.showMessageDialog(null,toString(),"Lista Alumnos",1);
    }
    
}
