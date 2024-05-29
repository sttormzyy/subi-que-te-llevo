package excepciones.pedido;

/**
 * La clase ExceptionVehiculoDisp es una excepcion especifica utilizada para
 * representar errores relacionados con la falta de vehiculos disponibles para
 * realizar un pedido.
 */
public class ExceptionVehiculoDisp extends ExceptionPedido {

    /**
     * Constructor de la excepcion ExceptionVehiculoDisp.<br>
     * Crea una instancia de ExceptionVehiculoDisp con un mensaje predeterminado
     * indicando que no hay ningún vehiculo disponible.
     */
    public ExceptionVehiculoDisp() {
        super("No hay ningún vehículo disponible");
    }
}
