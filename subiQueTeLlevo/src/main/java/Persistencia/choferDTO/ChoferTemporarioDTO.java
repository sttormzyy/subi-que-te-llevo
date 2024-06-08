package Persistencia.choferDTO;

public class ChoferTemporarioDTO extends AsalariadoDTO
{
	// Esta clase esta preparada para futuras actualizaciones con atributos especificos
    // por ahora, hereda todas las propiedades de AsalariadoDTO
    // Atributos estaticos no se incluyen en el DTO ya que no son serializables.
	
	public ChoferTemporarioDTO() {
    }
	
	public ChoferTemporarioDTO(String dni, String nombre) {
    	super(dni, nombre);
    }
}	
