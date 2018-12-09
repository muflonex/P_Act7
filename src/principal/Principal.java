package principal;

import java.util.Scanner;
import com.itt.arte.*;

/**
 *
 * @author Mikolaj
 * @version %I%, %G%
 */
public class Principal {

    private static Scanner lector;

    private static Obra obra
            = new Obra("La cena de los idiotas", "Comedia", 95);

    private static Teatro teatro = new Teatro("C/ Sol, 45", 300, 2, obra, 30);

    public static void main(String[] args) {

        lector = new Scanner(System.in);

        char opc;

        do {

            opc = mostrarMenu();

            switch (opc) {
                case '1':
                    escr("");
                    escr(getTeatro().verProgramacion());
                    escr("");
                    break;
                case '2':
                    escr("");
                    //  Mostramos el estado de todas las butacas
                    escr(getTeatro().verLocalidades());
                    escr("");
                    break;
                case '3':
                    escr("");
                    //  Mostramos quién ocupa las butacas
                    escr(getTeatro().verLocalidadesOcupadas());
                    escr("");
                    break;
                case '4':
                    escr("");
                    //  Vendemos una entrada
                    pasarelaDeVenta(getTeatro());
                    escr("");
                case '5':

                case '6':

                case '7':

                case '8':

                default:

            }

        } while (opc != '8');

        lector.close();

    }

    public static char mostrarMenu() {

        String opcion;

        escr("TEATRO LA BOMBILLA DE DON BLAS");
        escr("------------------------------");
        escr("1. Ver la programación actual");
        escr("2. Mostrar todas las localidades");
        escr("3. Mostrar localidades ocupadas");
        escr("4. Vender localidad");
        escr("5. Cancelar localidad");
        escr("6. Consultar localidad");
        escr("7. Calcular recaudación");
        escr("8. Terminar programa");
        escr("------------------------------");
        escr("¿Qué opción deseas?");

        opcion = lector.nextLine();

        return opcion.charAt(0); // Devuelvo el primer caracter tecleado.

    }

    public static void pasarelaDeVenta(Teatro sitio) {
        String cantidadFilas = String.valueOf(sitio.getLocalidades().length);
        String cantidadButacas = String.valueOf(sitio.getLocalidades()[0].length);
        //  Creamos el array que contiene preguntas y máximos para las respuestas
        String[][] preguntas = {
            {"¿En que fila quiere sentarse?", cantidadFilas},
            {"¿En que butaca quiere sentarse?", cantidadButacas},
            {"¿Cuántos años tiene?"},
            {"¿Cómo se llama?"},
            {"¿Su teléfono?"}
        };
        //  guardamos las respuestas como una variable local para poder referenciarlos
        String[] respuestas = hacerPreguntas(preguntas);
        //  damos nombres a las respuestas para que sea más legible la realización 
        //  del método venderLocalidad
        int fila = Integer.parseInt(respuestas[0]);
        int butaca = Integer.parseInt(respuestas[1]);

        escr(getTeatro().venderLocalidad(fila, butaca, crearEspectador(respuestas)));
    }

    public static String[] hacerPreguntas(String[][] preguntas) {
        //  Creamos el array para guardar las respuestas con 
        //  tantos espacios como hubo preguntas
        String resultado[] = new String[preguntas.length];

        for (int i = 0; i < preguntas.length; i++) {
            //  pregunta el es primer valor en el objeto guardado en el array
            String pregunta = preguntas[i][0];
            //  Sí el objeto guarda más que solo la pregunta
            if (preguntas[i].length > 1) {
                //  máximo es el segundo valor dentro del objeto
                String maximo = preguntas[i][1];
                //  en este caso utilizamos la versión de la función que tiene
                //  parametro de máximo
                resultado[i] = hacerPregunta(pregunta, maximo);
            } else {
                //  en otro caso solo hacemos la pregunta
                resultado[i] = hacerPregunta(pregunta);
            }
        }
        return resultado;
    }

    public static String hacerPregunta(String pregunta, String max) {
        String respuesta;
        int minimo = 0;
        //  nuestro array de preguntas solo guarda los valores String, por eso
        //  tenemos que convertir el valor de máximo en un int
        int maximo = Integer.parseInt(max);
        //  Mostramos la pregunta junto con el rango válido
        escr(pregunta + " (" + minimo + "-" + maximo + ")");
        //  Escuchamos la respuesta
        respuesta = lector.nextLine();
        //  Mientras que la respuesta sale del rango, volvemos a preguntar
        while (Integer.parseInt(respuesta) > maximo || Integer.valueOf(respuesta) < minimo) {
            escr("Valor incorrecto. Introduce nuevo valor.");
            respuesta = lector.nextLine();
        }
        return respuesta;
    }

    public static String hacerPregunta(String pregunta) {

        String respuesta;

        escr(pregunta);
        respuesta = lector.nextLine();

        //  Aquí siguen como el problema valores negativos
        while (respuesta.equals("")) {
            escr("Valor incorrecto. Introduce nuevo valor.");
            respuesta = lector.nextLine();
        }

        return respuesta;
    }

    public static Espectador crearEspectador(String[] respuestas) {
        //  asignamos nombres a las respuestas, para que sea más legible la respuesta
        int edad = Integer.parseInt(respuestas[2]);
        String nombre = respuestas[3];
        String telefono = respuestas[4];
        
        //  Devolvemos el espectador que se va a utilizar 
        //  en el método venderLocalidad
        return new Espectador(nombre, telefono, edad);
    }

    //  Alias para cortar System.out.println
    public static void escr(String txt) {
        System.out.println(txt);
    }
    
    /**
     * @return the obra
     */
    public static Obra getObra() {
        return obra;
    }

    /**
     * @param aObra the obra to set
     */
    public static void setObra(Obra aObra) {
        obra = aObra;
    }

    /**
     * @return the teatro
     */
    public static Teatro getTeatro() {
        return teatro;
    }

    /**
     * @param aTeatro the teatro to set
     */
    public static void setTeatro(Teatro aTeatro) {
        teatro = aTeatro;
    }
}
