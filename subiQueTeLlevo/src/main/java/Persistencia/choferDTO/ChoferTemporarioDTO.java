package Persistencia.choferDTO;

/**
 * La clase ChoferTemporarioDTO es una clase que extiende la clase AsalariadoDTO.
 * Representa a un Chofer Temporario.
 * 
 * Esta clase está preparada para futuras actualizaciones con atributos específicos.
 * Por ahora, hereda todas las propiedades de AsalariadoDTO.
 * Los atributos estáticos no se incluyen en el DTO ya que no son serializables.
 */
public class ChoferTemporarioDTO extends AsalariadoDTO {
    
    /**
     * Constructor por defecto de la clase ChoferTemporarioDTO.
     */
    public ChoferTemporarioDTO() {
    }
    
    /**
     * Constructor de la clase ChoferTemporarioDTO que inicializa el DNI y el nombre del Chofer Temporario.
     * 
     * @param dni El DNI del Chofer Temporario.
     * @param nombre El nombre del Chofer Temporario.
     */
    public ChoferTemporarioDTO(String dni, String nombre) {
        super(dni, nombre);
    }
}
