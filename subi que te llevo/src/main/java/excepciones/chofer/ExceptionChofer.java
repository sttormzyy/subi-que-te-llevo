package excepciones.chofer;

/**
 * La clase ExceptionChofer es una excepcion personalizada que se utiliza para representar
 * errores relacionados con los choferes en el sistema.
 */
public class ExceptionChofer extends Exception {
    
    protected String dni;
    
    /**
     * Constructor de la excepcion ExceptionChofer.<br>
     * @param mensaje Mensaje que describe la naturaleza del error.
     */
    public ExceptionChofer(String mensaje) {
        super("Error: " + mensaje);
    }
    
    /**
     * Obtiene el dni dato de la excepcion.<br>
     * @return El DNI de un chofer.
     */
    public String getDni() {
        return dni;
    }
}
