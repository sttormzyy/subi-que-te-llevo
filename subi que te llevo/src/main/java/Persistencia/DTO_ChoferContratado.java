package Persistencia;

public class DTO_ChoferContratado extends DTO_Chofer
{
	private static double gananciaViaje = 25;

	public static double getGananciaViaje() {
		return gananciaViaje;
	}

	public static void setGananciaViaje(double gananciaViaje) {
		DTO_ChoferContratado.gananciaViaje = gananciaViaje;
	}  
}
