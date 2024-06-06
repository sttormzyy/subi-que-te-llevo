package excepciones.vehiculo;

/**
 * La clase ExceptionPatenteInexistente es una excepcion utilizada para indicar que se intento
 * acceder a un vehiculo con una patente que no existe en el sistema.
 */
public class ExceptionPatenteInexistente extends ExceptionVehiculo {
	
	private String patente;

    /**
     * Constructor de la excepcion ExceptionPatenteInexistente.<br>
     * Crea una instancia de ExceptionPatenteInexistente con el mensaje proporcionado.
     * @param patente El mensaje que describe la excepcion.
     */
    public ExceptionPatenteInexistente(String patente) {
        super("No existe ningun vehiculo con la patente ingresada");
        this.patente = patente;
    }
    
    /**
     * Obtiene la patente que causo la excepcion.<br>
     * @return La patente que causo la excepcion.
     */
    public String getDato()
	{
		return this.patente;
	}
}

