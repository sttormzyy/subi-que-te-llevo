package excepciones.vehiculo;

/**
 * La clase ExceptionPatenteRepetida es una excepcion utilizada para indicar que se intento
 * agregar un vehiculo con una patente que ya existe en el sistema.
 */
public class ExceptionPatenteRepetida extends ExceptionVehiculo {

    private String patente;

    /**
     * Constructor de la excepcion ExceptionPatenteRepetida.<br>
     * Crea una instancia de ExceptionPatenteRepetida con la patente repetida y un mensaje predeterminado.
     * @param patente La patente que causó la excepción.
     */
    public ExceptionPatenteRepetida(String patente) {
        super("Patente de vehículo repetida");
        this.patente = patente;
    }

    /*
     * Obtiene la patente que causó la excepcion.<br>
     * @return La patente que causó la excepcion.
     */
    public String getDato() {
        return this.patente;
    }
}
