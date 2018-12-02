package com.itt.arte;

public class Obra {
    
    private String titulo;
    private String genero;
    private int minutosDuracion;
    
    public Obra(String titulo, String genero, int minutosDuracion){
        this.titulo = titulo;
        this.genero = genero;
        this.minutosDuracion = minutosDuracion;
    }
    
    @Override
    public String toString(){
        return  this.getTitulo() 
                + ",\ngénero: " + this.getGenero() 
                + ",\nduración: " + this.getMinutosDuracion() + " minutos";
    }
    
    //  Getters & Setters
    
    /**
     * @return the titulo
     */
    public String getTitulo() {
        return titulo;
    }

    /**
     * @param titulo the titulo to set
     */
    public void setTitulo(String titulo) {
        this.titulo = titulo;
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

    /**
     * @return the minutosDuracion
     */
    public int getMinutosDuracion() {
        return minutosDuracion;
    }

    /**
     * @param minutosDuracion the minutosDuracion to set
     */
    public void setMinutosDuracion(int minutosDuracion) {
        this.minutosDuracion = minutosDuracion;
    }

    

}
