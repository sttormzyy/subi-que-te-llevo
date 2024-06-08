package Persistencia.vehiculoDTO;

public class AutoDTO extends VehiculoDTO
{
	// Esta clase esta preparada para futuras actualizaciones con atributos especificos
    // por ahora, hereda todos los atributos de VehiculoDTO
	
	public AutoDTO() {
    }

    public AutoDTO(String patente) {
    	super(patente, 4, 1, 1);
    }
}
