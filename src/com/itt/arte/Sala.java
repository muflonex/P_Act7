package com.itt.arte;

public interface Sala {
    
    public String verProgramacion();
    public String verLocalidades();
    public String verLocalidadesOcupadas();
    public String venderLocalidad(int fila, int butaca, Espectador e);
    public String cancelarLocalidad(int fila, int butaca);
    public String consultarLocalidad(int fila, int butaca);
    public double calcularRecaudacion();
}
