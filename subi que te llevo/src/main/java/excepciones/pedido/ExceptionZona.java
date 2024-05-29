package excepciones.pedido;

/**
 * La clase ExceptionZona es una excepcion especifica utilizada para representar
 * errores relacionados con zonas invalidas en un pedido.
 */
public class ExceptionZona extends ExceptionPedido {
    private String zona;

    /**
     * Constructor de la excepcion ExceptionZona.<br>
     * Crea una instancia de ExceptionZona con un mensaje predeterminado
     * indicando que la zona ingresada es invalida.
     * @param zona La zona invalida que ha causado la excepcion.
     */
    public ExceptionZona(String zona) {
        super("La zona ingresada es inválida");
        this.zona = zona;
    }

    /**
     * Obtiene la zona que ha generado la excepcion.<br>
     * @return La zona invalida que ha causado la excepcion.
     */
    public String getDato() {
        return this.zona;
    }
}
