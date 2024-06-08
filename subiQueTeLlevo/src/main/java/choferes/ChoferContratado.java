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
	
	public ChoferContratado(String dni, String nombre, int puntos, boolean ocupado) {
		super(dni, nombre, puntos, ocupado);
	}

	// Metodos
    
    /**
     * Obtiene el sueldo del chofer contratado para el mes especificado.<br>
	 * <b>POST:</b> Se devuelve el sueldo del chofer contratado para el mes especificado.<br>
     * @return El sueldo del chofer para el mes especificado.
     */
	public double getSueldo(double totalRecaudado) 
	{
		LocalDateTime fechaActual = LocalDateTime.now();
        return totalRecaudado * (gananciaViaje / 100);
    }
	
	/**
     * Obtiene el sueldo del chofer contratado para el mes especificado.<br>
	 * <b>PRE:</b> La fecha no puede ser nula.<br>
	 * <b>POST:</b> Se devuelve el sueldo del chofer contratado para el mes especificado.<br>
     * @param fecha La fecha para la cual se calcula el sueldo.
     * @return El sueldo del chofer para el mes especificado.
     */
	public double getSueldo(LocalDateTime fecha, double totalRecaudado)
	{
	    assert fecha != null : "La fecha no puede ser nula.";
		return totalRecaudado * (gananciaViaje / 100);
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
	
        @Override
	public ChoferContratado clone() {
        try {
        	//En este caso para mi ya es innecesario, hereda clone de Choferes
            ChoferContratado clonado = (ChoferContratado) super.clone();
            return clonado;
        } catch (CloneNotSupportedException e) {
        	//Nunca va a entrar
            throw new RuntimeException("Clone not supported", e);
        }
    }
    
}
