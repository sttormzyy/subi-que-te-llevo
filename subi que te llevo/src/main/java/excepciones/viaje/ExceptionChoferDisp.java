package excepciones.viaje;

/**
 * La clase ExceptionChoferDisp es una excepcion que se utiliza para indicar que no hay ningun Chofer disponible para asignar a un Viaje.
 */
public class ExceptionChoferDisp extends ExceptionViaje {

    /**
     * Constructor de la excepcion ExceptionChoferDisp.<br>
     * Crea una instancia de ExceptionChoferDisp con el mensaje predeterminado "No hay ningun Chofer disponible".
     */
    public ExceptionChoferDisp() {
        super("No hay ningun Chofer disponible");
    }
}

