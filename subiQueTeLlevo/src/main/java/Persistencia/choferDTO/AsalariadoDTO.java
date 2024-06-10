package Persistencia.choferDTO;

/**
 * La clase AsalariadoDTO es una clase abstracta que extiende la clase ChoferDTO.
 * Esta clase está preparada para futuras actualizaciones con atributos específicos.
 * Por ahora, hereda todas las propiedades de ChoferDTO.
 * Los atributos estáticos no se incluyen en el DTO ya que no son serializables.
 */
public abstract class AsalariadoDTO extends ChoferDTO {
    
    /**
     * Constructor por defecto de la clase AsalariadoDTO.
     */
    public AsalariadoDTO() {
    }
    
    /**
     * Constructor de la clase AsalariadoDTO que inicializa el DNI y el nombre del asalariado.
     * 
     * @param dni El DNI del asalariado.
     * @param nombre El nombre del asalariado.
     */
    public AsalariadoDTO(String dni, String nombre) {
        super(dni, nombre);
    }
    
    /**
     * Constructor de la clase AsalariadoDTO que inicializa todos los atributos del asalariado.
     * 
     * @param dni El DNI del asalariado.
     * @param nombre El nombre del asalariado.
     * @param puntos Los puntos acumulados del asalariado.
     * @param ocupado Indica si el asalariado está ocupado o no.
     */
    public AsalariadoDTO(String dni, String nombre, int puntos, Boolean ocupado) {
        super(dni, nombre, puntos, ocupado);
    }
}

