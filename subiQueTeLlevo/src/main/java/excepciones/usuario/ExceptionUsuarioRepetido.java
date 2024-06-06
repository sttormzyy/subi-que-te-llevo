package excepciones.usuario;

/**
 * La clase ExceptionUsuarioRepetido es una excepcion utilizada para indicar que se intento
 * crear un usuario con un nombre que ya esta en uso.
 */
public class ExceptionUsuarioRepetido extends ExceptionUsuario {
	
    /**
     * Constructor de la excepcion ExceptionUsuarioRepetido.
     * Crea una instancia de ExceptionUsuarioRepetido con el mensaje predeterminado
     * indicando que el nombre de usuario esta repetido.
     * @param nombreUsuario El nombre de usuario que esta repetido.
     */
    public ExceptionUsuarioRepetido(String nombreUsuario) {
        super("nombre de usuario repetido");
        this.nombreUsuario = nombreUsuario;
    }
}
