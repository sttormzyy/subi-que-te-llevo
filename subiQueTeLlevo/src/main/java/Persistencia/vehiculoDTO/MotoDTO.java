package Persistencia.vehiculoDTO;

public class MotoDTO extends VehiculoDTO
{
	// Esta clase esta preparada para futuras actualizaciones con atributos especificos
    // por ahora, hereda todos los atributos de VehiculoDTO
	
	public MotoDTO() {
    }
	
	public MotoDTO(String patente) {
		super(patente, 1, 0, 0);
    }
}
