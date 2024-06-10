package Persistencia.vehiculoDTO;

import java.io.Serializable;

/**
 * La clase VehiculoDTO es una clase que representa un vehiculo en forma de DTO (Data Transfer Object).
 * Contiene informacion sobre la patente, la cantidad maxima de pasajeros, la capacidad para mascotas y equipaje,
 * y el estado de ocupacion del vehiculo.
 */
public class VehiculoDTO implements Serializable {
    
    protected String patente;          
    protected int cantMaxPas;         
    protected boolean ocupado = false; 
    protected int mascota;            
    protected int equipaje;           
    
    /**
     * Constructor por defecto de la clase VehiculoDTO.
     */
    public VehiculoDTO() {
    }

    /**
     * Constructor de la clase VehiculoDTO que inicializa la patente, la cantidad maxima de pasajeros,
     * la capacidad para mascotas y la capacidad para equipaje del vehiculo.
     * 
     * @param patente La patente del vehiculo.
     * @param cantMaxPas La cantidad maxima de pasajeros del vehiculo.
     * @param mascota La capacidad para mascotas del vehiculo.
     * @param equipaje La capacidad para equipaje del vehiculo.
     */
    public VehiculoDTO(String patente, int cantMaxPas, int mascota, int equipaje) {
        this.patente = patente;
        this.cantMaxPas = cantMaxPas;
        this.mascota = mascota;
        this.equipaje = equipaje;
    }
	
    /**
     * Obtiene la patente del vehiculo.
     * 
     * @return La patente del vehiculo.
     */
    public String getPatente() {
        return patente;
    }
	
    /**
     * Establece la patente del vehiculo.
     * 
     * @param patente La nueva patente del vehiculo.
     */
    public void setPatente(String patente) {
        this.patente = patente;
    }
	
    /**
     * Obtiene la cantidad maxima de pasajeros del vehiculo.
     * 
     * @return La cantidad maxima de pasajeros del vehiculo.
     */
    public int getCantMaxPas() {
        return cantMaxPas;
    }
	
    /**
     * Establece la cantidad maxima de pasajeros del vehiculo.
     * 
     * @param cantMaxPas La nueva cantidad maxima de pasajeros del vehiculo.
     */
    public void setCantMaxPas(int cantMaxPas) {
        this.cantMaxPas = cantMaxPas;
    }
	
    /**
     * Verifica si el vehiculo esta ocupado.
     * 
     * @return true si el vehiculo esta ocupado, false en caso contrario.
     */
    public boolean isOcupado() {
        return ocupado;
    }
	
    /**
     * Establece el estado de ocupacion del vehiculo.
     * 
     * @param ocupado El nuevo estado de ocupacion del vehiculo.
     */
    public void setOcupado(boolean ocupado) {
        this.ocupado = ocupado;
    }
	
    /**
     * Obtiene la capacidad para mascotas del vehiculo.
     * 
     * @return La capacidad para mascotas del vehiculo.
     */
    public int getMascota() {
        return mascota;
    }
	
    /**
     * Establece la capacidad para mascotas del vehiculo.
     * 
     * @param mascota La nueva capacidad para mascotas del vehiculo.
     */
    public void setMascota(int mascota) {
        this.mascota = mascota;
    }
	
    /**
     * Obtiene la capacidad para equipaje del vehiculo.
     * 
     * @return La capacidad para equipaje del vehiculo.
     */
    public int getEquipaje() {
        return equipaje;
    }
	
    /**
     * Establece la capacidad para equipaje del vehiculo.
     * 
     * @param equipaje La nueva capacidad para equipaje del vehiculo.
     */
    public void setEquipaje(int equipaje) {
        this.equipaje = equipaje;
    }
}

