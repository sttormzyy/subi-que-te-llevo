package excepciones.viaje;

/**
 * La clase ExceptionViaje es una clase base para excepciones relacionadas con los viajes.
 */
public class ExceptionViaje extends Exception {

    /**
     * Constructor de la clase ExceptionViaje.<br>
     * Crea una instancia de ExceptionViaje con el mensaje proporcionado.
     * @param mensaje El mensaje que describe la excepcion.
     */
    public ExceptionViaje(String mensaje) {
        super(mensaje);
    }
}
