package excepciones.vehiculo;

/**
 * La clase ExceptionVehiculoNull es una excepción que se utiliza para indicar que se ha recibido un vehiculo Null.
 */
public class ExceptionVehiculoNull extends ExceptionVehiculo {

    /**
     * Constructor de la excepcion ExceptionVehiculoNull.<br>
     * Crea una instancia de ExceptionVehiculoNull con el mensaje predeterminado.
     */
    public ExceptionVehiculoNull() {
        super("Vehiculo null");
    }
}

