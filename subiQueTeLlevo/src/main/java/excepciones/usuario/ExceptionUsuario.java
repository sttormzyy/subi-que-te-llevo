package excepciones.usuario;

/**
 * La clase ExceptionUsuario es una excepcion generica utilizada para representar
 * errores relacionados con usuarios.
 */
public class ExceptionUsuario extends Exception {
    protected String nombreUsuario;
	
    /**
     * Constructor de la excepcion ExceptionUsuario.
     * Crea una instancia de ExceptionUsuario con el mensaje especificado.
     * @param mensaje El mensaje que describe el error.
     */
    public ExceptionUsuario(String mensaje){
        super(mensaje);
    }
	
    /**
     * Obtiene el nombre de usuario asociado a la excepcion.
     * @return El nombre de usuario asociado a la excepcion.
     */
    public String getDato() {
        return nombreUsuario;
    }
}
