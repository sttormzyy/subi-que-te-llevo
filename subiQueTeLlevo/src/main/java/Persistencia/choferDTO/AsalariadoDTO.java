package Persistencia.choferDTO;

public abstract class AsalariadoDTO extends ChoferDTO
{
	// Esta clase esta preparada para futuras actualizaciones con atributos especificos
    // por ahora, hereda todas las propiedades de ChoferDTO
    // Atributos estaticos no se incluyen en el DTO ya que no son serializables.
	
    public AsalariadoDTO() {
    }
    
    public AsalariadoDTO(String dni, String nombre) {
    	super(dni, nombre);
    }
    
	public AsalariadoDTO(String dni, String nombre, int puntos, Boolean ocupado) {
		super(dni, nombre, puntos, ocupado);
	}
	
}
