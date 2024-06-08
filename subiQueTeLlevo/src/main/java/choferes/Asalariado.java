package choferes;

import java.time.LocalDateTime;

/**
 * Clase abstracta de la que se extenderan las subclases de Chofer con sueldos Brutos y Netos.
 */
public abstract class Asalariado extends Chofer {
	protected static double sueldoBasico=2000;
	protected static double aportes = 10;

	// Constructor

	/**
	 * Constructor de la clase Asalariado.<br>
	 * @param dni El DNI del chofer.
	 * @param nombre El nombre del chofer.
	 */
	protected Asalariado(String dni, String nombre) {
		super(dni, nombre); 
	}

	public Asalariado(String dni, String nombre, int puntos, Boolean ocupado) {
		super(dni, nombre, puntos, ocupado);
	}

	/**
	 * Obtiene el porcentaje de aportes del Chofer Asalariado.<br>
	 * <b>POST:</b> Se devuelve el porcentaje de los aportes del Chofer Asalariado.<br>
	 * @return Los aportes del Chofer Asalariado.
	 */
	public double getAportes() {
		return Asalariado.aportes;
	}

	/**
	 * Establece el porcentaje de aportes del Chofer Asalariado.<br>
	 * <b>PRE:</b> El parametro aportes no puede ser negativo.<br>
	 * <b>POST:</b> Se actualiza el porcentaje de los aportes del Chofer Asalariado.<br>
	 * @param aportes Los nuevos aportes del Chofer Asalariado.
	 */
	public void setAportes(double aportes) {
		assert aportes >= 0: "Los aportes no pueden ser negativos";
		Asalariado.aportes = aportes;
	}

}
