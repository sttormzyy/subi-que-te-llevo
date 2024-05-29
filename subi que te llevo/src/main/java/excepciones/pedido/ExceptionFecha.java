package excepciones.pedido;

import java.time.LocalDateTime;

/**
 * La clase ExceptionFecha es una excepcion especifica que se utiliza para representar
 * errores relacionados con fechas invalidas en un Pedido o en la gestion de viajes.
 */
public class ExceptionFecha extends ExceptionPedido{
    /** La primera fecha relacionada con el error. */
    private LocalDateTime fecha1 = null;
    /** La segunda fecha relacionada con el error, utilizada en ciertos contextos donde se analiza intervalos de tiempo. */
    private LocalDateTime fecha2 = null;
    
    /**
     * Constructor de la excepcion ExceptionFecha.<br>
     * Indica que se ha detectado una fecha invalida en un pedido.<br>
     * @param fecha La fecha invalida.
     */
    public ExceptionFecha(LocalDateTime fecha) {
        super("La fecha ingresada es inválida");
        this.fecha1 = fecha;
    }
    
    /**
     * Constructor de la excepcion ExceptionFecha.<br>
     * Permite especificar un mensaje de error personalizado desde el lugar 
     * donde se lanza la excepcion.<br>
     * @param mensaje El mensaje de error personalizado.
     */
    public ExceptionFecha(String mensaje) {
        super(mensaje);
    }
    
    /**
     * Constructor de la excepcion ExceptionFecha.<br>
     * Se utiliza cuando se necesita un reporte de viajes de cliente o chofer entre dos fechas, intervalo de tiempo.<br>
     * @param mensaje El mensaje de error personalizado.
     * @param fecha1  La primera fecha del rango.
     * @param fecha2  La segunda fecha del rango.
     */
    public ExceptionFecha(String mensaje, LocalDateTime fecha1, LocalDateTime fecha2) {
        super(mensaje);
        this.fecha1 = fecha1;
        this.fecha2 = fecha2;
    }
    
    /**
     * Constructor de la excepcion ExceptionFecha.<br>
     * Se utiliza cuando se ingresa un mes invalido para actualizar puntajes.
     * @param mes El mes invalido.
     */
    public ExceptionFecha(int mes) {
        super("Mes ingresado inválido");
    }
    
    /**
     * Constructor de la excepcion ExceptionFecha.<br>
     * Indica que la fecha ingresada es Null.
     */
    public ExceptionFecha() {
        super("La fecha ingresada es Null");
    }
    
    /**
     * Obtiene la primera fecha relacionada con el error.<br>
     * @return La primera fecha relacionada con el error.
     */
    public LocalDateTime getFecha1() {
        return fecha1;
    }

    /**
     * Obtiene la segunda fecha relacionada con el error.<br>
     * @return La segunda fecha relacionada con el error.
     */
    public LocalDateTime getFecha2() {
        return fecha2;
    }
    

}

