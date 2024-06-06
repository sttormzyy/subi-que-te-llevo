package excepciones.viaje;

/**
 * La clase ExceptionChoferSinViajesPagos es una excepcion que se utiliza para indicar que un chofer no tiene ningún viaje pagado.
 */
public class ExceptionClienteSinViajesPagos extends ExceptionViaje {

    /**
     * Constructor de la excepcion ExceptionClienteSinViajesPagos.<br>
     * Crea una instancia de ExceptionClienteSinViajesPagos con el mensaje predeterminado "El cliente no tiene viajes pagos".
     */
    public ExceptionClienteSinViajesPagos(){
        super("El cliente no tiene viajes pagos");
    }
}
