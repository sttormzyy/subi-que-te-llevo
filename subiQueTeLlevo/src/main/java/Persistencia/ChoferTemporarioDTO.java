package Persistencia;

public class ChoferTemporarioDTO extends AsalariadoDTO
{
	private static double sueldoBasico=2000;
    private static int cantidadViajesParaPlus = 40;
    private static double plusXCantidadViajes = 10;       
    private static double aportes;
    
	public static double getSueldoBasico() {
		return sueldoBasico;
	}
	public static void setSueldoBasico(double sueldoBasico) {
		ChoferTemporarioDTO.sueldoBasico = sueldoBasico;
	}
	public static int getCantidadViajesParaPlus() {
		return cantidadViajesParaPlus;
	}
	public static void setCantidadViajesParaPlus(int cantidadViajesParaPlus) {
		ChoferTemporarioDTO.cantidadViajesParaPlus = cantidadViajesParaPlus;
	}
	public static double getPlusXCantidadViajes() {
		return plusXCantidadViajes;
	}
	public static void setPlusXCantidadViajes(double plusXCantidadViajes) {
		ChoferTemporarioDTO.plusXCantidadViajes = plusXCantidadViajes;
	}
	public static double getAportes() {
		return aportes;
	}
	public static void setAportes(double aportes) {
		ChoferTemporarioDTO.aportes = aportes;
	}
    
}	
