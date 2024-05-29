package choferes;

import java.time.LocalDateTime;

import excepciones.pedido.ExceptionFecha;
import sistema.Empresa;

/**
 * Clase que representa a un Chofer Contratado.
 */
public class ChoferContratado extends Chofer{
	private static double gananciaViaje = 25;       

// Constructor

	/**
     * Constructor de la clase ChoferContratado.<br>
	 * <b>PRE:</b> Los parámetros dni y nombre no pueden ser nulos.<br>
	 * <b>POST:</b> Se crea un nuevo objeto ChoferContratado con el DNI y nombre especificados.<br>
     * @param dni El DNI del chofer contratado.
     * @param nombre El nombre del chofer contratado.
     */
    public ChoferContratado(String dni, String nombre) {
    	super(dni, nombre);
    }
	
// Metodos
    
    /**
     * Obtiene el sueldo del chofer contratado para el mes especificado.<br>
	 * <b>POST:</b> Se devuelve el sueldo del chofer contratado para el mes especificado.<br>
     * @return El sueldo del chofer para el mes especificado.
     */
	public double getSueldo() 
	{
		LocalDateTime fechaActual = LocalDateTime.now();
        return Empresa.getInstance().getRecaudoContratado(this, fechaActual) * (gananciaViaje / 100);
    }
	
	/**
     * Obtiene el sueldo del chofer contratado para el mes especificado.<br>
	 * <b>PRE:</b> La fecha no puede ser nula.<br>
	 * <b>POST:</b> Se devuelve el sueldo del chofer contratado para el mes especificado.<br>
     * @param fecha La fecha para la cual se calcula el sueldo.
     * @return El sueldo del chofer para el mes especificado.
     */
	public double getSueldo(LocalDateTime fecha)
	{
	    assert fecha != null : "La fecha no puede ser nula.";
		return Empresa.getInstance().getRecaudoContratado(this, fecha) * (gananciaViaje / 100);
	}

// Getters y Setters
	
    /**
     * Obtiene el porcentaje de la ganancia por viaje para los Choferes Contratados.<br>
	 * <b>POST:</b> Se devuelve el porcentaje de la ganancia por viaje para los Choferes Contratados.<br>
     * @return Porcentaje de ganancia por viaje.
     */
	public static double getGananciaViaje() {
		return gananciaViaje;
	}
	
	/**
     * Establece el porcentaje de la ganancia por viaje para los Choferes Contratados.<br>
     * <b>PRE:</b> El parámetro gananciaViaje no puede ser negativo.<br>
     * <b>POST:</b> Se actualiza el porcentaje de la ganancia por viaje para los Choferes Contratados.<br>
     * @param gananciaViaje Porcentaje de la nueva ganancia por viaje.
     */
	public static void setGananciaViaje(double gananciaViaje) {
	    assert gananciaViaje >= 0 : "La ganancia por viaje no puede ser negativa.";
		ChoferContratado.gananciaViaje = gananciaViaje;
	}
    
}
