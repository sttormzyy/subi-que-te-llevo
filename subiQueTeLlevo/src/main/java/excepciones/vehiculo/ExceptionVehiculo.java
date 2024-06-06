package excepciones.vehiculo;

/**
 * La clase ExceptionVehiculo es una excepcion generica para todas las excepciones relacionadas con vehiculos.
 */
public class ExceptionVehiculo extends Exception {

    /**
     * Constructor de la excepcion ExceptionVehiculo.<br>
     * Crea una instancia de ExceptionVehiculo con el mensaje proporcionado.
     * @param mensaje El mensaje que describe la excepcion.
     */
    public ExceptionVehiculo(String mensaje) {
        super(mensaje);
    }
}

