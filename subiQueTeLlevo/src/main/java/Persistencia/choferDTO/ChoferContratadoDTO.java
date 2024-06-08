package Persistencia.choferDTO;

public class ChoferContratadoDTO extends ChoferDTO
{
	// Esta clase esta preparada para futuras actualizaciones con atributos especificos
    // por ahora, hereda todas las propiedades de ChoferDTO
    // Atributos estaticos no se incluyen en el DTO ya que no son serializables.
	
	public ChoferContratadoDTO() {
	}
	
	public ChoferContratadoDTO(String dni, String nombre) {
		super(dni, nombre);
	}
	
	public ChoferContratadoDTO(String dni, String nombre, int puntos, boolean ocupado) {
		super(dni, nombre, puntos, ocupado);
	}
}
