package Persistencia.vehiculoDTO;

/**
 * La clase CombiDTO es una clase que representa una combi en forma de DTO (Data Transfer Object).
 * Por ahora, hereda todos los atributos de la clase VehiculoDTO.
 */
public class CombiDTO extends VehiculoDTO {
    
    /**
     * Constructor por defecto de la clase CombiDTO.
     */
    public CombiDTO() {
    }
    
    /**
     * Constructor de la clase CombiDTO que inicializa la patente de la combi y establece la cantidad máxima de pasajeros como 10, la capacidad para mascotas como 0 y la capacidad para equipaje como 1.
     * 
     * @param patente La patente de la combi.
     */
    public CombiDTO(String patente) {
        super(patente, 10, 0, 1);
    }
}
