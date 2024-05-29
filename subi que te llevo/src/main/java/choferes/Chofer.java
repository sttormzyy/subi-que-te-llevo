package choferes;

import java.time.LocalDateTime;

/**
 * Clase abstracta que representa a un Chofer.
 */
public abstract class Chofer {
    protected String dni;
    protected String nombre;
    protected int puntos;
    protected Boolean ocupado = false;
    
// Constructor
    
    /**
     * Constructor de la clase Chofer.<br>
	 * <b>PRE:</b> Los parámetros dni y nombre no pueden ser nulos.<br>
     * @param dni El DNI del Chofer.
     * @param nombre El nombre del Chofer.
     */
    protected Chofer(String dni, String nombre) {
        assert dni != null && nombre != null : "El DNI y el nombre no pueden ser nulos.";
        this.dni = dni;
        this.nombre = nombre;
    }

// Metodos abstractos
    
    /**
     * Obtiene el sueldo del Chofer.<br>
     * @return El sueldo del Chofer.
     */
    public abstract double getSueldo(); 
    
    /**
     * Obtiene el sueldo del Chofer para una fecha especifica.<br>
     * @param fecha La fecha para la cual se calcula el sueldo.
     * @return El sueldo del Chofer para la fecha dada.
     */
    public abstract double getSueldo(LocalDateTime fecha);
    
// Getters y Setters
    
    /**
     * Obtiene el DNI del Chofer.<br>
	 * <b>POST:</b> Se devuelve el DNI del Chofer.<br>
     * @return El DNI del Chofer.
     */
    public String getDni() {
        return dni;
    }
    
    /**
     * Establece el DNI del Chofer.<br>
	 * <b>PRE:</b> El parámetro dni no puede ser nulo o vacío.<br>
	 * <b>POST:</b> Se actualiza el DNI del Chofer.
     * @param dni El nuevo DNI del Chofer.
     */
    public void setDni(String dni) {
    	assert dni != null && !dni.isEmpty() : "El DNI no puede ser nulo o vacío.";
        this.dni = dni;
    }

    /**
     * Obtiene el nombre del Chofer.<br>
     * <b>POST:</b> Se devuelve el nombre del Chofer.<br>
     * @return El nombre del Chofer.
     */
    public String getNombre() {
        return nombre;
    }
    
    /**
     * Establece el nombre del Chofer.<br>
	 * <b>PRE:</b> El parámetro nombre no puede ser nulo o vacío.<br>
	 * <b>POST:</b> Se actualiza el nombre del Chofer.
     * @param nombre El nuevo nombre del Chofer.
     */
    public void setNombre(String nombre) {
        assert nombre != null && !nombre.isEmpty() : "El nombre no puede ser nulo o vacío.";
        this.nombre = nombre;
    }

    /**
     * Obtiene los puntos acumulados del Chofer.<br>
     * <b>POST:</b> Se devuelve los puntos acumulados del Chofer.<br>
     * @return Los puntos acumulados del Chofer.
     */
    public int getPuntos() {
        return puntos;
    }
    
    /**
     * Agrega puntos al total acumulado del Chofer.<br>
	 * <b>PRE:</b> El parámetro puntos debe ser mayor o igual a cero.<br>
	 * <b>POST:</b> Se agregan los puntos especificados al total acumulado del Chofer.<br>
     * @param puntos Los puntos a agregar.
     */
    public void addPuntos(int puntos) {
    	assert puntos >= 0 : "Los puntos no pueden ser negativos.";
        this.puntos += puntos;
    }

    /**
     * Verifica si el Chofer esta ocupado.<br>
	 * <b>POST:</b> Se devuelve true si el Chofer está ocupado, false en caso contrario.<br>
     * @return true si el Chofer esta ocupado, false en caso contrario.
     */
    public Boolean isOcupado() {
        return ocupado;
    }
    
    /**
     * Establece el estado de ocupacion del Chofer.<br>
     * <b>POST:</b> Se actualiza el estado de ocupación del Chofer.<br>
     * @param ocupado El nuevo estado de ocupacion del Chofer.
     */
    public void setOcupado(Boolean ocupado) {
        this.ocupado = ocupado;
    }
	
// Otros metodos
    
    /**
     * Genera una representacion en formato de lista del Chofer.<br>
     * <b>POST:</b> Se devuelve una cadena de caracteres que representa al Chofer en un formato de lista.<br>
     * @return Una cadena de caracteres que representa al Chofer en un formato de lista.
     */
	public String toStringListado() {
        return String.format("%-20s %-20s %-10d", nombre, dni, puntos);
    }
    
	/**
     * Genera una representacion en formato de lista de los datos y el salario del Chofer para un mes especifico.<br>
     * <b>PRE:</b> La fecha no puede ser nula.<br>
	 * <b>POST:</b> Se devuelve una cadena de caracteres que representa al Chofer en un formato de lista de salarios.<br>
     * @param fecha La fecha para la cual se calcula el salario.
     * @return Una cadena de caracteres que representa al Chofer en un formato de lista de salarios.
     */
    public String toStringListadoSalarios(LocalDateTime fecha) {
    	assert fecha != null : "La fecha no puede ser nula.";
        return String.format("%-20s%-20s$%.2f", nombre, dni, this.getSueldo(fecha));
    }

    /**
     * Genera una representacion de los atributos del Chofer.<br>
     * <b>POST:</b> Se devuelve una cadena de caracteres que representa al Chofer.<br>
     * @return Una cadena de caracteres que representa al Chofer.
     */
	public String toString() {
		return "\nChofer: " + 
				"\nDni: " + dni + 
				"\nNombre: " + nombre + 
				"\nPuntos: " + puntos + 
				"\nOcupado: " + ocupado + "]";
	}
    
    
}