package Persistencia.choferDTO;

import Persistencia.LocalDateTimeDTO;

/**
 * La clase ChoferPermanenteDTO es una clase que extiende la clase AsalariadoDTO.
 * Representa a un Chofer Permanente.
 * 
 * Hereda todas las propiedades de AsalariadoDTO y agrega información específica para un Chofer Permanente,
 * como la cantidad de hijos y la fecha de ingreso.
 */
public class ChoferPermanenteDTO extends AsalariadoDTO {
    
    private int cantidadHijos;           
    private LocalDateTimeDTO fechaIngresoDTO; 
    
    /**
     * Constructor por defecto de la clase ChoferPermanenteDTO.
     */
    public ChoferPermanenteDTO() {
    }
    
    /**
     * Constructor de la clase ChoferPermanenteDTO que inicializa el DNI, el nombre, la cantidad de hijos
     * y la fecha de ingreso del Chofer Permanente.
     * 
     * @param dni El DNI del Chofer Permanente.
     * @param nombre El nombre del Chofer Permanente.
     * @param cantHijos La cantidad de hijos del Chofer Permanente.
     * @param fechaIngreso La fecha de ingreso del Chofer Permanente.
     */
    public ChoferPermanenteDTO(String dni, String nombre, int cantHijos, LocalDateTimeDTO fechaIngreso) {
        super(dni, nombre);
        this.cantidadHijos = cantHijos;
        this.fechaIngresoDTO = fechaIngreso;
    }

    /**
     * Constructor de la clase ChoferPermanenteDTO que inicializa todos los atributos del Chofer Permanente.
     * 
     * @param dni El DNI del Chofer Permanente.
     * @param nombre El nombre del Chofer Permanente.
     * @param puntos Los puntos acumulados del Chofer Permanente.
     * @param ocupado Indica si el Chofer Permanente está ocupado o no.
     * @param cantidadHijos La cantidad de hijos del Chofer Permanente.
     * @param fechaIngreso La fecha de ingreso del Chofer Permanente.
     */
    public ChoferPermanenteDTO(String dni, String nombre, int puntos, Boolean ocupado, int cantidadHijos, LocalDateTimeDTO fechaIngreso) {
        super(dni, nombre, puntos, ocupado);
        this.cantidadHijos = cantidadHijos;
        this.fechaIngresoDTO = fechaIngreso;
    }
    
    /**
     * Obtiene la cantidad de hijos del Chofer Permanente.
     * 
     * @return La cantidad de hijos del Chofer Permanente.
     */
    public int getCantidadHijos() {
        return cantidadHijos;
    }
    
    /**
     * Establece la cantidad de hijos del Chofer Permanente.
     * 
     * @param cantidadHijos La nueva cantidad de hijos del Chofer Permanente.
     */
    public void setCantidadHijos(int cantidadHijos) {
        this.cantidadHijos = cantidadHijos;
    }
    
    /**
     * Obtiene la fecha de ingreso del Chofer Permanente.
     * 
     * @return La fecha de ingreso del Chofer Permanente.
     */
    public LocalDateTimeDTO getFechaIngresoDTO() {
        return fechaIngresoDTO;
    }
    
    /**
     * Establece la fecha de ingreso del Chofer Permanente.
     * 
     * @param fechaIngresoDTO La nueva fecha de ingreso del Chofer Permanente.
     */
    public void setFechaIngresoDTO(LocalDateTimeDTO fechaIngresoDTO) {
        this.fechaIngresoDTO = fechaIngresoDTO;
    }
}


