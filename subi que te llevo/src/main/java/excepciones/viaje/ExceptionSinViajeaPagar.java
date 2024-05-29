package excepciones.viaje;

/**
 * La clase ExceptionSinViajeaPagar es una excepcion que se utiliza para indicar que no hay ningun viaje disponible para pagar.
 */
public class ExceptionSinViajeaPagar extends ExceptionViaje {

    /**
     * Constructor de la excepcion ExceptionSinViajeaPagar.<br>
     * Crea una instancia de ExceptionSinViajeaPagar con el mensaje predeterminado "No hay ningun viaje disponible a pagar".
     */
    public ExceptionSinViajeaPagar() {
        super("No hay ningun viaje disponible a pagar");
    }
}

