package teatro;

public interface Sala {
    String verProgramacion();
    String verLocalidades();
    String verLocalidadesOcupadas();
    String venderLocalidad(int fila, int butaca, Espectador e);
    String cancelarLocalidad(int fila, int butaca);
    String consultarLocalidad(int fila, int butaca);
    double calcularRecaudacion();
}
