package excepciones.pedido;

/**
 * La clase ExceptionCantPax es una excepcion especifica que se utiliza para representar
 * errores relacionados con una cantidad invalida de pasajeros en un pedido, esta debe estar comprendida
 * entre los valores 1 y 10.
 */
public class ExceptionCantPax extends ExceptionPedido {
    private int cantPax;
    
    /**
     * Constructor de la excepcion ExceptionCantPax.<br>
     * Indica que se ha detectado una cantidad invalida de pasajeros en un pedido.
     * @param cantPax La cantidad inválida de pasajeros.
     */
    public ExceptionCantPax(int cantPax) {
        super("La cantidad de pasajeros es invalida");
        this.cantPax = cantPax;
    }
    
    /**
     * Obtiene la cantidad de pasajeros invalida.<br>
     * @return La cantidad de pasajeros invalida.
     */
    public int getDato() {
        return this.cantPax;
    }

}

