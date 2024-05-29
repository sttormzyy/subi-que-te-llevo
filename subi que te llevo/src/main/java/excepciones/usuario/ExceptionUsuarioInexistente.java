package excepciones.usuario;

/**
 * La clase ExceptionUsuarioInexistente es una excepcion utilizada para indicar que
 * se intento acceder a un usuario que no existe en el sistema.
 */
public class ExceptionUsuarioInexistente extends ExceptionUsuario {
	
    /**
     * Constructor de la excepcion ExceptionUsuarioInexistente.
     * Crea una instancia de ExceptionUsuarioInexistente con el mensaje predeterminado
     * indicando que el usuario ingresado no existe.
     * @param nombreUsuario El nombre de usuario que causó la excepcion.
     */
    public ExceptionUsuarioInexistente(String nombreUsuario) {
        super("el usuario ingresado no existe");
        this.nombreUsuario = nombreUsuario;
    }
}
