package excepciones.pedido;

/**
 * La clase ExceptionTipodeServicio es una excepcion especifica utilizada para
 * representar errores relacionados con tipos de servicio invalidos en un pedido.
 */
public class ExceptionTipodeServicio extends ExceptionPedido {

    /**
     * Constructor de la excepcion ExceptionTipodeServicio.<br>
     * Crea una instancia de ExceptionTipodeServicio con un mensaje predeterminado
     * indicando que el tipo de servicio es invalido.
     */
    public ExceptionTipodeServicio() {
        super("El tipo de servicio es inválido");
    }
}
