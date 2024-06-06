package Persistencia;

public class ChoferContratadoDTO extends ChoferDTO
{
	private static double gananciaViaje = 25;

	public static double getGananciaViaje() {
		return gananciaViaje;
	}

	public static void setGananciaViaje(double gananciaViaje) {
		ChoferContratadoDTO.gananciaViaje = gananciaViaje;
	}  
}
