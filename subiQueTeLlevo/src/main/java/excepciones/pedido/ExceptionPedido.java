package excepciones.pedido;

/**
 * La clase ExceptionPedido es una excepcion base utilizada para representar
 * errores generales relacionados con parametros de los pedidos.
 */
public class ExceptionPedido extends Exception{

    /**
     * Constructor de la excepcion ExceptionPedido.
     * @param mensaje El mensaje de error asociado a la excepcion.
     */
    public ExceptionPedido(String mensaje){
        super(mensaje);
    }
}
