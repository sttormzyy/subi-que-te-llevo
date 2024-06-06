package excepciones.chofer;

/**
 * La clase ExceptionDNIrepetido es una excepcion especifica que se utiliza para representar
 * errores que surgen al querer añadir un nuevo chofer, lo cual indica que ya se encuentra registrado en el sistema.
 */
public class ExceptionDNIrepetido extends ExceptionChofer {

    /**
     * Constructor de la excepcion ExceptionDNIrepetido.<br>
     * Indica que se ha detectado un DNI repetido para un chofer.
     * @param dni El DNI repetido.
     */
    public ExceptionDNIrepetido(String dni) {
        super("DNI de chofer repetido");
        this.dni = dni;
    }
    
}
