package Persistencia;

import java.time.LocalDateTime;

import sistema.Empresa;

public class DTO_ChoferTemporario  extends DTO_Asalariado
{
	private static double sueldoBasico=2000;
    private static int cantidadViajesParaPlus = 40;
    private static double plusXCantidadViajes = 10;       
    private static double aportes;
    
	public static double getSueldoBasico() {
		return sueldoBasico;
	}
	public static void setSueldoBasico(double sueldoBasico) {
		DTO_ChoferTemporario.sueldoBasico = sueldoBasico;
	}
	public static int getCantidadViajesParaPlus() {
		return cantidadViajesParaPlus;
	}
	public static void setCantidadViajesParaPlus(int cantidadViajesParaPlus) {
		DTO_ChoferTemporario.cantidadViajesParaPlus = cantidadViajesParaPlus;
	}
	public static double getPlusXCantidadViajes() {
		return plusXCantidadViajes;
	}
	public static void setPlusXCantidadViajes(double plusXCantidadViajes) {
		DTO_ChoferTemporario.plusXCantidadViajes = plusXCantidadViajes;
	}
	public static double getAportes() {
		return aportes;
	}
	public static void setAportes(double aportes) {
		DTO_ChoferTemporario.aportes = aportes;
	}
    
}	
