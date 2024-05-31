package choferes;

import java.time.LocalDateTime;

/**
 * Clase abstracta de la que se extenderan las subclases de Chofer con sueldos Brutos y Netos.
 */
public abstract class Asalariado extends Chofer {
    protected static double sueldoBasico=2000;
    protected double aportes;
    
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



// Metodos abstractos
    
    /**
     * Obtiene el sueldo neto del chofer para un mes especifico.<br>
     * @param fecha La fecha para la cual se calcula el sueldo.
     * @return El sueldo neto del chofer para la fecha dada.
     */
    public abstract double getSueldoNeto(LocalDateTime fecha);
    
    /**
     * Obtiene el sueldo bruto del chofer asalariado para un mes especifico.<br>
     * @param fecha La fecha para la cual se calcula el sueldo.
     * @return El sueldo bruto del chofer para la fecha dada.
     */
    public abstract double getSueldoBruto(LocalDateTime fecha);
    
    
}
