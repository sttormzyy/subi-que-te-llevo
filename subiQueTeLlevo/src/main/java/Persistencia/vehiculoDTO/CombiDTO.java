package Persistencia.vehiculoDTO;

public class CombiDTO extends VehiculoDTO
{
	// Esta clase esta preparada para futuras actualizaciones con atributos especificos
    // por ahora, hereda todos los atributos de VehiculoDTO
	
	public CombiDTO() {
    }
	
	public CombiDTO(String patente) {
        super(patente, 10, 0, 1);
    }
}
