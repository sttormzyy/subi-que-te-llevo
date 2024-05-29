package excepciones.viaje;

/**
 * La clase ExceptionChoferSinViajesPagos es una excepcion que se utiliza para indicar que un chofer no tiene ningún viaje pagado.
 */
public class ExceptionChoferSinViajesPagos extends ExceptionViaje {

    /**
     * Constructor de la excepcion ExceptionChoferSinViajesPagos.<br>
     * Crea una instancia de ExceptionChoferSinViajesPagos con el mensaje predeterminado "El cliente no tiene viajes pagos".
     */
    public ExceptionChoferSinViajesPagos(){
        super("El cliente no tiene viajes pagos");
    }
}
