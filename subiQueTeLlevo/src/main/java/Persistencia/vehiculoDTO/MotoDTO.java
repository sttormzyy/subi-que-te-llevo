package Persistencia.vehiculoDTO;

/**
 * La clase MotoDTO es una clase que representa una moto en forma de DTO (Data Transfer Object).
 * Por ahora, hereda todos los atributos de la clase VehiculoDTO.
 */
public class MotoDTO extends VehiculoDTO {
    
    /**
     * Constructor por defecto de la clase MotoDTO.
     */
    public MotoDTO() {
    }
    
    /**
     * Constructor de la clase MotoDTO que inicializa la patente de la moto y establece la cantidad máxima de pasajeros, la capacidad para mascotas y equipaje como 0.
     * 
     * @param patente La patente de la moto.
     */
    public MotoDTO(String patente) {
        super(patente, 1, 0, 0);
    }
}
