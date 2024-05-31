package choferes;

import java.time.LocalDateTime;
import java.util.ArrayList;

import sistema.Empresa;
import viajes.IViaje;

/**
 * Clase que representa a un chofer temporario.
 */
public class ChoferTemporario  extends Asalariado
{
    private static double sueldoBasico=2000;
    private static int cantidadViajesParaPlus = 40;
    private static double plusXCantidadViajes = 10;       
    private static double aportes;						

// Constructor
    /**
     * Constructor de la clase ChoferTemporario.<br>
	 * <b>PRE: </b> El DNI y el nombre del Chofer Temporario deben ser cadenas de caracteres no nulas y no vacias.<br>
	 * <b>POST: </b> Se crea un objeto ChoferTemporario con el DNI y nombre especificados.<br>
     * @param dni El DNI del Chofer Temporario.
     * @param nombre El nombre del Chofer Temporario.
     */
    public ChoferTemporario(String dni, String nombre) {
    	super(dni, nombre);
    }
    
// Metodos
    /**
     * Obtiene el sueldo del Chofer Temporario para el mes actual.<br>
     * @return El sueldo del Chofer para el mes actual.
     */
    public double getSueldo() {
    	LocalDateTime fechaActual = LocalDateTime.now();
		return this.getSueldoNeto(fechaActual);
	}
    
    /**
     * Obtiene el sueldo del Chofer Temporario para un mes especifico.<br>
     * <b>PRE:</b> El parametro fecha no puede ser nulo.<br>
     * @param fecha La fecha para la cual se calcula el sueldo.
     * @return El sueldo del chofer para la fecha dada.
     */
    public double getSueldo(LocalDateTime fecha) {
		return this.getSueldoNeto(fecha);
	}
    
    /**
     * Calcula el sueldo neto del Chofer Temporario para un mes especifico.
     * <b>PRE:</b> El parametro fecha no puede ser nulo.
     * @param fecha La fecha para la cual se calcula el sueldo.
     * @return El sueldo neto del Chofer para la fecha dada.
     */
    public double getSueldoNeto(LocalDateTime fecha) {
        double sueldoBruto = getSueldoBruto(fecha);
        double descuento = sueldoBruto * ( ChoferTemporario.aportes / 100 );
        double sueldoNeto = sueldoBruto - descuento;
        return sueldoNeto;
    }

    /**
     * Obtiene el sueldo bruto del Chofer Temporario para un mes especifico.<br>
     * <b>PRE:</b> El parametro fecha no puede ser nulo.<br>
     * @param fecha La fecha para la cual se calcula el sueldo.
     * @return El sueldo bruto del chofer para la fecha dada.
     */
    public double getSueldoBruto(LocalDateTime fecha) {
        double sueldoBruto = sueldoBasico;
        if (Empresa.getInstance().getCantidadViajesTemp(this,fecha) > ChoferTemporario.cantidadViajesParaPlus) 
        {
        	sueldoBruto += sueldoBasico * (ChoferTemporario.plusXCantidadViajes / 100);
        }
        return sueldoBruto;
    }
   
// Getters y Setters
    
    /**
     * Obtiene el sueldo basico para los Choferes Temporarios.<br>
     * @return El sueldo basico para los Choferes Temporarios.
     */ 
    public static double getSueldoBasico() {
		return ChoferTemporario.sueldoBasico;
	}
    
    /**
     * Establece el sueldo básico para los Choferes Temporarios.<br>
     * <b>PRE:</b> El parámetro sueldoBasico no puede ser negativo.<br>
     * <b>POST:</b> El sueldo básico de los Choferes Temporarios se actualiza al valor especificado.<br>
     * @param sueldoBasico El nuevo sueldo básico para los Choferes Temporarios.
     */
	public static void setSueldoBasico(double sueldoBasico) {
		ChoferTemporario.sueldoBasico = sueldoBasico;
	}

	/**
	 * Obtiene los aportes del Chofer Temporario.<br>
	 * <b>POST:</b> Se devuelve el valor de los aportes del Chofer Temporario.<br>
	 * @return Los aportes del Chofer Temporario.
	 */
	public double getAportes() {
		return ChoferTemporario.aportes;
	}
	
	/**
	 * Establece los aportes del Chofer Temporario.<br>
	 * <b>PRE:</b> El parametro aportes no puede ser negativo.<br>
	 * <b>POST:</b> Se actualizan los aportes del Chofer Temporario.<br>
	 * @param aportes Los nuevos aportes del Chofer Temporario.
	 */
	public void setAportes(double aportes) {
		assert aportes >= 0: "Los aportes no pueden ser negativos";
		ChoferTemporario.aportes = aportes;
	}
	
	/**
     * Obtiene el porcentaje de plus ganado por cantidad de viajes realizados mensualmente para los Choferes Temporarios.<br>
     * <b>POST:</b> Se devuelve el porcentaje de plus por la cantidad de viajes realizados por los Choferes Temporarios.<br>
     */
	public double getPlusXCantidadViajes() {
		return ChoferTemporario.plusXCantidadViajes;
	}
	
	/**
     * Establece el porcentaje de plus por cantidad de viajes realizados mensualmente para los Choferes Temporarios.
	 * <b>PRE:</b> El parámetro plusXCantidadViajes no puede ser negativo.<br>
	 * <b>POST:</b> Se actualiza el porcentaje de plus por la cantidad de viajes realizados por los Choferes Temporarios.<br>
     * @param plusXCantidadViajes El nuevo porcentaje de plus por la cantidad de viajes realizados por los Choferes Temporarios.
     */
	public void setPlusXCantidadViajes(double plusXCantidadViajes) {
	    assert plusXCantidadViajes >= 0 : "El porcentaje de plus no puede ser negativo.";

		ChoferTemporario.plusXCantidadViajes = plusXCantidadViajes;
	}

	/**
     * Obtiene la cantidad de viajes necesarios para obtener un plus para los Choferes Temporarios.<br>
     * <b>POST:</b> Se devuelve la cantidad de viajes necesarios para obtener un plus para los Choferes Temporarios.<br>
     * @return La cantidad de viajes necesarios para obtener un plus para los Choferes Temporarios.
     */
	public static int getCantidadViajesParaPlus() {
		return ChoferTemporario.cantidadViajesParaPlus;
	}
	
	/**
     * Establece la cantidad de viajes necesarios para obtener un plus para los Choferes Temporarios.<br>
	 * <b>PRE:</b> El parámetro cantidadViajesParaPlus debe ser mayor a cero.<br>
	 * <b>POST:</b> Se actualiza la cantidad de viajes necesarios para obtener un plus para los Choferes Temporarios.<br>
     * @param cantidadViajesParaPlus La nueva cantidad de viajes necesarios para obtener un plus para los Choferes Temporarios.
     */
	public static void setCantidadViajesParaPlus(int cantidadViajesParaPlus) {
	    assert cantidadViajesParaPlus >= 0 : "La cantidad de viajes para obtener un plus no puede ser negativa.";

		ChoferTemporario.cantidadViajesParaPlus = cantidadViajesParaPlus;
	}
    
	public ChoferTemporario clone() {
        try {
        	//En este caso para mi ya es innecesario, hereda clone de Choferes
            ChoferTemporario clonado = (ChoferTemporario) super.clone();
            return clonado;
        } 
        catch (CloneNotSupportedException e) {
        	//Nunca va a entrar
        	throw new RuntimeException("Clone not supported", e);
        }
    }
}
