package Persistencia.choferDTO;

import java.io.Serializable;

/**
 * La clase ChoferDTO representa un objeto de transferencia de datos (DTO) que contiene informacion sobre un chofer.
 * Esta clase implementa la interfaz Serializable para permitir la serialización.
 */
public class ChoferDTO implements Serializable {
    
    protected String dni;       
    protected String nombre;    
    protected int puntos;      
    protected Boolean ocupado = false;  
    
    /**
     * Constructor por defecto de la clase ChoferDTO.
     */
    public ChoferDTO() {
    }
    
    /**
     * Constructor de la clase ChoferDTO que inicializa el DNI y el nombre del chofer.
     * 
     * @param dni El DNI del chofer.
     * @param nombre El nombre del chofer.
     */
    public ChoferDTO(String dni, String nombre) {
        this.dni = dni;
        this.nombre = nombre;
    }
    
    /**
     * Constructor de la clase ChoferDTO que inicializa todos los atributos del chofer.
     * 
     * @param dni El DNI del chofer.
     * @param nombre El nombre del chofer.
     * @param puntos Los puntos acumulados del chofer.
     * @param ocupado Indica si el chofer está ocupado o no.
     */
    public ChoferDTO(String dni, String nombre, int puntos, Boolean ocupado) {
        this.dni = dni;
        this.nombre = nombre;
        this.puntos = puntos;
        this.ocupado = ocupado;
    }
    
    /**
     * Obtiene el DNI del chofer.
     * 
     * @return El DNI del chofer.
     */
    public String getDni() {
        return dni;
    }
    
    /**
     * Establece el DNI del chofer.
     * 
     * @param dni El nuevo DNI del chofer.
     */
    public void setDni(String dni) {
        this.dni = dni;
    }
    
    /**
     * Obtiene el nombre del chofer.
     * 
     * @return El nombre del chofer.
     */
    public String getNombre() {
        return nombre;
    }
    
    /**
     * Establece el nombre del chofer.
     * 
     * @param nombre El nuevo nombre del chofer.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    /**
     * Obtiene los puntos acumulados del chofer.
     * 
     * @return Los puntos acumulados del chofer.
     */
    public int getPuntos() {
        return puntos;
    }
    
    /**
     * Establece los puntos acumulados del chofer.
     * 
     * @param puntos Los nuevos puntos acumulados del chofer.
     */
    public void setPuntos(int puntos) {
        this.puntos = puntos;
    }
    
    /**
     * Obtiene el estado de ocupación del chofer.
     * 
     * @return true si el chofer está ocupado, false si no lo está.
     */
    public Boolean getOcupado() {
        return ocupado;
    }
    
    /**
     * Establece el estado de ocupación del chofer.
     * 
     * @param ocupado true si el chofer está ocupado, false si no lo está.
     */
    public void setOcupado(Boolean ocupado) {
        this.ocupado = ocupado;
    }
}

