package excepciones.viaje;

import excepciones.chofer.ExceptionChofer;

/**
 * La clase ExceptionChoferSinViaje es una excepcion que se utiliza para indicar que un chofer no tiene ningún viaje asignado.
 */
public class ExceptionChoferSinViaje extends ExceptionChofer {

    /**
     * Constructor de la excepcion ExceptionChoferSinViaje.<br>
     * Crea una instancia de ExceptionChoferSinViaje con el mensaje predeterminado "El Chofer no tiene ningun viaje asignado".
     */
    public ExceptionChoferSinViaje(){
        super("El Chofer no tiene ningun viaje asignado");
    }
}
