package com.itt.arte;
import principal.Principal;

public class Teatro extends Local implements Sala {

    private Obra obra;
    private double precio;
    private Espectador[][] localidades;

    public Teatro(String domicilio, int metros, int accesos, Obra obra, int precio) {
        super(domicilio, metros, accesos);
        this.obra = obra;
        this.precio = precio;
        this.localidades = new Espectador[5][10];
    }

    @Override
    public String verProgramacion() {
        String cartel = "Hoy presentamos: " 
                + "\n"+ this.getObra().toString()
                + "\nEn " + this.toString()
                + ",\nPrecio: " + this.getPrecio();
        return cartel;
    }

    @Override
    public String verLocalidades() {
        Espectador[][] arrayButacas = this.getLocalidades();
        //  Creamos la frase con StringBuilder para facilitar el proceso
        StringBuilder temp = new StringBuilder("");
        for (int y = 0; y < arrayButacas.length; y++) {
            for (int x = 0; x < arrayButacas[y].length; x++) {
                if (arrayButacas[y][x] != null) {
                    temp.append(y).append(".").append(x).append(" Ocupada\t");
                } else {
                    temp.append(y).append(".").append(x).append(" Libre\t");
                }
            }
            temp.append("\n");
        }
        String respuesta = temp.toString();
        return respuesta;
    }

    @Override
    public String verLocalidadesOcupadas() {

        Espectador[][] arrayButacas = this.getLocalidades();
        StringBuilder temp = new StringBuilder("");
        for (int y = 0; y < arrayButacas.length; y++) {
            for (int x = 0; x < arrayButacas[y].length; x++) {
                if (arrayButacas[y][x] != null) {
                    temp.append(y).append(".").append(x).append(": ").append(arrayButacas[y][x].toString());
                }
            }
        }
        String resultado = temp.toString();
        return resultado.length() == 0 ? "No hay butacas ocupadas." : resultado;
    }

    @Override
    public String venderLocalidad(int fila, int butaca, Espectador e) {
    
        while(localidades[fila][butaca] != null){
            System.out.println("Butaca ocupada. Vuelve por favor a realizar la compra.");
            Principal.pasarelaDeVenta(Principal.getTeatro());
        }
        switch(e.rangoEdad()){
            case "INFANTIL" : precio = this.getPrecio()*0.5;
                            break;
            case "MENOR"    : precio = this.getPrecio()*0.8;
                            break;
            case "MAYOR"    : precio = this.getPrecio();
                            break;
            case "JUBILADO" : precio = this.getPrecio()*0.33;
                            break;  
        }
        localidades[fila][butaca] = e;
        return "Se ha vendido la localidad " + fila + "." + butaca + " a " 
                + e.getNombre() + " por " + precio + " euro.";
    }

    @Override
    public String cancelarLocalidad(int fila, int butaca) {
        String nombre = Principal.getTeatro().getLocalidades()[fila][butaca].getNombre();
        localidades[fila][butaca] = null;
        return nombre + " ha cancelado su reserva";
    }

    @Override
    public String consultarLocalidad(int fila, int butaca) {
        Espectador cliente = Principal.getTeatro().getLocalidades()[fila][butaca];
        switch(cliente.rangoEdad()){
            case "INFANTIL" : precio = this.getPrecio()*0.5;
                            break;
            case "MENOR"    : precio = this.getPrecio()*0.8;
                            break;
            case "MAYOR"    : precio = this.getPrecio();
                            break;
            case "JUBILADO" : precio = this.getPrecio()*0.33;
                            break;  
        }
        return "Localidad ocupada por " + cliente.toString() + " Precio: " + precio;
    }

    @Override
    public double calcularRecaudacion() {
        double suma = 0;
        Espectador[][] arrayButacas = this.getLocalidades();
        for (int y = 0; y < arrayButacas.length; y++) {
            for (int x = 0; x < arrayButacas[y].length; x++) {
                if (arrayButacas[y][x] != null) {
                    switch(arrayButacas[y][x].rangoEdad()){
                        case "INFANTIL" : precio = this.getPrecio()*0.5;
                            break;
                        case "MENOR"    : precio = this.getPrecio()*0.8;
                            break;
                        case "MAYOR"    : precio = this.getPrecio();
                            break;
                        case "JUBILADO" : precio = this.getPrecio()*0.33;
                            break;  
                    }
                    suma += precio;
                }
            }
        }
        return suma;
    }

    /**
     * @return the obra
     */
    public Obra getObra() {
        return obra;
    }

    /**
     * @param obra the obra to set
     */
    public void setObra(Obra obra) {
        this.obra = obra;
    }

    /**
     * @return the precio
     */
    public double getPrecio() {
        return precio;
    }

    /**
     * @param precio the precio to set
     */
    public void setPrecio(double precio) {
        this.precio = precio;
    }

    /**
     * @return the localidades
     */
    public Espectador[][] getLocalidades() {
        return localidades;
    }

    /**
     * @param localidades the localidades to set
     */
    public void setLocalidades(Espectador[][] localidades) {
        this.localidades = localidades;
    }

}
