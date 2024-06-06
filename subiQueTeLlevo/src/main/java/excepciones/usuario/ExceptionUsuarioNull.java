package excepciones.usuario;

/**
 * La clase ExceptionUsuarioNull es una excepcion utilizada para indicar que se intento
 * realizar una operacion con un nombre de usuario Null.
 */
public class ExceptionUsuarioNull extends ExceptionUsuario {
	
    /**
     * Constructor de la excepcion ExceptionUsuarioNull.
     * Crea una instancia de ExceptionUsuarioNull con el mensaje predeterminado
     * indicando que el nombre de usuario es Null.
     */
    public ExceptionUsuarioNull() {
        super("nombre de usuario Null");		
    }
}
