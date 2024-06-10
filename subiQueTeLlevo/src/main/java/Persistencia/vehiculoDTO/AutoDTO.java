package Persistencia.vehiculoDTO;

/**
 * La clase AutoDTO es una clase que representa un auto en forma de DTO (Data Transfer Object).
 * Por ahora, hereda todos los atributos de la clase VehiculoDTO.
 */
public class AutoDTO extends VehiculoDTO {
    
    /**
     * Constructor por defecto de la clase AutoDTO.
     */
    public AutoDTO() {
    }

    /**
     * Constructor de la clase AutoDTO que inicializa la patente del auto y establece la cantidad máxima de pasajeros como 4, la capacidad para mascotas como 1 y la capacidad para equipaje como 1.
     * 
     * @param patente La patente del auto.
     */
    public AutoDTO(String patente) {
        super(patente, 4, 1, 1);
    }
}
