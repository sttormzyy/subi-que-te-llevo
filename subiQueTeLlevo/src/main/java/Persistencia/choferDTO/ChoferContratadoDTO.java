package Persistencia.choferDTO;

/**
 * La clase ChoferContratadoDTO es una clase que extiende la clase ChoferDTO.
 * Esta clase está preparada para futuras actualizaciones con atributos específicos.
 * Por ahora, hereda todas las propiedades de ChoferDTO.
 * Los atributos estáticos no se incluyen en el DTO ya que no son serializables.
 */
public class ChoferContratadoDTO extends ChoferDTO {
    
    /**
     * Constructor por defecto de la clase ChoferContratadoDTO.
     */
    public ChoferContratadoDTO() {
    }
    
    /**
     * Constructor de la clase ChoferContratadoDTO que inicializa el DNI y el nombre del Chofer Contratado.
     * 
     * @param dni El DNI del Chofer Contratado.
     * @param nombre El nombre del Chofer Contratado.
     */
    public ChoferContratadoDTO(String dni, String nombre) {
        super(dni, nombre);
    }
    
    /**
     * Constructor de la clase ChoferContratadoDTO que inicializa todos los atributos del Chofer Contratado.
     * 
     * @param dni El DNI del Chofer Contratado.
     * @param nombre El nombre del Chofer Contratado.
     * @param puntos Los puntos acumulados del Chofer Contratado.
     * @param ocupado Indica si el Chofer Contratado está ocupado o no.
     */
    public ChoferContratadoDTO(String dni, String nombre, int puntos, boolean ocupado) {
        super(dni, nombre, puntos, ocupado);
    }
}

