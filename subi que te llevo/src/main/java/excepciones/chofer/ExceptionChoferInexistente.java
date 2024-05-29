package excepciones.chofer;

/**
 * La clase ExceptionChoferInexistente es una excepcion especifica que se utiliza para representar
 * errores relacionados con la inexistencia de un chofer en el sistema.
 */
public class ExceptionChoferInexistente extends ExceptionChofer {

    /**
     * Constructor de la excepcion ExceptionChoferInexistente.<br>
     * @param dni El DNI del Chofer que no se encontro en el sistema.
     */
    public ExceptionChoferInexistente(String dni) {
        super("Chofer inexistente");
        this.dni = dni;
    }

}

