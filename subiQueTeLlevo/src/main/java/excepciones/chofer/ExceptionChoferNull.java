package excepciones.chofer;

/**
 * La clase ExceptionChoferNull es una excepcion especifica que se utiliza para representar
 * errores relacionados con el ingreso de un valor null para el DNI de un chofer.
 */
public class ExceptionChoferNull extends ExceptionChofer {

    /**
     * Constructor de la excepcion ExceptionChoferNull.<br>
     * Indica que se ha ingresado un valor null para el DNI del chofer.
     */
    public ExceptionChoferNull() {
        super("DNI ingresado null");
    }

}
