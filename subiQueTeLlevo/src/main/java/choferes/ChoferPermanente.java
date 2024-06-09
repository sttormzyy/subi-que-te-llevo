package choferes;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

/**
 * Clase que representa a un chofer permanente.
 */
public class ChoferPermanente extends Asalariado
{
	private static double sueldoBasico=2000;
	private static double plusAntiguedad = 10;       
	private static double plusXHijos = 10;             
	private int cantidadHijos;
	private LocalDateTime fechaIngreso;
	
// Constructor
	
    /**
     * Constructor de la clase ChoferPermanente.<br>
	 * <b>PRE:</b> El parámetro dni y nombre no pueden ser nulos.<br>
	 * <b>POST:</b> Se crea un nuevo objeto ChoferPermanente con los atributos especificados.<br>
     * @param dni El DNI del chofer permanente.
     * @param nombre El nombre del chofer permanente.
     * @param cantHijos La cantidad de hijos del chofer permanente.
     * @param fechaIngreso La fecha de ingreso del chofer permanente.
     */
	public ChoferPermanente(String dni, String nombre,int cantHijos, LocalDateTime fechaIngreso) {
		super(dni, nombre);
		this.cantidadHijos = cantHijos;
		this.fechaIngreso = fechaIngreso;
	}

	public ChoferPermanente(String dni, String nombre, int puntos, Boolean ocupado, int cantidadHijos, LocalDateTime fechaIngreso) {
		super(dni, nombre, puntos, ocupado);
		this.cantidadHijos = cantidadHijos;
		this.fechaIngreso = fechaIngreso;
	}


// Metodos
	
    /**
     * Obtiene el sueldo del Chofer Permanente para el mes actual.<br>
	 * <b>POST:</b> Se devuelve el sueldo del Chofer Permanente para el mes actual.<br>
     * @return El sueldo del Chofer para el mes actual.
     */
	public double getSueldo() {
		LocalDateTime fechaActual = LocalDateTime.now();
		return this.getSueldoNeto(fechaActual);
	}
	
	/**
     * Obtiene el sueldo del Chofer Permanente para un mes especifico.<br>
     * <b>PRE:</b> El parametro fecha no puede ser nulo.<br>
     * <b>POST:</b> Se devuelve el sueldo del Chofer Permanente para el mes especifico especificado por la fecha.<br>
     * @param fecha La fecha para la cual se calcula el sueldo.
     * @return El sueldo del Chofer para el mes especifico.
     */
	public double getSueldo(LocalDateTime fecha) {
		assert fecha != null : "El parametro fecha no puede ser nulo.";
		
		return this.getSueldoNeto(fecha);
	}
	
	/**
     * Obtiene el sueldo neto del Chofer Permanente para un mes especifico.<br>
	 * <b>PRE:</b> El parametro fecha no puede ser nulo.<br>
	 * <b>POST:</b> Se devuelve el sueldo neto del chofer para el mes especifico especificado por la fecha.<br>
     * @param fecha La fecha para la cual se calcula el sueldo.
     * @return El sueldo neto del chofer para el mes especifico.
     */
	public double getSueldoNeto(LocalDateTime fecha) {
		assert fecha != null : "El parametro fecha no puede ser nulo.";
		double sueldoBruto = getSueldoBruto(fecha);
        // Calcular los aportes jubilatorios
		return sueldoBruto - ( sueldoBruto * ( Asalariado.aportes / 100) );
	}
	
	/**
	 * Obtiene el sueldo bruto del Chofer Permanente para un mes especifico.<br>
	 * <b>PRE:</b> El parametro fecha no puede ser nulo.<br>
	 * <b>POST:</b> Se devuelve el sueldo bruto del chofer para el mes especifico especificado por la fecha.<br>
     * @param fecha La fecha para la cual se calcula el sueldo.
     * @return El sueldo bruto del chofer para la fecha dada.
     */
	public double getSueldoBruto(LocalDateTime fecha) {
		assert fecha != null : "El parametro fecha no puede ser nulo.";
		
		double sueldoBruto = sueldoBasico;
		
        //Calcula el plus por antigüedad
		double antiguedad = ChronoUnit.YEARS.between(fechaIngreso, fecha);
        double plusxAntiguedad = sueldoBasico * ( ChoferPermanente.plusAntiguedad / 100 ) * antiguedad;
        sueldoBruto += plusxAntiguedad;
        
        //Calcula el plus por cantidad de hijos
        double plusHijos = sueldoBasico * ( ChoferPermanente.plusXHijos / 100 ) * cantidadHijos;
        sueldoBruto += plusHijos;
        
        return sueldoBruto;
	}
	
// Getters y Setters
	
	/**
     * Obtiene el sueldo basico para los Choferes Permanentes.<br>
     * <b>POST:</b> Se devuelve el sueldo básico para los Choferes Permanentes.<br>
     * @return El sueldo basico para los Choferes Permanentes.
     */
	public static double getSueldobasico() 
	{
		return ChoferPermanente.sueldoBasico;
	}
	
	/**
     * Establece el sueldo básico para los Choferes Permanentes.<br>
     * <b>PRE:</b> El parámetro sueldobasico no puede ser negativo.<br>
     * <b>POST:</b> Se actualiza el sueldo basico para los Choferes Permanentes.<br>
     * @param sueldobasico El nuevo sueldo basico para los Choferes Permanentes.
     */
	public static void setSueldobasico(double sueldobasico)
	{
		assert sueldobasico >= 0 : "El sueldo básico no puede ser negativo.";
		ChoferPermanente.sueldoBasico = sueldobasico;
	}
	
	/**
     * Obtiene el porcentaje de plus por antigüedad para los Choferes Permanentes.<br>
     * <b>POST:</b> Se devuelve el porcentaje de plus por antigüedad para los Choferes Permanentes.<br>
     * @return El porcentaje de plus por antigüedad para los Choferes Permanentes.
     */
	public double getPlusAntiguedad() 
	{
		return ChoferPermanente.plusAntiguedad;
	}
	
	/**
     * Establece el porcentaje de plus por antigüedad para los Choferes Permanentes.<br>
     * <b>PRE:</b> El parametro porcentaje debe ser mayor que cero.<br>
     * <b>POST:</b> Se actualiza el porcentaje de plus por antigüedad para los Choferes Permanentes.<br>
     * @param porcentaje El nuevo porcentaje de plus por antigüedad para los Choferes Permanentes.
     */
	public void setPlusAntiguedad(double porcentaje) 
	{
	    assert porcentaje > 0 : "El porcentaje de plus por antigüedad debe ser mayor que cero.";
		ChoferPermanente.plusAntiguedad = porcentaje;
	}
	
	/**
     * Obtiene el porcentaje de plus por cantidad de hijos para los Choferes Permanentes.<br>
     * <b>POST:</b> Se devuelve el porcentaje de plus por cantidad de hijos para los Choferes Permanentes.<br>
     * @return El porcentaje de plus por cantidad de hijos para los Choferes Permanentes.
     */
	public double getPlusXHijos()
	{
		return ChoferPermanente.plusXHijos;
	}
	
	/**
     * Establece el porcentaje de plus por cantidad de hijos para los Choferes Permanentes.<br>
	 * <b>PRE:</b> El parámetro porcentaje no puede ser negativo.<br>
	 * <b>POST:</b> Se actualiza el porcentaje de plus por cantidad de hijos para los Choferes Permanentes.<br>
     * @param porcentaje El nuevo porcentaje de plus por cantidad de hijos para los Choferes Permanentes.
     */
	public void setPlusXHijos(double porcentaje) 
	{
	    assert porcentaje >= 0 : "El porcentaje de plus por cantidad de hijos no puede ser negativo.";

		ChoferPermanente.plusXHijos = porcentaje;
	}
	
	/**
     * Obtiene la fecha de ingreso del Chofer Permanente.<br>
     * <b>POST:</b> Se devuelve la fecha de ingreso del Chofer Permanente.<br>
     * @return La fecha de ingreso del Chofer Permanente.
     */
	public LocalDateTime getFechaIngreso()
	{
		return fechaIngreso;
	}
	
	/**
     * Establece la fecha de ingreso del Chofer Permanente.<br>
     * <b>PRE:</b> El parámetro fechaIngreso no puede ser nulo.<br>
	 * <b>POST:</b> Se actualiza la fecha de ingreso del Chofer Permanente.<br>
     * @param fechaIngreso La nueva fecha de ingreso del Chofer Permanente.
     */
	public void setFechaIngreso(LocalDateTime  fechaIngreso) 
	{
	    assert fechaIngreso != null : "La fecha de ingreso no puede ser nula.";

		this.fechaIngreso = fechaIngreso;
	}
	
	/**
     * Obtiene la cantidad de hijos del Chofer Permanente.<br>
     * <b>POST:</b> Se devuelve la cantidad de hijos del Chofer Permanente.<br>
     * @return La cantidad de hijos del Chofer Permanente.
     */
	public int getCantidadHijos()
	{
		return cantidadHijos;
	}
	
	/**
     * Establece la cantidad de hijos del Chofer Permanente.<br>
	 * <b>PRE:</b> El parámetro cantidadHijos no puede ser negativo.<br>
	 * <b>POST:</b> Se actualiza la cantidad de hijos del Chofer Permanente.<br>
     * @param cantidadHijos La nueva cantidad de hijos del Chofer Permanente.
     */
	public void setCantidadHijos(int cantidadHijos) 
	{
		assert cantidadHijos >= 0 : "La cantidad de hijos no puede ser negativa.";
		
		this.cantidadHijos = cantidadHijos;
	}
	
        @Override
	public ChoferPermanente clone() {
        try {
            ChoferPermanente clonado = (ChoferPermanente) super.clone();
            clonado.fechaIngreso = LocalDateTime.of(this.fechaIngreso.toLocalDate(), this.fechaIngreso.toLocalTime());
            return clonado;
        } 
        catch (CloneNotSupportedException e) {
        	//Nunca va a entrar
            throw new RuntimeException("Clone not supported", e);
        }
    }
	
}
