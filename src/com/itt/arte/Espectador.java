package com.itt.arte;

public class Espectador {

    private String nombre;
    private String tlf;
    private int edad;
    
    public Espectador(String nombre, String tlf, int edad){
        this.nombre = nombre;
        this.tlf = tlf;
        this.edad = edad;
    }
    
    public String rangoEdad() {
        edad = this.getEdad();
        if (edad >= 0 && edad <= 12) 
            return "INFANTIL";
        if (edad >= 13 && edad <= 17) 
            return "MENOR";
        if (edad >= 18 && edad <= 64) 
            return "MAYOR";
        if (edad >= 65) 
            return "JUBILADO";
        return "no especificada";
    }

    @Override
    public String toString() {
        String resultado = this.getNombre().toUpperCase()
                + ", \ttlf: " + this.getTlf()
                + ", \ttipo: " + this.rangoEdad();
        return resultado;
    }

    // Getters 
    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @return the tlf
     */
    public String getTlf() {
        return tlf;
    }

    /**
     * @return the edad
     */
    public int getEdad() {
        return edad;
    }
}
